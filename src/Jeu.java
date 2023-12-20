import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// Enumération pour représenter les tours des joueurs
enum TourJoueur {
    JOUEUR_1,
    JOUEUR_2
}

public class Jeu {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        // Initialiser la liste des pions
        List<String> pions = MethodesJoueur.initialiserPions();
        TourJoueur tour = TourJoueur.JOUEUR_1;

        do {
            System.out.println(pions);

            if (tour == TourJoueur.JOUEUR_1) {
                System.out.println("Joueur 1 à vous de jouer !");
            } else {
                System.out.println("Joueur 2 à vous de jouer !");
            }

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

            // Passer au tour suivant
            tour = (tour == TourJoueur.JOUEUR_1) ? TourJoueur.JOUEUR_2 : TourJoueur.JOUEUR_1;

        } while (!MethodesVictoires.verifierVictoire(plateau, scanner, tour));

    }




}
