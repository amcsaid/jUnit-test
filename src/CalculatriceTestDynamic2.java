import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;



public class CalculatriceTestDynamic2 {
	private static final double DELTA = 1e-15;
	private Calculatrice calc = new Calculatrice();

	@TestFactory
	Collection<DynamicTest> dynamicTestsAvecCollection() {
		Collection<DynamicTest> resultat = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			int v = i;
			resultat.add(DynamicTest.dynamicTest("Division: " + v + "/" + v,
					() -> assertEquals((1.0) * v / v, calc.Division(v, v), DELTA)));
		}
		return resultat;
	}

	@TestFactory
	Iterable<DynamicTest> dynamicTestAvecIterable() {
		List<DynamicTest> resultat = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			int v = i;
			resultat.add(DynamicTest.dynamicTest("Division: " + v + "/" + v,
					() -> assertEquals((1.0) * v / v, calc.Division(v, v), DELTA)));
		}
		return resultat;
	}

	@TestFactory
	Iterator<DynamicTest> dynamicTestsAvecIterator() {
		List<DynamicTest> resultat = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			int v = i;
			resultat.add(DynamicTest.dynamicTest("Division: " + v + "/" + v,
					() -> assertEquals((1.0) * v / v, calc.Division(v, v), DELTA)));
		}
		return resultat.iterator();
	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsAvecStream() {
		return IntStream.rangeClosed(1, 5).mapToObj(v -> DynamicTest.dynamicTest("Division: " + v + "/" + v,
				() -> assertEquals((1.0) * v / v, calc.Division(v, v), DELTA)));
	}

}
