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
        Scanner scanner = new Scanner(System.in);

        // Initialiser la liste des pions
        List<String> pions = Utilitaires.initialiserPions();

        //Faire un tour du joueur
        TourJoueur tour = TourJoueur.JOUEUR_1;

        do {
            System.out.println("\u001B[34mLes pions disponibles:\u001B[0m");
            System.out.println(pions);
            System.out.println("\u001B[34mLe plateau actuel:\u001B[0m");
            Plateau.afficherPlateau(plateau);

            if (tour == TourJoueur.JOUEUR_1) {
                System.out.println("\u001B[34mJoueur 1 choisissez un pion !\u001B[0m");
            } else {
                System.out.println("\u001B[34mJoueur 2 choisissez un pion !\u001B[0m");
            }

            MethodesJoueur.jouerTour(scanner, pions, plateau, tour);

            // Passer au tour suivant
            tour = (tour == TourJoueur.JOUEUR_1) ? TourJoueur.JOUEUR_2 : TourJoueur.JOUEUR_1;

        } while (!MethodesVictoires.verifierVictoire(plateau, scanner, tour));

    }




}
