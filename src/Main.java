import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Start");
        Utilitaires.loading();
        Menu.afficherMenu(scanner);
        scanner.close();
    }
}
