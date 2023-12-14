import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    private static final String LINE_SEPARATOR = "\n";

    public static void jeu(String[][] plateau) {
        Scanner scanner = new Scanner(System.in).useDelimiter(LINE_SEPARATOR);

        List<String> pions = new ArrayList<>(Arrays.asList(
                "NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"
        ));

        int win;
        do {
            System.out.println(pions);

            // Validation du choix de pions
            String choixPions;
            do {
                System.out.print("Le pion : ");
                choixPions = scanner.nextLine();
                if (!pions.contains(choixPions)) {
                    System.out.println("Pion invalide. Veuillez réessayer.");
                }
            } while (!pions.contains(choixPions));

            prendrePions(pions, choixPions);
            System.out.println(pions);

            // Validation de la ligne
            int ligne;
            do {
                System.out.print("Quelle ligne ? ");
                ligne = getIntInput(scanner);
                if (ligne < 0 || ligne >= plateau.length) {
                    System.out.println("Ligne invalide. Veuillez réessayer.");
                }
            } while (ligne < 0 || ligne >= plateau.length);

            // Validation de la colonne
            int col;
            do {
                System.out.print("Quelle colonne ? ");
                col = getIntInput(scanner);
                if (col < 0 || col >= plateau[ligne].length) {
                    System.out.println("Colonne invalide. Veuillez réessayer.");
                }
            } while (col < 0 || col >= plateau[ligne].length);

            plateau[ligne][col] = choixPions;
            GrilleAffichage.afficherGrille(plateau);

            // Validation du choix
            System.out.print("Choix ? ");
            win = getIntInput(scanner);
            scanner.nextLine(); // Clear le buffer
        } while (win != 0);
    }

    private static void prendrePions(List<String> pions, String choixPions) {
        pions.remove(choixPions);
    }

    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrée invalide. Veuillez réessayer : ");
            scanner.nextLine(); // Clear le buffer
        }
        return scanner.nextInt();
    }
}
