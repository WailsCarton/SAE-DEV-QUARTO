import java.util.List;
import java.util.Scanner;

public class MethodesBotNormal {

    private static int[] dernierePositionJoueur;

    // Méthode pour jouer un tour
    public static void jouerTourAvecBot(Scanner scanner, List<String> pions, String[][] plateau, TourJoueurBot tourBot) {
        String choixPions;
        int ligne;
        int col;

        // Demander aux joueurs de choisir un pion
        if (tourBot == TourJoueurBot.JOUEUR) {
            // Le joueur choisit un pion
            System.out.println("\u001B[34mÀ vous de choisir un pion !\u001B[0m");
            choixPions = MethodesJoueur.demanderChoixPions(scanner, pions);
        } else {
            // Le Bot choisit un pion
            System.out.println("\u001B[34mAu Bot de choisir un pion !\u001B[0m");
            choixPions = choisirPionAuHasard(pions);
            Utilitaires.loading();
            System.out.println("\u001B[34mLe Bot a choisi \u001B[0m" + choixPions);
        }

        // Retirer le pion choisi par le Bot de la liste
        Utilitaires.prendrePions(pions, choixPions);
        System.out.println(pions);

        // Placement des pions
        if (tourBot == TourJoueurBot.JOUEUR) {
            // Le Bot place le pion choisi sur le plateau
            System.out.println("\u001B[34mLe Bot place le pion !\u001B[0m");
            Utilitaires.loading();

            // Si la position du dernier pion du joueur est trouvée, placer à côté de cette position
            if (dernierePositionJoueur != null) {
                ligne = dernierePositionJoueur[0];
                col = dernierePositionJoueur[1];
                placerPionNormal(plateau, choixPions, ligne, col);
            } else {
                // Si aucun pion n'a été posé, placer au hasard
                placerPionAuHasard(plateau, choixPions);
            }

            Plateau.afficherPlateau(plateau);
        } else {

            // Le joueur place le pion choisi par le Bot sur le plateau
            System.out.println("\u001B[34mPlacez le pion  !\u001B[0m");
            int[] position = MethodesJoueur.demanderPositionSurPlateau(scanner, plateau);
            ligne = position[0];
            col = position[1];

            // Placer le pion choisi sur le plateau
            plateau[ligne - 1][col - 1] = choixPions;
            Plateau.afficherPlateau(plateau);

            // Mettre à jour la position du dernier pion du joueur
            dernierePositionJoueur = new int[]{ligne, col};
        }
    }
    public static String choisirPionAuHasard(List<String> pions) {
        return pions.get((int) (Math.random() * pions.size()));
    }

    public static void placerPionNormal(String[][] plateau, String choixPions, int ligneJoueur, int colJoueur) {
        int ligne;
        int col;

        // Essayer de placer le pion autour du pion posé par le joueur
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                ligne = ligneJoueur-1 + i;
                col = colJoueur-1 + j;
                // Vérifier si la position est valide et libre
                if (ligne >= 0 && ligne < plateau.length && col >= 0 && col < plateau[0].length && plateau[ligne][col].equals("0000")) {
                    plateau[ligne][col] = choixPions;
                    return; // Sortir de la méthode après avoir placé le pion
                }
            }
        }

    }

    public static void placerPionAuHasard(String[][] plateau, String choixPions) {
        int ligne;
        int col;

        do {
            ligne = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        } while (!plateau[ligne][col].equals("0000"));

        plateau[ligne][col] = choixPions;
    }

}
