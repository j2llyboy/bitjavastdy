package Pack;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//두개 이상의 쓰레드가 동시에 진입했을때 문제가 생길 수 있는 영역을 "Critical Section"라 한다.
//	public synchronized void setMemory(int memory) {
//		// 아래는 Critical Section
//		this.memory = memory;
//		try {
//			Thread.sleep(2000); //일을 많이 한다... 라고 가정
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
//	}
	
	// 크리티컬 섹션이 포함된 자체를 퍼브릭(접근제한자) 리턴타입(보이드) 사이에 synchronized를 넣어준다. 
	// 이렇게 되면 특정 쓰레드가 치고 들어왔을때 이미 들어온 쓰레드가 빠져 나가야만 들어올 수 있게 막아준다.
	
	
	public void setMemory(int memory) {
		// 아래는 Critical Section
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000); //일을 많이 한다... 라고 가정
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}
	}
	
	//전체를 막으면 속도에 영향을 주니 피해를 최소화 하고 필요 부분만 씽크로나이즈로 감싸자
	// synchronized (this) {}
	
	
}

// ArrayList 객체를 다수의 쓰레드가 사용하는데 문제가 있을 수 있기 때문에 
//=> Vector 객체는 하나만 써도 문제 발생안하게 만든 경우인데 이를 thread safe하다 라고 한다
// Vector는 ArrayList를 thread safe하게 만들어둔 것!

//HashMap => HashTable(thread safe) 
//이런 멀티스레드를 위해 자바에서 별도로 만든 것들..


