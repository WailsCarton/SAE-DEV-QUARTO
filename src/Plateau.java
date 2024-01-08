public class Plateau {
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;

    public static void afficherPlateau(String[][] plateau) {
        for (String[] strings : plateau) {
            afficherLigneSeparator(strings.length);
            afficherLigne(strings);
        }
        afficherLigneSeparator(plateau[0].length);
    }

    public static void afficherLigne(String[] ligne) {
        for (String s : ligne) {
            System.out.print("| " + (s.equals("0000") ? "    " : s) + " ");
        }
        System.out.println("|");
    }

    public static void afficherLigneSeparator(int taille) {
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
