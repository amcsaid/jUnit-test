import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDynamicPi {
	private static final double DELTA = 1e-2; 
	
	@Nested
	@DisplayName("Méthode 1")
	class Meth1 {
		@RepeatedTest(value = 5, name = "{displayName} – repetition{currentRepetition}/{totalRepetitions}")
		@DisplayName("Test de Stabilite Methode 1")
		@Tag("Stabilite")
		void TestdeStabiliteMethode1() {
			assertEquals(3.1465677471829556, Pi.PiMethode1(200), "Repeter pour n = 200, Resultas est: 3.1465677471829556");
		}
		
		/**************************/
		@Test
		@DisplayName("Test de Timeout Methode 1")
		@Tag("Timeout")
		void TestTimeOutMethode1() {
			 assertTimeout(Duration.ofMillis(5), () -> {
			        //Thread.sleep(100);
			        return Pi.PiMethode1(200);
			 });
		}
		
		/**************************/
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
		@DisplayName("Test de précision Methode 1")
		@Tag("Precision")
		void TestdePresizeMethode1(int num) {
			DecimalFormat df = new DecimalFormat("###.##");
			assertEquals("3,14", df.format(Pi.PiMethode1(num)));
		}
		
		/**************************/
		@TestFactory
		@DisplayName("Test de convergence vers 3.14 Methode 1")
		@Tag("Convergence")
		Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode1() {
			return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
					() -> assertEquals(3.14, Pi.PiMethode1(v), DELTA)));
		}
		
		/**************************/

		
	}
	
	
	@Nested
	@DisplayName("Méthode 2")
	class Meth2 {
		@RepeatedTest(value = 5, name = "{displayName} – repetition{currentRepetition}/{totalRepetitions}")
		@DisplayName("Test de Stabilite Methode 2")
		@Tag("Stabilite")
		void TestdeStabiliteMethode2() {
			assertEquals(3.140725, Pi.PiMethode2(200), "Repeter pour n = 200, Resultas est: 3.140725");
		}
		
		/**************************/
		@Test
		@DisplayName("Test de Timeout Methode 2")
		@Tag("Timeout")
		void TestTimeOutMethode2() {
			 assertTimeout(Duration.ofMillis(5), () -> {
			        //Thread.sleep(100);
			        return Pi.PiMethode2(200);
			 });
		}
		
		/**************************/
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
		@DisplayName("Test de précision Methode 2")
		@Tag("Precision")
		void TestdePresizeMethode2(int num) {
			DecimalFormat df = new DecimalFormat("###.##");
			assertEquals("3,14", df.format(Pi.PiMethode2(num)));
		}
		
		/**************************/
		@TestFactory
		@DisplayName("Test de convergence vers 3.14 Methode 2")
		@Tag("Convergence")
		Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode2() {
			return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
					() -> assertEquals(3.14, Pi.PiMethode2(v), DELTA)));
		}
		
		/**************************/
		
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
	
	
	@Nested
	@DisplayName("Méthode 3")
	class Meth3 {
		@RepeatedTest(value = 5, name = "{displayName} – repetition{currentRepetition}/{totalRepetitions}")
		@DisplayName("Test de Stabilite Methode 3")
		@Tag("Stabilite")
		void TestdeStabiliteMethode3() {
			assertEquals(3.136826306330968, Pi.PiMethode3(200), "Repeter pour n = 200, Resultas est: 3.136826306330968");
		}
		
		/**************************/
		@Test
		@DisplayName("Test de Timeout Methode 3")
		@Tag("Timeout")
		void TestTimeOutMethode3() {
			 assertTimeout(Duration.ofMillis(5), () -> {
			        return Pi.PiMethode3(200);
			 });
		}
		
		
		/**************************/
		@ParameterizedTest
		@ValueSource(ints = {10, 15, 100, 150, 200, 1000, 1500, 2000, 2500, 3000})
		@DisplayName("Test de précision Methode 3")
		@Tag("Precision")
		void TestdePresizeMethode3(int num) {
			DecimalFormat df = new DecimalFormat("###.##");
			assertEquals("3,14", df.format(Pi.PiMethode3(num)));
		}
		
		/**************************/
		@TestFactory
		@DisplayName("Test de convergence vers 3.14 Methode 3")
		@Tag("Convergence")
		Stream<DynamicTest> dynamicTestConvergenceAvecStreamMethode3() {
			return IntStream.rangeClosed(0, 100).mapToObj(v -> DynamicTest.dynamicTest("Test de: " + v,
					() -> assertEquals(3.14, Pi.PiMethode3(v), DELTA)));
		}
		
		/**************************/
	}
	
	
	
}
