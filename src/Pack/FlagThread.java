package Pack;

public class FlagThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("���");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}

//�ڹٴ� ���� ����� ������� �ʱ� ������
// �ͽ��ٵ�� ���޴� ������� Runnable implements�� �ؼ� ������~ �ؼ�