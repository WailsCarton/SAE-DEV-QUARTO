import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String mot1 = "NPCP";
        String mot2 = "BGCC";
        String[][] lst = {
                {"NPCC", "NPCC", "NPCC", "NPCC"},
                {"BPCC", "BPCP", "BGCC", "BGCP"},
                {"BGRC", "NPCP", "BPCP", "NGCP"},
                {"NPCC", "NPCP", "NGCC", "NGCP"}
        };

        caracteresIdentiquesEntreMots(lst);



    }
    private static void caracteresIdentiquesEntreMots(String[][] tab) {
        boolean identique = false;
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int col = 0; col<tab[ligne].length; col++) {
                for (int car = 0; car<tab[ligne][col].length(); car++)
                    do {
                        System.out.print(tab[ligne][col].charAt(car) + "\t");
                    }while (tab[ligne][col].charAt(car) == tab[ligne][col].charAt(car+1));
                System.out.println();
            }
            System.out.println();

        }

    }
}
