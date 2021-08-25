package Pack;

public class FlagThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("백기");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
}

//자바는 다중 상속을 허용하지 않기 때문에
// 익스텐드로 못받는 사람들은 Runnable implements로 해서 만들어라~ 해서