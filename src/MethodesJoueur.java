import java.util.List;
import java.util.Scanner;

public class MethodesJoueur {

    // Demander au joueur de choisir un pion
    public static String demanderChoixPions(Scanner scanner, List<String> pions) {
        String choixPions;
        do {
            System.out.print("\u001B[34mLe pion : \u001B[0m");
            choixPions = scanner.nextLine();
            if (!pions.contains(choixPions)) {
                System.out.println("\u001B[31mPion invalide. Veuillez réessayer.\u001B[0m");
            }
        } while (!pions.contains(choixPions));
        return choixPions;
    }


    public static int[] demanderPositionSurPlateau(Scanner scanner, String[][] plateau) {
        int ligne;
        int col;

        do {
            ligne = demanderLigne(scanner, plateau);
            col = demanderColonne(scanner, plateau, ligne);

            if (!plateau[ligne-1][col-1].equals("0000")) {
                System.out.println("\u001B[31mDéjà pris. Veuillez choisir une autre position.\u001B[0m");
            }

        } while (!plateau[ligne-1][col-1].equals("0000"));

        return new int[]{ligne, col};
    }



    // Demander au joueur de choisir une ligne sur le plateau
    public static int demanderLigne(Scanner scanner, String[][] plateau) {
        int ligne;
        do {
            System.out.print("\u001B[34mQuelle ligne ? \u001B[0m");
            ligne = Utilitaires.getIntInput(scanner);
            if (ligne < 1 || ligne >= plateau.length+1) {
                System.out.println("\u001B[31mLigne invalide. Veuillez réessayer.\u001B[0m");
            }
        } while (ligne < 1 || ligne >= plateau.length+1);
        return ligne;
    }

    // Demander au joueur de choisir une colonne sur le plateau
    public static int demanderColonne(Scanner scanner, String[][] plateau, int ligne) {
        int col;
        do {
            System.out.print("\u001B[34mQuelle colonne ? \u001B[0m");
            col = Utilitaires.getIntInput(scanner);
            if (col < 1 || col >= plateau[ligne-1].length+1) {
                System.out.println("\u001B[31mColonne invalide. Veuillez réessayer.\u001B[0m");
            }
        } while (col < 1 || col >= plateau[ligne-1].length+1);
        return col;
    }

    // Méthode pour jouer un tour
    public static void jouerTour(Scanner scanner, List<String> pions, String[][] plateau, TourJoueur tour) {

        // Demander au joueur de choisir un pion
        if (tour == TourJoueur.JOUEUR_1) {
            System.out.println("\u001B[34mJoueur 1 choisissez un pion !\u001B[0m");
        } else {
            System.out.println("\u001B[34mJoueur 2 choisissez un pion !\u001B[0m");
        }
        String choixPions = MethodesJoueur.demanderChoixPions(scanner, pions);

        // Retirer le pion choisi de la liste
        Utilitaires.prendrePions(pions, choixPions);
        System.out.println(pions);

        Utilitaires.wait(1000);

        // Demander a l'autre joueur de choisir une position sur le plateau
        if (tour == TourJoueur.JOUEUR_1) {
            System.out.println("\u001B[34mJoueur 2 placez le pion !\u001B[0m");
        } else {
            System.out.println("\u001B[34mJoueur 1 placez le pion !\u001B[0m");
        }
        int[] position = MethodesJoueur.demanderPositionSurPlateau(scanner, plateau);
        int ligne = position[0];
        int col = position[1];

        Utilitaires.wait(1000);

        // Placer le pion choisi sur le plateau
        plateau[ligne-1][col-1] = choixPions;
        Plateau.afficherPlateau(plateau);
    }
}
