import java.util.List;
import java.util.Scanner;

public class MethodesBot {

    // Méthode pour jouer un tour
    public static void jouerTourAvecBot(Scanner scanner, List<String> pions, String[][] plateau, TourJoueurBot tour) {
        // Demander au joueur de choisir un pion
        String choixPions = MethodesJoueur.demanderChoixPions(scanner, pions);

        // Retirer le pion choisi de la liste
        Utilitaires.prendrePions(pions, choixPions);
        System.out.println(pions);

        // Demander a l'autre joueur de choisir une position sur le plateau
        if (tour == TourJoueurBot.JOUEUR) {
            System.out.println("\u001B[34mLe Bot choisit un pion !\u001B[0m");
        } else {
            System.out.println("\u001B[34mJoueur 1 choisissez un pion !\u001B[0m");
        }
        int[] position = MethodesJoueur.demanderPositionSurPlateau(scanner, plateau);
        int ligne = position[0];
        int col = position[1];

        // Placer le pion choisi sur le plateau
        plateau[ligne-1][col-1] = choixPions;
        Plateau.afficherPlateau(plateau);
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
