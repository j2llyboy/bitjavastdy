package Pack;

public class PrintThread2Main {
	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		thread.interrupt();
	}
}

//이게 두번째 방법