package Pack;

public class ThreadNameMain {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();	//커런트쓰레드는 쓰레드 객체 레퍼런스를 잡아주는놈
		System.out.println("프로그램 시작 쓰레드:" + mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("threadA 쓰레드: " + threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("threadA 쓰레드: " + threadB.getName());
		threadB.start();
		
	}
}
