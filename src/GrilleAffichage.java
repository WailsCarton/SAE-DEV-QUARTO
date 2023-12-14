public class GrilleAffichage {
    public static final String DEFAULT_VALUE = "0000";

    /**
     * Affiche la grille.
     *
     * @param grille Le tableau à afficher.
     */
    public static void afficherGrille(String[][] grille) {
        for (String[] ligne : grille) {
            for (String cellule : ligne) {
                System.out.print(cellule + "\t");
            }
            System.out.println(); // Passer à la ligne après chaque ligne de la grille
        }
    }

    /**
     * Remplit le tableau avec une valeur spécifiée.
     *
     * @param t      Le tableau à remplir.
     * @return Un nouveau tableau rempli avec la valeur spécifiée.
     */
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
