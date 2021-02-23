import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


class CaculatriceTest {

	//
	// 1. @ValueSource as source of test DATA
	//
	@ParameterizedTest
	@ValueSource(ints = {5, 10, 32, 100})
	void AdditionTestv2(int val) {
		Calculatrice cal = new Calculatrice();
		
		assertEquals(val + val, cal.Addition(val, val));
	}
	
	
	//
	// 2. EnumSource class as source of Test Data
	//
	enum Operations {
		ADDITION("+"), 
		MULITPLICATION("*"), 
		SOUSTRACT("-");
		
		private final String operation;
		
		Operations (String operation) {
			this.operation = operation;
		}
		
		public String value() {
			return operation;
		}
	}
	@ParameterizedTest
	@EnumSource(value = Operations.class, 
				mode = Mode.MATCH_ANY, 
				names = ".+TION")
	void TestEnumdeCal(Operations op) {
		//System.out.println(op + " " + op.value());		
		assertNotNull(op);
	}
	
	
	//
	// 3. MethodSource("argStreamer")  avec Integer Stream
	//
	static Stream<Integer> argStreamer() {
		return Stream.of(10, 200, 22, 23, 1, 33, 33);
	}
	@ParameterizedTest
	@MethodSource("argStreamer") 
	void testMethodeArgStresmr(int numberStreamed) {
		Calculatrice cal = new Calculatrice();
		assertEquals(numberStreamed, cal.Addition(0, numberStreamed));
	}

	
	//
	// 4. MethodSource Provide 2 Arguments Stream
	//
	static List<Object[]> argStreamerV2() {
		return Arrays.asList(
				new Object[][] { 	{1, 22}, /* Ajouter les valeurs a tester ici */
									{0, 300},
									{12, -30},
									{12, 390},
									{142, 830},
									{122, 30},
									{1, 30},
									{12, 3},
									{3, 4} 
								});
	}
	@ParameterizedTest
	@MethodSource("argStreamerV2") 
	void testMethodeArgStresmrV2(int numberStreamed1, int numberStreamed2) {
		Calculatrice cal = new Calculatrice();
		assertEquals(numberStreamed1 + numberStreamed2, cal.Addition(numberStreamed1, numberStreamed2));
	}
	
	
	//
	// CSV Testing
	//
	@ParameterizedTest
	@CsvSource({
		"10	, 	92",
		"0	, 	52",
		"100, 	52",
		"10	, 	522",
		"1	, 	33"
	})
	void testAdditionAvecCSV (int numFromCsv1, int numFromCsv2) {
		Calculatrice cal = new Calculatrice();
		assertEquals(numFromCsv1 + numFromCsv2, cal.Addition(numFromCsv1, numFromCsv2));
	}
	
	
	//
	// CSV FILE Testing
	//
	@ParameterizedTest
	@CsvFileSource(resources = "filedetest.csv")
	void testAdditionAvecCSVFILE (int numFromCsv1, int numFromCsv2) {
		Calculatrice cal = new Calculatrice();
		assertEquals(numFromCsv1 + numFromCsv2, cal.Addition(numFromCsv1, numFromCsv2));
	}
	
	
	
	
	
	
}


