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
        Scanner scanner = new Scanner(System.in);

        // Initialiser la liste des pions
        List<String> pions = Utilitaires.initialiserPions();
        TourJoueurBot tourBot = TourJoueurBot.JOUEUR;

        do {
            System.out.println(pions);

            if (tourBot == TourJoueurBot.JOUEUR) {
                System.out.println("\u001B[34mÀ vous de jouer !\u001B[0m");

                //Faire un tour du joueur
                MethodesBot.jouerTourAvecBot(scanner, pions, plateau, tourBot);
            }
            else {


                String choixPions = MethodesBot.choisirPionAuHasard(pions);
                System.out.println("\u001B[34mLe Bot a choisi \u001B[0m" + choixPions);

                // Retirer le pion choisi de la liste
                Utilitaires.prendrePions(pions, choixPions);
                System.out.println(pions);

                // Demander au joueur de choisir une position sur le plateau
                int ligne = (int) (Math.random() * 4);
                int col = (int) (Math.random() * 4);
                while (!plateau[ligne][col].equals("0000")){
                    ligne = (int) (Math.random() * 4);
                    col = (int) (Math.random() * 4);
                }
                // Placer le pion choisi sur le plateau
                MethodesBot.placerPionAuHasard(plateau, choixPions);
                Plateau.afficherPlateau(plateau);

            }

            // Passer au tour suivant
            tourBot = (tourBot == TourJoueurBot.JOUEUR) ? TourJoueurBot.Bot : TourJoueurBot.JOUEUR;
        } while (!MethodesBot.verifierVictoireAvecBot(plateau, tourBot));

    }

}
