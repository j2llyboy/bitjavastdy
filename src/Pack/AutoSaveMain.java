package Pack;

public class AutoSaveMain {
	public static void main(String[] args) {
		AutoSaveThread thread = new AutoSaveThread();
		thread.setDaemon(true); //데몬 쓰레드(해당 쓰레드를 실행시킨 부쓰레드)가 됨 
		//(자기를 만들고 실행시킨 부모 쓰레드)메인 쓰레드가 죽으면 같이 따라서 죽음
		thread.start();
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} 
}
 

//네번째. 편리하지만 주의사항으로 이놈은 죽으면 딱 바로 죽는다 리소스 등을 정리할 시간이 없다. -> 그냥 죽어도 좋을때 사용한다.