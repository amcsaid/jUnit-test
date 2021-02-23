
public class Calculatrice {
	private int x;
	private int y;
	//private String operation;
	
	public Calculatrice() {
		this.x = 0;
		this.y = 0;
		//this.operation = "";
	}
	
	public int Addition (int x, int y) {
		return x + y;
	}
	
	public int Multiplication (int x, int y) {
		return x * y;
	}
	public double Division (int x, int y) {
		return (1.0*x) / y;
	}
	public int Soustraction (int x, int y) {
		return x - y;
	}
	
	
}
