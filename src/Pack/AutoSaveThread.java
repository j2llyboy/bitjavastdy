package Pack;

public class AutoSaveThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("�ڵ� ���� �Ϸ�");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
