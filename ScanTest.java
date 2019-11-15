import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScanTest {

	@Test
	void test() {
		Scanner sc = new Scanner();
		assertEquals("vous avez \n 1 euros", sc.Scan());
		assertEquals("Chaque click vaut \n 1", sc.Scan());
		assertEquals("Vous gagnez \n 0 par seconde", sc.Scan());
		}

}
