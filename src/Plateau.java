public class Plateau {
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;

    public static void afficherPlateau(String[][] plateau) {
        for (int i = 0; i < plateau.length; i++) {
            afficherLigneSeparator(plateau[i].length);
            afficherLigne(plateau[i]);
        }
        afficherLigneSeparator(plateau[0].length);
    }

    private static void afficherLigne(String[] ligne) {
        for (int j = 0; j < ligne.length; j++) {
            System.out.print("| " + (ligne[j].equals("0000") ? "    " : ligne[j]) + " ");
        }
        System.out.println("|");
    }

    private static void afficherLigneSeparator(int taille) {
        for (int j = 0; j < taille; j++) {
            System.out.print("+------");
        }
        System.out.println("+");
    }


    public static String[][] remplirTableau(String[][] t) {
        String[][] nouveauTableau = new String[t.length][t[0].length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                nouveauTableau[i][j] = "0000";
            }
        }
        return nouveauTableau;
    }
    public static String[][] initialiserPlateau() {
        String[][] plateau = new String[DEFAULT_WIDTH][DEFAULT_HEIGHT];
        return Plateau.remplirTableau(plateau);
    }

}
