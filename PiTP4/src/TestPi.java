
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestPi {
	private static final double DELTA = 1e-2; // 

	//
	// Q3. Impl�mentez dans une classe de tests, TestsPi, des tests qui montrent la stabilit� des r�sultats obtenus
	// (plusieurs tests avec les m�mes donn�es d�entr�e, doivent toujours donner les m�mes r�sultats). 
	//
	@RepeatedTest(value = 5, name = "{displayName} � repetition{currentRepetition}/{totalRepetitions}")
	@DisplayName("Test de Stabilite Methode 1")
	@Tag("Stabilite")
	void TestdeStabiliteMethode1() {
		assertEquals(3.1465677471829556, Pi.PiMethode1(200), "Repeter pour n = 200, Resultas est: 3.1465677471829556");
	}
	
	@RepeatedTest(value = 5, name = "{displayName} � repetition{currentRepetition}/{totalRepetitions}")
	@DisplayName("Test de Stabilite Methode 2")
	@Tag("Stabilite")
	void TestdeStabiliteMethode2() {
		assertEquals(3.140725, Pi.PiMethode2(200), "Repeter pour n = 200, Resultas est: 3.140725");
	}
	
	@RepeatedTest(value = 5, name = "{displayName} � repetition{currentRepetition}/{totalRepetitions}")
	@DisplayName("Test de Stabilite Methode 3")
	@Tag("Stabilite")
	void TestdeStabiliteMethode3() {
		assertEquals(3.136826306330968, Pi.PiMethode3(200), "Repeter pour n = 200, Resultas est: 3.136826306330968");
	}
	
	
	//
	// Q4. Impl�mentez des tests v�rifiant que les m�thodes s�effectuent dans des temps raisonnables. On consid�re
	// que pour n=1 000 000, les m�thodes ne doivent pas d�passer 5 ms.
	//
	@Test
	@DisplayName("Test de Timeout Methode 1")
	@Tag("Timeout")
	void TestTimeOutMethode1() {
		 assertTimeout(Duration.ofMillis(5), () -> {
		        //Thread.sleep(100);
		        return Pi.PiMethode1(200);
		 });
	}
	
	@Test
	@DisplayName("Test de Timeout Methode 2")
	@Tag("Timeout")
	void TestTimeOutMethode2() {
		 assertTimeout(Duration.ofMillis(5), () -> {
		        //Thread.sleep(100);
		        return Pi.PiMethode2(200);
		 });
	}
	
	@Test
	@DisplayName("Test de Timeout Methode 3")
	@Tag("Timeout")
	void TestTimeOutMethode3() {
		 assertTimeout(Duration.ofMillis(5), () -> {
		        return Pi.PiMethode3(200);
		 });
	}
	
	

	//
	// Q5. Impl�mentez des tests v�rifiant la pr�cision des r�sultats obtenus avec les trois m�thodes en utilisant les
	// valeurs de n = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000}. On consid�re une estimation est correcte,
	// si sa partie d�cimale commence par 14.
	// Astuce : DecimalFormat df = new DecimalFormat("###.##"); pour formater la valeur de pi de fa�on
	// � garder deux chiffres apr�s la virgule.
	//
	//
	// Q6. Laquelle des trois m�thodes peut-�tre consid�rer la plus pr�cise ? justifiez votre r�ponse.
	// Methode 2 et plus precis
	//
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
	@DisplayName("Test de pr�cision Methode 1")
	@Tag("Precision")
	void TestdePresizeMethode1(int num) {
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("3,14", df.format(Pi.PiMethode1(num)));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
	@DisplayName("Test de pr�cision Methode 2")
	@Tag("Precision")
	void TestdePresizeMethode2(int num) {
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("3,14", df.format(Pi.PiMethode2(num)));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
	@DisplayName("Test de pr�cision Methode 3")
	@Tag("Precision")
	void TestdePresizeMethode3(int num) {
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("3,14", df.format(Pi.PiMethode3(num)));
	}
	
	//
	// Q7. Impl�mentez des tests v�rifiant la convergence des trois m�thodes, c.�.d., si on consid�re n allant de 0 � 100,
	// laquelle des m�thodes converge rapidement vers 3,14 ?
	//
	@TestFactory
	@DisplayName("Test de convergence vers 3.14 Methode 1")
	@Tag("Convergence")
	Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode1() {
		return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
				() -> assertEquals(3.14, Pi.PiMethode1(v), DELTA)));
	}
	
	@TestFactory
	@DisplayName("Test de convergence vers 3.14 Methode 2")
	@Tag("Convergence")
	Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode2() {
		return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
				() -> assertEquals(3.14, Pi.PiMethode2(v), DELTA)));
	}
	
	@TestFactory
	@DisplayName("Test de convergence vers 3.14 Methode 3")
	@Tag("Convergence")
	Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode3() {
		return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
				() -> assertEquals(3.14, Pi.PiMethode3(v), DELTA)));
	}
	
	//
	// Q8. Dans la classe de tests, impl�mentez des tests v�rifiant que les exceptions sont bien lev�es quand elles doivent
	// l��tre (par exemple : la division par z�ro, les mauvais param�tres pass�s dans l�appel, ...).
	//
	
	/* Tester les exceptions 
	@Test
	void testDivisionException() {
		Calculatrice calculatrice = new Calculatrice();
		assertThrows(ArithmeticException.class, () -> calculatrice.division(1, 0));
	}
	@Test
	void testDivisionExceptionMsg() {
	Calculatrice calculatrice = new Calculatrice();
	Exception exception = assertThrows(ArithmeticException.class, () ->
	calculatrice.division(1, 0));
	assertEquals("Division par zero!", exception.getMessage());
	}*/
	@Test
	@DisplayName("Test  de l'exception 0, Methode 2")
	@Tag("Exception")
	void TestExceptionMethode2() {
		assertThrows(IllegalArgumentException.class, () -> Pi.PiMethode2(0));
	}
	
	@Test
	@DisplayName("Test  de l'exception 0, Methode 2, LE MESSAGE")
	@Tag("Exception")
	void TestExceptionMethode2Msg() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Pi.PiMethode2(0));
		assertEquals("Illegal Argument 0, NOT ACCEPTED!", exception.getMessage());
	}
	

}


