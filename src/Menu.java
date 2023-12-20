import java.util.Scanner;

public class Menu {
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;


    public static void afficherMenu(Scanner scanner) {

        String regles = "Chacun à son tour un joueur choisit la pièce qu'il souhaite jouer il doit la jouer sur une case libre.\n" +
                "Le gagnant est celui qui crée un alignement de 4 pièces ayant au moins un caractère commmun. \n" +
                "Caractères : Noir(N), Blanc(B), Pleins(P), Creux(C), Petit(P), Grand(G), Rond(R) et Carré(C). \n" +
                "Exemple : Blanc Petit Carré Creux = BPCC (L'ordre est important est reste tout le temps le même.)\n" +
                "|Couleur| |Taille| |Forme| |Creux/Plein|";
        int choix;
        String[][] plateau;

        do {
            plateau = initialiserPlateau();
            System.out.println();
            System.out.println("1. Jouer 1v1");
            System.out.println("2. Jouer 1vOrdi");
            System.out.println("3. Options");
            System.out.println("4. Afficher plateau");
            System.out.println("5. Les règles");
            System.out.println("0. Quitter");

            System.out.println();

            System.out.print("Faites votre choix : ");
            choix = Utilitaires.getIntInput(scanner);


            switch (choix) {
                case 1 -> Jeu.jouer(plateau);
                case 2 -> JeuBot.jouer(plateau);
                case 3 -> GrilleAffichage.afficherGrille(plateau);
                case 4 -> System.out.println(regles);
                case 0 -> System.out.println("Au revoir");
                default -> System.out.println("Erreur; Faites un choix valide");
            }

        } while (choix != 0);

        scanner.close();
    }


    private static String[][] initialiserPlateau() {
        String[][] plateau = new String[Menu.DEFAULT_WIDTH][Menu.DEFAULT_HEIGHT];
        return GrilleAffichage.remplirTableau(plateau);
    }
}
