package projet.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CliqueurTest {

	@Test
	public void testToString()
    {
        Cliqueur cliq = new Cliqueur(); // you didn't supply the object, so I guessed
        String expected = ""; // put the expected value here
        assertEquals("Les �l�ments importants du cliqueur peuvent s'afficher ici :\n persecond = 0.0\n pieceCounter= 1\n timerOn = false\n valeurPiece = 1\n prixBonus = 10\n valeurBonus = 100", cliq.toString());
    }
}