package Pack;

public class AutoSaveThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("자동 저장 완료");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
