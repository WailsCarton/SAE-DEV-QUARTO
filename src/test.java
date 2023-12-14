import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String s = "NPCP";
        List<String> pions = new ArrayList<>(Arrays.asList("NPCC", "NPCP", "NGCC", "NGCP", "NPRC", "NPRP", "NGRC", "NGRP",
                "BPCC", "BPCP", "BGCC", "BGCP", "BPRC", "BPRP", "BGRC", "BGRP"));
        System.out.println(pions);
        pions.remove(s);
        System.out.println(pions);
        System.out.println((pions.get(4)));
        for (int i = 0; i < pions.size(); i++) {
            if (s.equals(pions.get(i)))
                pions.remove(i);
        }
    }
}
