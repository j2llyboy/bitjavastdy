package Pack;

public class User2 extends Thread {
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		this.setName("User2");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		calculator.setMemory(50);
	}

	
}
