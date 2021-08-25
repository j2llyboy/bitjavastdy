package Pack;

public class CalculatorMain {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
			
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
		
		
		// 공유객체를 접근할 때는 항상 이런 문제가 생길 수 있다.
		// 멀티 쓰레드 프로그램ㅇ을 하는 상황에서 공유 객체가 있을경우 해결을 해줘야한다.

	}
}
