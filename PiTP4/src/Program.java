import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("###.##");
		

			
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(200);
		numbers.add(2000);
			
		for(Integer num : numbers) {
			System.out.println("Test Methode1 ; avec " + num + " resultas : " + Pi.PiMethode1(num));
		}
		
		
		for(Integer num : numbers) {
			System.out.println("Test Methode2 ; avec " + num + " resultas : " + Pi.PiMethode2(num));
		}
		
		
		for(Integer num : numbers) {
			System.out.println("Test Methode3 ; avec " + num + " resultas : " + Pi.PiMethode3(num));
		}
		
		
		

	}

}
