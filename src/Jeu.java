import java.util.Scanner;
import java.util.List;

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

        //Passer au tour du joueur
        TourJoueur tour = TourJoueur.JOUEUR_1;

        boolean victoire;

        do {
            System.out.println("\u001B[34mLes pions disponibles:\u001B[0m");
            System.out.println(pions);
            System.out.println("\u001B[34mLe plateau actuel:\u001B[0m");
            Plateau.afficherPlateau(plateau);

            MethodesJoueur.jouerTour(scanner, pions, plateau, tour);
            System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            // Passer au tour suivant
            tour = (tour == TourJoueur.JOUEUR_1) ? TourJoueur.JOUEUR_2 : TourJoueur.JOUEUR_1;

            victoire = MethodesVictoires.verifierVictoire(plateau, tour);

            Utilitaires.wait(1000);

        } while (!victoire);

    }




}
