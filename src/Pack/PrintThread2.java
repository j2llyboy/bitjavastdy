package Pack;

public class PrintThread2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(1);	//쓰레드 대기 상태여야만 interrupted가 걸림  
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("사용하던 리소스 정리");
		System.out.println("실행 종료");
	}
	
}
