import java.util.Scanner;

public class ChoixDifficulteBot {
    public static void afficherChoixDifficulteBot(Scanner scanner) {

        String regles = "Chacun à son tour un joueur choisit la pièce qu'il souhaite jouer il doit la jouer sur une case libre.\n" +
                "Le gagnant est celui qui crée un alignement de 4 pièces ayant au moins un caractère commmun. \n" +
                "Caractères : Noir(N), Blanc(B), Pleins(P), Creux(C), Petit(P), Grand(G), Rond(R) et Carré(C). \n" +
                "Exemple : Blanc Petit Carré Creux = BPCC (L'ordre est important est reste tout le temps le même.)\n" +
                "|Couleur| |Taille| |Forme| |Creux/Plein|";
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
                case 1 -> JeuBot.jouer(plateau);
                case 2 -> JeuBot.jouer(plateau);
                case 3 -> Menu.afficherMenu(scanner);
                case 0 -> System.out.println("Au revoir");
                default -> System.out.println("Erreur; Faites un choix valide");
            }

        } while (choix != 0);

    }
}
