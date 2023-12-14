import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Jeu {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        List<String> pions = initialiserPions();

        int win;
        do {
            System.out.println(pions);

            String choixPions = demanderChoixPions(scanner, pions);

            prendrePions(pions, choixPions);
            System.out.println(pions);

            int ligne = demanderLigne(scanner, plateau);
            int col = demanderColonne(scanner, plateau, ligne);

            plateau[ligne][col] = choixPions;
            GrilleAffichage.afficherGrille(plateau);

            if (ligneContientCaractereSimilaire(plateau[ligne])) {
                System.out.println("Gagner");
                break;
            }
            scanner.nextLine();
        } while (true);

        scanner.close();
    }

    private static List<String> initialiserPions() {
        return new ArrayList<>(Arrays.asList(
                "NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"
        ));
    }

    private static String demanderChoixPions(Scanner scanner, List<String> pions) {
        String choixPions;
        do {
            System.out.print("Le pion : ");
            choixPions = scanner.nextLine();
            if (!pions.contains(choixPions)) {
                System.out.println("Pion invalide. Veuillez réessayer.");
            }
        } while (!pions.contains(choixPions));
        return choixPions;
    }

    private static void prendrePions(List<String> pions, String choixPions) {
        pions.remove(choixPions);
    }

    private static int demanderLigne(Scanner scanner, String[][] plateau) {
        int ligne;
        do {
            System.out.print("Quelle ligne ? ");
            ligne = Utilitaires.getIntInput(scanner);
            if (ligne < 0 || ligne >= plateau.length) {
                System.out.println("Ligne invalide. Veuillez réessayer.");
            }
        } while (ligne < 0 || ligne >= plateau.length);
        return ligne;
    }

    private static int demanderColonne(Scanner scanner, String[][] plateau, int ligne) {
        int col;
        do {
            System.out.print("Quelle colonne ? ");
            col = Utilitaires.getIntInput(scanner);
            if (col < 0 || col >= plateau[ligne].length) {
                System.out.println("Colonne invalide. Veuillez réessayer.");
            }
        } while (col < 0 || col >= plateau[ligne].length);
        return col;
    }

    private static boolean ligneContientCaractereSimilaire(String[] ligne) {
        return true;
    }

}
