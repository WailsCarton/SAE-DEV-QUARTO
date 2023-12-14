import java.util.Scanner;

public class Menu {
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;

    public static void menu() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        String regles = "Chacun à son tour un joueur choisit la pièce qu'il souhaite jouer... (voir le reste de vos règles)";
        int choix;
        int largeur = DEFAULT_WIDTH;
        int hauteur = DEFAULT_HEIGHT;
        String[][] plateau;
        plateau = new String[largeur][hauteur];
        GrilleAffichage.remplirTableau(plateau);

        do {
            System.out.println("1. Jouer 1v1");
            System.out.println("2. Jouer 1vOrdi");
            System.out.println("3. Options");
            System.out.println("4. Afficher plateau");
            System.out.println("5. Les règles");
            System.out.println("0. Quitter");

            choix = Jeu.getIntInput(scanner);

            switch (choix) {
                case 1:
                    Jeu.jeu(plateau);
                    break;

                case 2:
                    System.out.println('b');
                    break;

                case 3:
                    System.out.println("La largeur :");
                    largeur = Math.max(1, Jeu.getIntInput(scanner)); // Assure que la largeur est positive
                    System.out.println("La hauteur: ");
                    hauteur = Math.max(1, Jeu.getIntInput(scanner)); // Assure que la hauteur est positive
                    break;

                case 4:
                    GrilleAffichage.afficherGrille(plateau);
                    break;

                case 5:
                    System.out.println(regles);
                    break;

                case 0:
                    System.out.println("Au revoir");
                    break;

                default:
                    System.out.println("Erreur; Faites un choix");
                    break;
            }

        } while (choix != 0);

        // Fermeture du scanner à la fin du programme
        scanner.close();
    }
}
