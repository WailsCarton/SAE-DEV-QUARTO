import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Start…");
        Utilitaires.wait(1000);
        Menu.afficherMenu(scanner);
        scanner.close();
    }
}
