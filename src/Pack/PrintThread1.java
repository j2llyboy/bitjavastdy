package Pack;

public class PrintThread1 extends Thread{
	private boolean stop = false;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	
	//ù��° ���, �ܺο��� stop ���� �־��ش�.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop) {
			System.out.println("���� ��");
		}
		System.out.println("����ϴ� ���ҽ� ����");
		System.out.println("���� ����");
	}
	
	
}
