import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utilitaires {
    // Initialiser la liste des pions
    public static List<String> initialiserPions() {
        return new ArrayList<>(Arrays.asList(
                "NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"
        ));
    }

    // Retirer le pion choisi de la liste
    public static void prendrePions(List<String> pions, String choixPions) {
        pions.remove(choixPions);
    }

    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("\u001B[31mEntrée invalide. Veuillez réessayer : \u001B[0m");
            scanner.nextLine();
        }
        int userInput = scanner.nextInt();
        scanner.nextLine();

        return userInput;
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

}