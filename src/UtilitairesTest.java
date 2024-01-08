import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

class UtilitairesTest {

    // Pour capturer la sortie standard
    private final ByteArrayOutputStream sortieStandard = new ByteArrayOutputStream();
    private final PrintStream sortieStandardOriginale = System.out;

    @BeforeEach
    public void configurerSortieStandard() {
        System.setOut(new PrintStream(sortieStandard));
    }

    @AfterEach
    public void restaurerSortieStandard() {
        System.setOut(sortieStandardOriginale);
    }

    @Test
    public void testPrendrePions() {
        // Créer une liste de pions
        List<String> pions = new ArrayList<>(Arrays.asList("pion1", "pion2", "pion3"));

        // Appeler la méthode prendrePions pour supprimer un pion spécifique
        String pionASupprimer = "pion2";
        Utilitaires.prendrePions(pions, pionASupprimer);

        // Vérifier que le pion spécifié a été supprimé
        assertFalse(pions.contains(pionASupprimer));

        // Vérifier la taille de la liste après la suppression
        assertEquals(2, pions.size());

        // Vérifier les éléments restants dans la liste
        List<String> pionsRestantsAttendus = Arrays.asList("pion1", "pion3");
        assertEquals(pionsRestantsAttendus, pions);
    }

    @Test
    public void testGetIntInput() {
        // Préparer un ByteArrayInputStream avec une saisie incorrecte suivie d'une saisie correcte
        ByteArrayInputStream fluxEntree = new ByteArrayInputStream("incorrecte\n42\n".getBytes());
        System.setIn(fluxEntree);

        // Créer un Scanner avec le flux d'entrée préparé
        Scanner scanner = new Scanner(System.in);

        // Appeler la méthode getIntInput
        int resultat = Utilitaires.getIntInput(scanner);

        // Restaurer le System.in original
        System.setIn(System.in);

        // Vérifier le résultat
        assertEquals(42, resultat);
    }

    @Test
    public void testloading() {

        // Appeler la méthode de chargement
        Utilitaires.loading();

        // Vérifier la sortie imprimée
        String sortieAttendue =
                        "loading." + System.lineSeparator() +
                        "loading.." + System.lineSeparator() +
                        "loading..." + System.lineSeparator();
        assertEquals(sortieAttendue, sortieStandard.toString());
    }
}