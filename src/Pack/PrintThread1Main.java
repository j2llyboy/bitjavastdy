package Pack;

public class PrintThread1Main {
	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		
		printThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		printThread.setStop(true);
	}
}

//안전하게 종료하는 첫번째 방법