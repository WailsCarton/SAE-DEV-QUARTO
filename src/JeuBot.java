import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// Enumération pour représenter les tours des joueurs
enum TourJoueurBot {
    JOUEUR,
    Bot
}


public class JeuBot {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        // Initialiser la liste des pions
        List<String> pions = MethodesJoueur.initialiserPions();
        TourJoueurBot tour = TourJoueurBot.JOUEUR;

        do {
            System.out.println(pions);

            if (tour == TourJoueurBot.JOUEUR) {
                System.out.println("À vous de jouer !");
                // Demander au joueur de choisir un pion
                String choixPions = MethodesJoueur.demanderChoixPions(scanner, pions);

                // Retirer le pion choisi de la liste
                MethodesJoueur.prendrePions(pions, choixPions);
                System.out.println(pions);

                // Demander au joueur de choisir une position sur le plateau
                int[] position = MethodesJoueur.demanderPositionSurPlateau(scanner, plateau);
                int ligne = position[0];
                int col = position[1];

                // Placer le pion choisi sur le plateau
                plateau[ligne][col] = choixPions;
                GrilleAffichage.afficherGrille(plateau);
            }
            else {
                System.out.println("Au Bot de jouer !");

                String choixPions = choisirPionAuHasard(pions);
                System.out.println(choixPions);

                // Retirer le pion choisi de la liste
                MethodesJoueur.prendrePions(pions, choixPions);
                System.out.println(pions);

                // Demander au joueur de choisir une position sur le plateau
                int ligne = (int) (Math.random() * 4);
                int col = (int) (Math.random() * 4);
                while (!plateau[ligne][col].equals("0000")){
                    ligne = (int) (Math.random() * 4);
                    col = (int) (Math.random() * 4);
                }
                // Placer le pion choisi sur le plateau
                placerPionAuHasard(plateau, choixPions);
                GrilleAffichage.afficherGrille(plateau);

            }

            // Passer au tour suivant
            tour = (tour == TourJoueurBot.JOUEUR) ? TourJoueurBot.Bot : TourJoueurBot.JOUEUR;
        } while (!MethodesVictoires.verifierVictoireAvecBot(plateau, scanner, tour));

    }

    private static String choisirPionAuHasard(List<String> pions) {
        return pions.get((int) (Math.random() * pions.size()));
    }

    private static void placerPionAuHasard(String[][] plateau, String choixPions) {
        int ligne = -1;
        int col = -1;

        do {
            ligne = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        } while (!plateau[ligne][col].equals("0000"));

        plateau[ligne][col] = choixPions;
    }

}
