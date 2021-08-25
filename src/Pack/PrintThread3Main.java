package Pack;

public class PrintThread3Main {
	public static void main(String[] args) {
		Thread thread = new PrintThread3();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		thread.interrupt();
	}
		
			
}


// 세번째 방법
