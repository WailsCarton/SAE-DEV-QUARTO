import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MethodesJoueur {
    // Initialiser la liste des pions
    public static List<String> initialiserPions() {
        return new ArrayList<>(Arrays.asList(
                "NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"
        ));
    }

    // Demander au joueur de choisir un pion
    public static String demanderChoixPions(Scanner scanner, List<String> pions) {
        String choixPions;
        do {
            System.out.print("Le pion : ");
            choixPions = scanner.nextLine();
            if (!pions.contains(choixPions)) {
                System.out.println("\u001B[31mPion invalide. Veuillez réessayer.\u001B[0m");
            }
        } while (!pions.contains(choixPions));
        return choixPions;
    }

    // Retirer le pion choisi de la liste
    public static void prendrePions(List<String> pions, String choixPions) {
        pions.remove(choixPions);
    }


    public static int[] demanderPositionSurPlateau(Scanner scanner, String[][] plateau) {
        int ligne;
        int col;

        do {
            ligne = demanderLigne(scanner, plateau);
            col = demanderColonne(scanner, plateau, ligne);

            if (!plateau[ligne][col].equals("0000")) {
                System.out.println("\u001B[31mDéjà pris. Veuillez choisir une autre position.\u001B[0m");
            }

        } while (!plateau[ligne][col].equals("0000"));

        return new int[]{ligne, col};
    }



    // Demander au joueur de choisir une ligne sur le plateau
    public static int demanderLigne(Scanner scanner, String[][] plateau) {
        int ligne;
        do {
            System.out.print("Quelle ligne ? ");
            ligne = Utilitaires.getIntInput(scanner);
            if (ligne < 0 || ligne >= plateau.length) {
                System.out.println("\u001B[31mLigne invalide. Veuillez réessayer.\u001B[0m");
            }
        } while (ligne < 0 || ligne >= plateau.length);
        return ligne;
    }

    // Demander au joueur de choisir une colonne sur le plateau
    public static int demanderColonne(Scanner scanner, String[][] plateau, int ligne) {
        int col;
        do {
            System.out.print("Quelle colonne ? ");
            col = Utilitaires.getIntInput(scanner);
            if (col < 0 || col >= plateau[ligne].length) {
                System.out.println("\u001B[31mColonne invalide. Veuillez réessayer.");
            }
        } while (col < 0 || col >= plateau[ligne].length);
        return col;
    }
}
