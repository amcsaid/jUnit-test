import java.lang.Math; 

public class Pi {
	public static double PiMethode1(int n) { // La série de Gregory-Leibniz
		double result = 1.0;
		for (int i = 1; i <= n; i++) {

			if ((i % 2) == 0) {
				result += (1.0 / (2.0 *i + 1.0)) ;
			} else {
				result -= (1.0 / (2.0 *i + 1.0));
			}

		}
		return (result * 4.0);
	}
	
	
	public static double PiMethode2 (int n) {
		
		if (n == 0) {
	        throw new IllegalArgumentException("Illegal Argument 0, NOT ACCEPTED!");
	    }
		
		int m = 0;
		double pi;
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if( (i*i) + (j*j) <= (n * n)) {
					m++;
				}
			}
		}
		
		pi = (4.0 * (m - n - 1.0) + 1.0) / (n*n);
		return pi;
	}
	
	public static double PiMethode3(int n) { // solution du problème de Bâle
		double result = 0.0;
		
		for (int i = 1; i <= n; i++) {
			result += (1.0 / (i*i));
		}
		
		return Math.sqrt(result * 6);
	}	
}
