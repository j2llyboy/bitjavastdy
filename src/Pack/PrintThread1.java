package Pack;

public class PrintThread1 extends Thread{
	private boolean stop = false;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	
	//첫번째 방법, 외부에서 stop 값을 넣어준다.
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop) {
			System.out.println("실행 중");
		}
		System.out.println("사용하던 리소스 정리");
		System.out.println("실행 종료");
	}
	
	
}
