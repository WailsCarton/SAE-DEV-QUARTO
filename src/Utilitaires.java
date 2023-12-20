import java.util.Scanner;

public class Utilitaires {
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("\u001B[31mEntrée invalide. Veuillez réessayer : \u001B[0m");
            scanner.nextLine();
        }
        int userInput = scanner.nextInt();
        scanner.nextLine();

        return userInput;
    }

}

