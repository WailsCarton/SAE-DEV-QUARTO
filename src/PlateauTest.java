import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    final void testRemplirTableau() {
        // Créez un tableau de test
        String[][] tableauTest = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}
        };

        // Appelez la méthode remplirTableau pour remplir le tableau de test
        String[][] resultat = Plateau.remplirTableau(tableauTest);

        // Créez un tableau attendu avec des "0000" pour chaque élément
        String[][] tableauAttendu = {
                {"0000", "0000", "0000"},
                {"0000", "0000", "0000"},
                {"0000", "0000", "0000"}
        };

        // Vérifiez si le tableau résultant est égal au tableau attendu
        assertArrayEquals(tableauAttendu, resultat);
    }

    @Test
    final void testInitialiserPlateau() {
        // Appelez la méthode initialiserPlateau
        String[][] plateauResultant = Plateau.initialiserPlateau();

        // Créez un tableau attendu avec des "0000" pour chaque élément
        String[][] plateauAttendu = {
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"}
        };

        // Vérifiez si le plateau résultant est égal au plateau attendu
        assertArrayEquals(plateauAttendu, plateauResultant);
    }

    @Test
    public void testAfficherPlateau() {
        String[][] plateauTest = {
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"},
                {"0000", "0000", "0000", "0000"}
        };

        Plateau.afficherPlateau(plateauTest);

        String expectedOutput =
                "+------+------+------+------+" + System.lineSeparator() +
                        "|      |      |      |      |" + System.lineSeparator() +
                        "+------+------+------+------+" + System.lineSeparator() +
                        "|      |      |      |      |" + System.lineSeparator() +
                        "+------+------+------+------+" + System.lineSeparator() +
                        "|      |      |      |      |" + System.lineSeparator() +
                        "+------+------+------+------+" + System.lineSeparator() +
                        "|      |      |      |      |" + System.lineSeparator() +
                        "+------+------+------+------+" + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testAfficherLigne() {
        // Créez un tableau de test
        String[] ligneTest = {"0000", "1111", "2222", "3333"};

        // Appelez la méthode afficherLigne
        Plateau.afficherLigne(ligneTest);

        // Définissez la sortie attendue avec une séquence de séparateurs de ligne normalisée
        String expectedOutput = "|      | 1111 | 2222 | 3333 |" + System.lineSeparator();

        // Vérifiez si les sorties générée et attendue (avec séparateurs de ligne normalisés) sont égales
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    final void testAfficherLigneSeparator() {

        // Définissez la taille de test
        int tailleTest = 4;

        // Appelez la méthode afficherLigneSeparator
        Plateau.afficherLigneSeparator(tailleTest);

        // Définissez la sortie attendue avec une séquence de séparateurs de ligne normalisée
        String expectedOutput = "+------+------+------+------+" + System.lineSeparator();

        // Vérifiez si les sorties générée et attendue (avec séparateurs de ligne normalisés) sont égales
        assertEquals(expectedOutput, outContent.toString());
    }

}