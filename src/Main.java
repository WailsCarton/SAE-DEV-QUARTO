import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Menu.afficherMenu(scanner);
        scanner.close();
    }
}
