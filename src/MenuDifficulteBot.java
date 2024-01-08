import java.util.Scanner;

public class MenuDifficulteBot {
    public static void afficherChoixDifficulteBot(Scanner scanner) {
        int choix;
        String[][] plateau;

        do {
            plateau = Plateau.initialiserPlateau();
            System.out.print("\u001B[34m");
            System.out.println();
            System.out.println("1. Facile");
            System.out.println("2. Normal");
            System.out.println("3. Retour");
            System.out.println("0. Quitter\u001B[0m");

            System.out.println();

            System.out.print("\u001B[34mFaites votre choix : \u001B[0m");
            choix = Utilitaires.getIntInput(scanner);


            switch (choix) {
                case 1 -> {
                    Utilitaires.loading();
                    JeuBotFacile.jouer(plateau);
                }
                case 2 -> {
                    Utilitaires.loading();
                    JeuBotNormal.jouer(plateau);
                }
                case 3 -> {
                    Menu.afficherMenu(scanner);
                    Utilitaires.wait(1000);
                }
                case 0 -> {
                    System.out.println("\u001B[34mAu revoir\u001B[0m");
                    Utilitaires.wait(1000);
                }
                default -> System.out.println("\u001B[31mErreur; \u001B[30Faites un choix valide");
            }

        } while (choix != 0);

    }
}
