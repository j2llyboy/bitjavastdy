package Pack;

public class ThreadNameMain {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();	//Ŀ��Ʈ������� ������ ��ü ���۷����� ����ִ³�
		System.out.println("���α׷� ���� ������:" + mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("threadA ������: " + threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("threadA ������: " + threadB.getName());
		threadB.start();
		
	}
}
