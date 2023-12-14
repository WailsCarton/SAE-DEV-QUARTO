public class GrilleAffichage {

    public static void afficherGrille(String[][] grille) {
        for (String[] ligne : grille) {
            for (String cellule : ligne) {
                System.out.print(cellule + "\t");
            }
            System.out.println();
        }
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

}
