import java.util.List;
import java.util.Scanner;

public class MethodesBotFacile {

    // Méthode pour jouer un tour
    public static void jouerTourAvecBot(Scanner scanner, List<String> pions, String[][] plateau, TourJoueurBot tourBot) {
        String choixPions;
        int ligne;
        int col;

        // Demander au joueur de choisir un pion
        if (tourBot == TourJoueurBot.JOUEUR) {
            System.out.println("\u001B[34mÀ vous de choisir un pion !\u001B[0m");
            choixPions = MethodesJoueur.demanderChoixPions(scanner, pions);
        }
        else {
            System.out.println("\u001B[34mAu Bot de choisir un pion !\u001B[0m");
            choixPions = MethodesBotFacile.choisirPionAuHasard(pions);
            Utilitaires.loading();
            System.out.println("\u001B[34mLe Bot a choisi \u001B[0m" + choixPions);
        }

        // Retirer le pion choisi de la liste
        Utilitaires.prendrePions(pions, choixPions);
        System.out.println(pions);

        // Demander a l'autre joueur de choisir une position sur le plateau
        if (tourBot == TourJoueurBot.JOUEUR) {
            System.out.println("\u001B[34mLe Bot place le pion !\u001B[0m");
            Utilitaires.loading();

            // Le Bot place le pion choisi sur le plateau
            MethodesBotFacile.placerPionAuHasard(plateau, choixPions);
            Plateau.afficherPlateau(plateau);
        } else {
            System.out.println("\u001B[34mJoueur 1 placez le pion  !\u001B[0m");
            int[] position = MethodesJoueur.demanderPositionSurPlateau(scanner, plateau);
            ligne = position[0];
            col = position[1];
            // Placer le pion choisi sur le plateau
            plateau[ligne-1][col-1] = choixPions;
            Plateau.afficherPlateau(plateau);
        }

    }
    public static String choisirPionAuHasard(List<String> pions) {
        return pions.get((int) (Math.random() * pions.size()));
    }

    public static void placerPionAuHasard(String[][] plateau, String choixPions) {
        int ligne = -1;
        int col = -1;

        do {
            ligne = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        } while (!plateau[ligne][col].equals("0000"));

        plateau[ligne][col] = choixPions;
    }

    public static boolean verifierVictoireAvecBot(String[][] plateau, TourJoueurBot tour) {
        // Vérifier les lignes, les colonnes et les diagonales pour une combinaison gagnante
        if (MethodesVictoires.verifierLignes(plateau) || MethodesVictoires.verifierColonnes(plateau) || MethodesVictoires.verifierDiagonales(plateau)) {
            if (tour == TourJoueurBot.JOUEUR)
                System.out.println("Vous avez gagné !");
            else
                System.out.println("Le Bot a gagné !");
            return true;
        }

        // Vérifier si le plateau est plein (match nul)
        if (MethodesVictoires.plateauPlein(plateau)) {
            System.out.println("Match nul !");
            return true;
        }

        // Aucune condition de victoire n'est remplie
        return false;
    }
}
