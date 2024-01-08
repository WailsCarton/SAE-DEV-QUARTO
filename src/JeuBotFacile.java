import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// Enumération pour représenter les tours des joueurs
enum TourJoueurBot {
    JOUEUR,
    Bot
}


public class JeuBotFacile {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in);

        // Initialiser la liste des pions
        List<String> pions = Utilitaires.initialiserPions();
        TourJoueurBot tourBot = TourJoueurBot.JOUEUR;

        boolean victoire = false;
        do {

            System.out.println("\u001B[34mLes pions disponibles:\u001B[0m");
            System.out.println(pions);
            System.out.println("\u001B[34mLe plateau actuel:\u001B[0m");
            Plateau.afficherPlateau(plateau);

            MethodesBotFacile.jouerTourAvecBot(scanner, pions, plateau, tourBot);
            System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________________");

            // Passer au tour suivant
            tourBot = (tourBot == TourJoueurBot.JOUEUR) ? TourJoueurBot.Bot : TourJoueurBot.JOUEUR;

            victoire = MethodesBotFacile.verifierVictoireAvecBot(plateau, tourBot);

            Utilitaires.wait(3000);

        } while (!victoire);

    }

}
