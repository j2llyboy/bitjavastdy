package Pack;

public class FlagThreadMain {
	public static void main(String[] args) {
		Thread thread = new FlagThread();
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Ã»±â");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
}



