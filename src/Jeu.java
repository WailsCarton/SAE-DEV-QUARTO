import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Jeu {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        // Initialiser la liste des pions
        List<String> pions = initialiserPions();

        do {
            System.out.println(pions);

            // Demander au joueur de choisir un pion
            String choixPions = demanderChoixPions(scanner, pions);

            // Retirer le pion choisi de la liste
            prendrePions(pions, choixPions);
            System.out.println(pions);

            // Demander au joueur de choisir une position sur le plateau
                int ligne = demanderLigne(scanner, plateau);
                int col = demanderColonne(scanner, plateau, ligne);
            while (!plateau[ligne][col].equals("0000")){
                System.out.println("Déjà pris");
                ligne = demanderLigne(scanner, plateau);
                col = demanderColonne(scanner, plateau, ligne);
            }

            // Placer le pion choisi sur le plateau
            plateau[ligne][col] = choixPions;
            GrilleAffichage.afficherGrille(plateau);


        } while (!verifierVictoire(plateau, scanner));

    }

    // Initialiser la liste des pions
    private static List<String> initialiserPions() {
        return new ArrayList<>(Arrays.asList(
                "NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"
        ));
    }

    // Demander au joueur de choisir un pion
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

    // Retirer le pion choisi de la liste
    private static void prendrePions(List<String> pions, String choixPions) {
        pions.remove(choixPions);
    }

    // Demander au joueur de choisir une ligne sur le plateau
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

    // Demander au joueur de choisir une colonne sur le plateau
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

    // Vérifier si le joueur a gagné ou si le plateau est plein
    public static boolean verifierVictoire(String[][] plateau, Scanner scanner) {
        // Vérifier les lignes, les colonnes et les diagonales pour une combinaison gagnante
        if (verifierLignes(plateau) || verifierColonnes(plateau) || verifierDiagonales(plateau)) {
            System.out.println("Le joueur a gagné !");
            return true; // Le joueur a gagné
        }

        // Vérifier si le plateau est plein (match nul)
        if (plateauPlein(plateau)) {
            System.out.println("Match nul !");
            return true;
        }

        // Aucune condition de victoire n'est remplie
        return false;
    }


    // Vérifier les lignes pour une combinaison gagnante
    private static boolean verifierLignes(String[][] plateau) {
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            if (ligneContientCombinaisonGagnante(plateau[ligne])) {
                return true;
            }
        }
        return false;
    }

    // Vérifier les colonnes pour une combinaison gagnante
    private static boolean verifierColonnes(String[][] plateau) {
        for (int col = 0; col < plateau[0].length; col++) {
            String[] colonne = new String[plateau.length];
            for (int ligne = 0; ligne < plateau.length; ligne++) {
                colonne[ligne] = plateau[ligne][col];
            }
            if (ligneContientCombinaisonGagnante(colonne)) {
                return true;
            }
        }
        return false;
    }

    // Vérifier les diagonales pour une combinaison gagnante
    private static boolean verifierDiagonales(String[][] plateau) {
        String[] diagonalePrincipale = new String[plateau.length];
        String[] diagonaleInverse = new String[plateau.length];

        for (int i = 0; i < plateau.length; i++) {
            diagonalePrincipale[i] = plateau[i][i];
            diagonaleInverse[i] = plateau[i][plateau.length - 1 - i];
        }

        return (ligneContientCombinaisonGagnante(diagonalePrincipale) || ligneContientCombinaisonGagnante(diagonaleInverse));
    }

    // Vérifier si une ligne contient une combinaison gagnante de quatre pièces
    private static boolean ligneContientCombinaisonGagnante(String[] ligne) {
        for (int i = 0; i <= ligne.length - 4; i++) {
            if (combinaisonGagnante(ligne[i], ligne[i + 1], ligne[i + 2], ligne[i + 3])) {
                return true;
            }
        }
        return false;
    }


    // Vérifier si quatre pièces forment une combinaison gagnante
    private static boolean combinaisonGagnante(String piece1, String piece2, String piece3, String piece4) {
        for (int i = 0; i < 4; i++) {
            char char1 = piece1.charAt(i);
            char char2 = piece2.charAt(i);
            char char3 = piece3.charAt(i);
            char char4 = piece4.charAt(i);

            // Ignorer les cases vides
            if (char2 != '0' && char1 == char2 && char3 == char4 && char2 == char3) {
                return true;
            }
        }
        return false;
    }


    // Vérifier si le plateau est plein
    private static boolean plateauPlein(String[][] plateau) {
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int col = 0; col < plateau[ligne].length; col++) {
                if (plateau[ligne][col].equals("0000")) {
                    return false; // Au moins un espace vide, le plateau n'est pas plein
                }
            }
        }
        return true; // Aucun espace vide, le plateau est plein
    }
}
