import java.util.Scanner;

public class Utilitaires {
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrée invalide. Veuillez réessayer : ");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

}
