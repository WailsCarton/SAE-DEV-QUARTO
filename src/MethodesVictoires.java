

public class MethodesVictoires {
    // Vérifier si le joueur a gagné ou si le plateau est plein
    public static boolean verifierVictoire(String[][] plateau, TourJoueur tour) {
        // Vérifier les lignes, les colonnes et les diagonales pour une combinaison gagnante
        if (verifierLignes(plateau) || verifierColonnes(plateau) || verifierDiagonales(plateau)) {
            if (tour == TourJoueur.JOUEUR_1)
                System.out.println("\u001B[34mLe joueur 1 a gagné !\u001B[0m");
            else
                System.out.println("\u001B[34mLe joueur 2 a gagné !\u001B[0m");
            return true;
        }

        // Vérifier si le plateau est plein (match nul)
        if (plateauPlein(plateau)) {
            System.out.println("\u001B[34mMatch nul !\u001B[0m");
            return true;
        }

        // Aucune condition de victoire n'est remplie
        return false;
    }


    // Vérifier les lignes pour une combinaison gagnante
    public static boolean verifierLignes(String[][] plateau) {
        for (String[] cellule : plateau) {
            if (ligneContientCombinaisonGagnante(cellule)) {
                return true;
            }
        }
        return false;
    }

    // Vérifier les colonnes pour une combinaison gagnante
    public static boolean verifierColonnes(String[][] plateau) {
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
    public static boolean verifierDiagonales(String[][] plateau) {
        String[] diagonalePrincipale = new String[plateau.length];
        String[] diagonaleInverse = new String[plateau.length];

        for (int i = 0; i < plateau.length; i++) {
            diagonalePrincipale[i] = plateau[i][i];
            diagonaleInverse[i] = plateau[i][plateau.length - 1 - i];
        }

        return (ligneContientCombinaisonGagnante(diagonalePrincipale) || ligneContientCombinaisonGagnante(diagonaleInverse));
    }

    // Vérifier si une ligne contient une combinaison gagnante de quatre pièces
    public static boolean ligneContientCombinaisonGagnante(String[] ligne) {
        for (int i = 0; i <= ligne.length - 4; i++) {
            if (combinaisonGagnante(ligne[i], ligne[i + 1], ligne[i + 2], ligne[i + 3])) {
                return true;
            }
        }
        return false;
    }


    // Vérifier si quatre pièces forment une combinaison gagnante
    public static boolean combinaisonGagnante(String piece1, String piece2, String piece3, String piece4) {
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
    public static boolean plateauPlein(String[][] plateau) {
        for (String[] strings : plateau)
            for (String string : strings) {
                if (string.equals("0000")) {
                    return false; // Au moins un espace vide, le plateau n'est pas plein
                }
            }
        return true; // Aucun espace vide, le plateau est plein
    }
}
