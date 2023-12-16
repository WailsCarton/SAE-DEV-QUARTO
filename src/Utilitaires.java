import java.util.Scanner;

public class Utilitaires {
    public static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez réessayer : ");
            }
        }
    }
}

