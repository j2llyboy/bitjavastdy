package Pack;

public class PrintThread3 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("���� ��");
			if(Thread.interrupted()) 
				break;			
		}
		System.out.println("����ϴ� ���ҽ� ����");
		System.out.println("���� ����");
	}

}
