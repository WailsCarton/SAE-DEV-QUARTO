import java.util.List;
import java.util.Scanner;

public class JeuBotNormal {

    public static void jouer(String[][] plateau) {
        Scanner scanner = new Scanner(System.in);

        // Initialiser la liste des pions
        List<String> pions = Utilitaires.initialiserPions();
        TourJoueurBot tourBot = TourJoueurBot.Bot;

        boolean victoire;
        do {

            System.out.println("\u001B[34mLes pions disponibles:\u001B[0m");
            System.out.println(pions);
            System.out.println("\u001B[34mLe plateau actuel:\u001B[0m");
            Plateau.afficherPlateau(plateau);

            MethodesBotNormal.jouerTourAvecBot(scanner, pions, plateau, tourBot);

            System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________________");

            // Passer au tour suivant
            tourBot = (tourBot == TourJoueurBot.JOUEUR) ? TourJoueurBot.Bot : TourJoueurBot.JOUEUR;

            victoire = MethodesBotFacile.verifierVictoireAvecBot(plateau, tourBot);

            Utilitaires.wait(3000);

        } while (!victoire);
    }
}
