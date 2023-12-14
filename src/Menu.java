import java.util.Scanner;

public class Menu {
    private static final int DEFAULT_WIDTH = 4;
    private static final int DEFAULT_HEIGHT = 4;


    public static void afficherMenu() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        String regles = "Chacun à son tour un joueur choisit la pièce qu'il souhaite jouer il doit la jouer sur une case libre.\n" +
                "Le gagnant est celui qui crée un alignement de 4 pièces ayant au moins un caractère commmun. \n" +
                "Caractères : Noir(N), Blanc(B), Pleins(P), Creux(C), Petit(P), Grand(G), Rond(R) et Carré(C). \n" +
                "Exemple : Blanc Petit Carré Creux = BPCC (L'ordre est important est reste tout le temps le même.)\n" +
                "|Couleur| |Taille| |Forme| |Creux/Plein|";
        int choix;
        String[][] plateau;
        plateau = initialiserPlateau(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        do {
            System.out.println("1. Jouer 1v1");
            System.out.println("2. Jouer 1vOrdi");
            System.out.println("3. Options");
            System.out.println("4. Afficher plateau");
            System.out.println("5. Les règles");
            System.out.println("0. Quitter");

            choix = demanderChoixUtilisateur(scanner);

            switch (choix) {
                case 1:
                    Jeu.jouer(plateau);
                    break;

                case 2:
                    System.out.println("Mode 1vOrdi : non implémenté.");
                    break;

                case 3:
                    ajusterOptions(scanner, DEFAULT_WIDTH, DEFAULT_HEIGHT);
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
                    System.out.println("Erreur; Faites un choix valide");
                    break;
            }

        } while (choix != 0);

        scanner.close();
    }

    private static int demanderChoixUtilisateur(Scanner scanner) {
        System.out.print("Faites votre choix : ");
        return Utilitaires.getIntInput(scanner);
    }

    private static void ajusterOptions(Scanner scanner, int defaultWidth, int defaultHeight) {
        System.out.println("La largeur actuelle : " + defaultWidth);
        int largeur = Math.max(1, demanderEntierPositif(scanner, "Entrez la nouvelle largeur : "));

        System.out.println("La hauteur actuelle : " + defaultHeight);
        int hauteur = Math.max(1, demanderEntierPositif(scanner, "Entrez la nouvelle hauteur : "));

        System.out.println("Options ajustées avec succès !");
    }

    private static int demanderEntierPositif(Scanner scanner, String message) {
        int entier;
        do {
            System.out.print(message);
            entier = Utilitaires.getIntInput(scanner);
            if (entier <= 0) {
                System.out.println("La valeur doit être positive. Réessayez.");
            }
        } while (entier <= 0);
        return entier;
    }

    private static String[][] initialiserPlateau(int largeur, int hauteur) {
        String[][] plateau = new String[largeur][hauteur];
        return GrilleAffichage.remplirTableau(plateau);
    }
}
