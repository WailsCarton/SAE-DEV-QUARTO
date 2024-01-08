import java.util.Scanner;

public class Menu {



    public static void afficherMenu(Scanner scanner) {


        String regles = """
                \u001B[34m
                Chacun son tour un joueur choisit la pièce qu'il souhaite donner à l'adversaire, l'adversaire doit la jouer sur une case libre.
                Le gagnant est celui qui crée un alignement de 4 pièces ayant au moins un caractère commmun.\s
                Caractères : Noir(N), Blanc(B), Pleins(P), Creux(C), Petit(P), Grand(G), Rond(R) et Carré(C).\s
                Exemple : \u001B[31mB\u001B[34mlanc \u001B[31mP\u001B[34metit \u001B[31mC\u001B[34marré \u001B[31mC\u001B[34mreux = \u001B[31mB\u001B[31mP\u001B[31mC\u001B[31mC\u001B[34m (L'ordre est important est reste tout le temps le même.)
                |Couleur| |Taille| |Forme| |Creux/Plein|\u001B[0m""";
        int choix;
        String[][] plateau;

        do {
            plateau = Plateau.initialiserPlateau();
            System.out.print("\u001B[34m");
            System.out.println();
            System.out.println("1. Jouer 1v1");
            System.out.println("2. Jouer 1vOrdi");
            System.out.println("3. Afficher plateau");
            System.out.println("4. Les règles");
            System.out.println("0. Quitter\u001B[0m");

            System.out.println();

            System.out.print("\u001B[34mFaites votre choix : \u001B[0m");
            choix = Utilitaires.getIntInput(scanner);


            switch (choix) {
                case 1 -> {
                    Utilitaires.loading();
                    Jeu.jouer(plateau);
                }
                case 2 -> {
                    Utilitaires.loading();
                    MenuDifficulteBot.afficherChoixDifficulteBot(scanner);
                }
                case 3 -> {
                    Plateau.afficherPlateau(plateau);
                    Utilitaires.wait(1500);
                }
                case 4 -> {
                    System.out.println(regles);
                    Utilitaires.wait(5000);
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
