package Pack;

public class PrintThread2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.println("���� ��");
				Thread.sleep(1);	//������ ��� ���¿��߸� interrupted�� �ɸ�  
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("����ϴ� ���ҽ� ����");
		System.out.println("���� ����");
	}
	
}
