package Pack;

public class AutoSaveMain {
	public static void main(String[] args) {
		AutoSaveThread thread = new AutoSaveThread();
		thread.setDaemon(true); //���� ������(�ش� �����带 �����Ų �ξ�����)�� �� 
		//(�ڱ⸦ ����� �����Ų �θ� ������)���� �����尡 ������ ���� ���� ����
		thread.start();
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} 
}
 

//�׹�°. �������� ���ǻ������� �̳��� ������ �� �ٷ� �״´� ���ҽ� ���� ������ �ð��� ����. -> �׳� �׾ ������ ����Ѵ�.