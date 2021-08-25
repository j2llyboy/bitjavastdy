package Pack;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/*
// ex)
class Tiger{
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
	}
}
*/

//ex 배-1) 쓰레드
public class Hello 
{
	public static void main(String[] args) 
	{
		
		Runnable flagTask = new FlagTask();
		Thread thread = new Thread(flagTask);
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("청기");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	
		
	}
}


/*
//ex103-1) 람다
// 람다함수, 람다식, (함수적 프로그래밍)
// 함수 한개만 만들어서 사용할 수 있다.

interface Test1{
	void f1();
}

interface Test2{
	void f1(int num);
}

interface Test3{
	int f1();
}

interface Test4{
	int f1(int n, String s);
}


public class Hello 
{
	public static void main(String[] args) 
	{
		Test1 t1 = new Test1() {
			@Override
			public void f1() {
				System.out.println(1);
			}
		};
		t1.f1();
		
		Test1 t2 = ()-> {			//위의 t1코드와 같다. 이를 람다함수 라고 한다.
			System.out.println(2);
		};
		t2.f1();
		
		// ----------------------------------
		
		Test2 t3 = new Test2() {
			@Override
			public void f1(int n) {
				System.out.println(3);
			}
		};
		t3.f1(100);
		
		Test2 t4 = (num)->{
			System.out.println(4);
		};
		t4.f1(100);
		
		// ----------------------------------
		
		Test3 t5 = new Test3() {
			@Override
			public int f1() {
				System.out.println(5);
				return 0;
			}
		};
		t5.f1();
		
		Test3 t6 = ()->{
			System.out.println(6);
			return 0;
		};
		t6.f1();
		
		// ----------------------------------
		
		Test4 t7 = new Test4(){
			@Override
			public int f1(int n, String s) {
				System.out.println(7);
				return 0;
			}
		};
		t7.f1(100, "호랑이");
	
		Test4 t8 = (n,s)->{
			System.out.println(8);
			return 0;
		};
		t8.f1(100, "호랑이");
		
		// ----------------------------------
		
		Test3 t9 = ()->{
			return 1000;
		};
		System.out.println(t9.f1());
		
		Test3 t10 = ()-> 2000; // 9번과 10번은 같은 코드 단문장이라 {}를 생략할 경우, return도 같이 생략해줘야 한다
		System.out.println(t10.f1()); 
		
		Test4 t11 = (n,s)->{
			return n + Integer.parseInt(s);
		};
		System.out.println(t11.f1(100, "200"));
		
		Test4 t12 = (n,s)-> n + Integer.parseInt(s);
		System.out.println(t12.f1(100, "200"));
		
	}
}
*/

/*
//ex102) 도서 관리 프로그램 << 컬렉션 (LinkedList)
class Book{
	String name;
	String author;
	String publisher;
	int price;
	
	public Book(String name, String author, String publisher, int price) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	void showInfo() {
		System.out.println(
				name + " " +
				author + " " + 
				publisher + " " +
				price
		);
	}
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		//Create From CRUD		
		LinkedList<Book> mm = new LinkedList<Book>();
		mm.add(new Book("자바를배우자", "홍길동", "열심히출판사", 1000));
		mm.add(new Book("늦잠자는법", "게으름", "대충출판사", 1500));
		mm.add(new Book("빅데이터란무엇인가", "이순신", "불패출판사", 5000));
		mm.add(new Book("남을돕고살자", "을지문덕", "남량출판사", 2500));
		System.out.println(mm.size()); //아주머니 책이 몇권 있어요~?
		
		// Read From CRUD	
		for (Book book : mm) {
			book.showInfo();
		}
		
		System.out.println();
		
		// Update From CRUD	
		mm.set(1, new Book("일찍일어나는법","일찍이","소충출판사",1590));
		
		for (Book book : mm) {
			book.showInfo();
		}
		
		System.out.println();
		
		// Delete From CRUD	
		mm.remove(3);
		
		for (Book book : mm) {
			book.showInfo();
		}
		
		//검색 프로그램! 
		Book findBook = search(mm, "이순신");
		
		if(findBook != null) {
			System.out.println("검색성공");
			findBook.showInfo();
		}else {
			System.out.println("검색실패");
		}
		
	}
	static Book search(LinkedList<Book> rm, String author) {
		for (Book book : rm) {
			if(book.author.equals(author)) {
				return book; //찾았으면 그만 돌게 리턴을 걸어줌
			}
		}
		return null;
	}
}
*/

/*
//ex101-2) 제네릭 문법 : 클래스를 반복해서 만들지 않고 한번 만들어서 어떤 데이터든 받아서 처리하겠다.
class Tiger<T>{		//대표적으로 <T> 나 <E>를 쓴다.
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		//Tiger t = new Tiger();
		Tiger<Integer> t1 = new Tiger<Integer>();
		t1.setData(10);
		System.out.println(t1.getData());
		System.out.println("-----------------");
		
		Tiger<String> t2 = new Tiger<String>();
		t2.setData("호랑이");
		System.out.println(t2.getData());
		System.out.println("-----------------");
		
		Tiger<Float> t3 = new Tiger<Float>();
		t3.setData(3.14f);
		System.out.println(t3.getData());
		System.out.println("-----------------");
		
		Tiger<Boolean> t4 = new Tiger<Boolean>();
		t4.setData(true);
		System.out.println(t4.getData());
		System.out.println("-----------------");
		
		//이미 우리가 제네릭 문법을 알기전에 이렇게 쓰고 있었다..!
		LinkedList<Integer> mm = new LinkedList<Integer>();
	}
}
*/

/*
//ex101-1)
//문제점 : 사용되는 데이타의 타입이 바뀔때마다 새로운 클래스를 만들어야 한다.
class A{
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}	
}

class B{
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}	
}

class C{
	private float data;

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		A a = new A();
		a.setData(10);
		System.out.println(a.getData());
		
		B b = new B();
		b.setData("호랑이");
		System.out.println(b.getData());
		
		C c = new C();
		c.setData(3.14f);
		System.out.println(c.getData());
	}
}
*/

/*
//ex100-3) 데코레이션 패턴 : 감싸고 감싸고 감싼다고.. 키오스크 생각해보면 됨~
class 커피{
	int 가격 = 30;
	
	int 계산() {
		System.out.println("커피 주문");
		return 가격;
	}
}

class 설탕 extends 커피{
	int 가격 = 20;
	
	커피 a;
	설탕(커피 a){
		this.a = a;
		
	}
	int 계산() {
		System.out.println("설탕 주문");
		return 가격 + a.계산();
	}
}
class 프림 extends 커피{
	int 가격 = 10;
	
	커피 a;
	프림(커피 a){
		this.a = a;
		
	}
	int 계산() {
		System.out.println("프림 주문");
		return 가격 + a.계산();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
//		커피 a = new 커피();
//		System.out.println(a.계산());

		커피 손님 = new 커피();
		//System.out.println(손님.계산());
		손님 = new 설탕(손님);
		System.out.println(손님.계산());
		System.out.println("---------------");
		손님 = new 프림(손님);
		System.out.println(손님.계산());
		System.out.println("---------------");
		손님 = new 설탕(손님);
		손님 = new 설탕(손님);
		손님 = new 설탕(손님);
		손님 = new 프림(손님);
		System.out.println(손님.계산());
	}
}
*/

/*
//ex100-2)
class A{
	int num = 30;
	int run() {
		System.out.println("A run");
		return num;
	}
}
class B extends A{
	int num = 20;
	A a;
	B(A a){
		this.a = a;
	}
	int run() {
		System.out.println("B run");
		return num + a.run();
	}
}
	
class C extends A{
	int num = 10;
	A a;
	C(A a){
		this.a = a;
	}
	int run() {
		System.out.println("C run");
		return num + a.run();
	}	
}


public class Hello 
{
	public static void main(String[] args) 
	{
		// A a = new A();
		// a.run();
		
		A a = new A();
		// 새로운 객체를 받음 = new B(백업하고 있음 (=B클래스 안에서 갖고 있으세요))
		a = new B(a); 
		System.out.println(a.run());
		System.out.println("---------------");
		//a를 감싸고 있는 b를 다시 C로 
		a = new C(a);
		System.out.println(a.run());
	}
}
/*


/*
//ex100-1) 100-2의 선행문법
class AA{}
class BB extends AA{}
class CC extends AA{}

public class Hello 
{
	public static void main(String[] args) 
	{
		// 업캐스팅 복습
		AA a1 = new BB();
		AA a2 = new CC();
		
	
		AA a3 = null;
		a3 = new BB();
		System.out.println(a3.hashCode());
		
		// AA temp = a3; 이 코드가 있었다면 안사라짐 temp로 백업이 잡아지기 때문에
		
		//밑에 코드가 실행되는 그 순간에 이전 객체는 잃어버린다. (=사라짐)
		a3 = new CC(); 
		System.out.println(a3.hashCode());
		
		a3 = new BB();
		System.out.println(a3.hashCode());
	}
}
*/

/*
//ex99) 숫자를 글자로, 글자를 숫자로
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 100; // 숫자
		String b = "200"; // 문자열
		System.out.println( a + 100);
		System.out.println( b + 100);
		
		// 1. 숫자 >> 문자열
		int n1 = 123;
		String s1 = Integer.toString(n1);
		System.out.println(s1 + 456);	//정석
		
		// 2. 숫자 >> 문자열
		int n2 = 123;
		// 슈가 코드 (달달하다) : 정석은 아니지만 자주 쓰임
		String s2 = "" + n2;
		
		// 3. 문자열 >> 숫자
		String s3 = "999";
		int n3 = Integer.parseInt(s3);
		System.out.println(n3 + 1);
						
	}
}
*/

/*
//ex98) 삼항연산 정리
public class Hello 
{


	public static void main(String[] args) 
	{
		// 1번
		int a = 20, b = 10;
		int c;
		
		if( a > b ) {
			c= 100;
		}else {
			c= 200;
		}
		System.out.println(c);
		c = a > b ? 100: 200;
		System.out.println(c);
		
		// 2번 출력과 관련된 것
		if( a > b ) {
			System.out.println("호랑이");
		}else {
			System.out.println("코끼리");
		}
		
		System.out.println( a > b ? "호랑이" : "코끼리" );
		
		// 3번 스태틱, 클래스
		
		static int m1( int a, int b ) { ##에러
//			if(a > b) {
//				return 100;
//			}else {
//				return 200;
//			}
			return (a > b) ? 100 : 200;
		}
		
		System.out.println( m1(4,3));
	}
}
*/

/*
//ex97) 짜투리 문법 못한거 하기!
@FunctionalInterface	//미구현된 함수가 반드시 하나여야 한다. 라고 알려주는 것
interface Tiger{
	void m1();

}


class Lion implements Tiger{
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		Thread a;
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		
	}
}
*/

/*
//ex96) 파일 리딩
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10;
		short b;
		b = (short)a; // 무조건 받는 놈으로 타입을 맞춘다.
		
		try {
			Reader r = new FileReader ( "hello.txt");			
						
			//int read()
			while(true) {
				int readData = r.read();
				if( readData == -1 ) {	//파일을 다 읽으면 -1이 출력되므로 반복을 막기 위해 -1에서 브레이크를 걸기위함)
					System.out.println("파일을 끝까지 읽음");
					break;
				}
				char ch = (char)readData; // 본 문장 생략 후 아래 출력에 (char)readerData 이렇게 넣어도 됨
				System.out.println(ch);				
			}			
			
			r.close();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("읽기가 끝남");
	}
}
*/

/*
//ex95)
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		
		try {
			Writer w = new FileWriter( "test.txt" );
			
			for (int i = 0; i < 6; i++) {	// 세로로 도는 놈
				for (int j = 0; j < 8; j++) {	// 가로로 도는 놈
//					if((i+j)%2 == 0) {
//						w.write("O ");
//					}else {
//						w.write("X ");
//					}
					//삼항연산으로 해보자
					w.write((i+j)%2 == 0 ? "O " : "X ");
				}
				w.write("\n");
			}
			
			
			w.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		System.out.println(2);
		
		int a = 10, b;
		// if else를 사용하고 있는가 확인
		// (if 든 else 든) 어떤 경우라도 같은 변수가 값을 대입받는가 확인
		// 이런 경우에는 삼항연산을 사용하는 것이 정석이다. 
		if(a > 0) {
			b = a + 2;
		}else {
			b = a - 2;
		}
		// 아래는 삼항연산, 위와 같은 문장임
		b = (a > 0) ? a + 2 : a - 2;
		
		if(a > 0) {
			System.out.println("호랑이");
		}else {
			System.out.println("독수리");
		}
		
		// 아래는 삼항연산으로 바꾼 것, 위와 같은 문장이다
		System.out.println( (a > 0) ? "호랑이" : "독수리");
			
			
	}
}
*/

/*
//ex94) 시간상 짜투리 문법 File I/O (Input/Output)
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		
		try {
			// 파일 입출력에서 제일 중요한 부분 주의사항!
			// 1. import
			// 2. unhandle exception
			// 3. 파일의 뚜껑을 닫아줘야한다. 꼭!! 먼저 닫아 놓고 사이에서 시작할 것!
			Writer w = new FileWriter( "test.txt" );	//오픈
			w.write("홍길동");
			w.write("\n\n");
			w.write("무궁화");
			w.close();									//클로즈
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		System.out.println(2);
	}
}
*/

/*
//ex93) singleton pattern 클래스를 이용해 만들어 질 수 있는 객체를 1개로 제한하기
class Tiger{
	private static Tiger t = null;
	private Tiger(){
		
	}
	
	static Tiger getInstance() {
		if (t == null )
			t = new Tiger();
		
		return t;
	}
	
}
public class Hello 
{
	
	// singleton pattern 
	// 클래스를 이용해서 만들어 질 수 있는 
	// 객체를 1개로 제한할 때 사용한다. ex)t1
		
	public static void main(String[] args) 
	{
		// Tiger t1 = new Tiger();		
		Tiger t1 = Tiger.getInstance();
		Tiger t2 = Tiger.getInstance();
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		
	}
}
*/

/*
//ex92) private 함수를 쓰는 이유 : 읽기전용으로만 만들 수 있다. (setter나 getter 옵션을 준것뿐 안만들어줘도 그만)
class Tiger{
	private int money;	// read, write 
//	// setter 함수
//	void setMoney(int money) {	//함수를 이렇게 제공하면 했지 직접 프라이빗으로 못하게)
//		this.money = money;
//	}
//	// getter 함수
//	int getMoney() {
//		return this.money;
//	}
	
	private int num;
	//우클릭으로 소스 -> 제네레이트 세터, 게터 들어가면 아래와 같이 만들어주기도..
	
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	void show() {
		System.out.println(money);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		//t.money = 100;
		//t.setMoney(2000);
		t.show();
		//System.out.println(t.getMoney());
		
		
	}
}
*/

/*
//ex91) 다시 클래스 이야기 private
class Tiger{
	
	// private으로 잡혀있는 변수를 : 데이타 은닉 변수 라고 한다.
	// 현대 프로그램은 클래스 내부의 필드(변수)를
	// 거의 대부분 (99%) 데이터 은닉 시켜버린다.
	
	private int a; //private 이기적인 개인적인.. "클래스 내부에서만 쓸 수 있다."
	public int b;  // private과 대비해서 밖에서도 쓸 수 있다.
	
	void m1() {
		a = 10;
		b = 20;
		m2();
		m3();
	}
	
	private void m2() {}
	public void m3() {}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
	//	t.a = 10; 프라이빗은 클래스 외부에서 사용 할 수 없다.
		t.b = 20;
	//	t.m2();	  프라이빗은 클래스 외부에서 사용 할 수 없다.
		t.m3();
	}
}
*/

/*
//ex90-2) 짝수 제거
public class Hello 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> mm = new LinkedList<Integer>();
//		mm.add(33);
//		mm.add(44);
//		mm.add(77);
//		for (int i = 0; i < 10; i++) {
//			mm.add(i * 2);
//		}
		//검증하기 위해 랜덤 넣어보기
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			mm.add(rn.nextInt(100));
		}
		System.out.println(mm);
		
		//i가 증가되면서 skip이 되어버리니 skip을 하지 않으려고 ++을 없앴다.
		for (int i = 0; i < mm.size();) {
			Integer num = mm.get(i);
			if(num%2==0) {
				mm.remove(i);				
			}else {
				i++;
			}
			System.out.println(i + ":" + mm);
		}
	
		System.out.println(mm);
	}
}
*/

/*
//ex90-1)
public class Hello 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> mm = new LinkedList<Integer>();
		mm.add(33);
		mm.add(44);
		mm.add(77);
		for (int i = 0; i < 10; i++) {
			mm.add(i * 2);
		}
		System.out.println(mm);
		
		//이제 짝수를 모두 제거하겠다!
		for (int i = 0; i < mm.size(); i++) {
			Integer num = mm.get(i);
			if(num%2==0) {
				mm.remove(i);
				
			}
			System.out.println(i + ":" + mm); //왜 다 제거가 안됐냐? 일어나는 상황을 확인하기 위한 코드
		}
		//System.out.println(mm);
		//확인했더니 짝수가 다 제거가 안됐다...!
		//인덱스 번호들이 밀려버려서....
		// 그럼 해결하는법은 90-2번으로!
	}
}
*/

/*
//ex89) 검색해서 데이터를 삭제
public class Hello 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> mm = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm);
		
		for (int i = 0; i < mm.size(); i++) {
			if(mm.get(i) == 44 ) {
				mm.remove(i);
				// break를 사용하지 않을 경우
				// 1. 쓸데없는 시간비용이 늘어 난다.
				// 2. 반복횟수에서 문제가 발생한다. (44가 빠지고 나면..)
				// 3. 만약 44가 여러개 들어가 있다면..? 44를 여러번 찾아 다 제거하려고 시도 할 것이다..
				//    허나 다 제거가 되진 않는데.... 첫 44를 제거하고 나면 그 자리를 다시 안찾고 가버리기 때문..
				// ex90)번에 이어 설명
				break;				
			}
		}
		System.out.println(mm);
		System.out.println("exit");
	}
}
*/

/*
// ex88) 검색과 관련된 프로그램
public class Hello 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> mm = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm);
					
		for (int i = 0; i < mm.size(); i++) {
			Integer num = mm.get(i);
			if(num == 45) {
				System.out.println(i + "번째에서 찾았다.");
				break;
			}
			
			if(i == mm.size()-1) {
				System.out.println("마지막 i의 값은 : " + i);
				System.out.println("찾는 데이터가 없음");
			}
		}
		System.out.println("Exit");
	}
}
*/

/*
//ex87) 콜렉션 중에서 LinkedList를 사용했다. C R U D
public class Hello 
{
	public static void main(String[] args) 
	{
		// 표준타입은 사용할 수 없다.
		// 클래스만 컨테이너 안에 들어갈 수 있다.
		LinkedList<Integer> mm = new LinkedList<Integer>();
		System.out.println(mm.size()); //아주머니 야쿠르트 몇개 있습니까?
		
		//C(reate)
		mm.add(100);	//아주머니 100 이라는 것을 컨테이너 안에 넣어주세요
		System.out.println(mm.size()); //지금 컨테이너 안에 몇개 있습니까? : 1개 있다
		
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm.size() + "개 있다.");
		
		// R(ead)
		// 방법 1) 아주머니 이름을 바로 주는 법 (단순하게 출력하긴 했지만, 활용할 순 없음..)
		System.out.println(mm); 
		
		// 방법 2) 활용도가 제일 높다. 
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) + " ");	// get
		}System.out.println();
		 
		// 방법 3) 
		// 자주 쓰는 변수 이름은 data, item, value, x (일반적으로 변수 이름으로 i는 피한다.)
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// get 활용
		int num = mm.get(2);
		System.out.println(num);
		
		// 배열 사용 방법
		int[] ar = {1, 2, 3};
		for (int data : ar) {
			System.out.print(data + " ");
		}System.out.println();
		
		// U(pdate)
		mm.set(5, 99);	// 0부터 시작. 5번째 데이터를 99로 바꿔주세요
		System.out.println(mm);	// 보기만 하면 되니까 우리는 이렇게 출력
		
		// D(elete)
		// delete, remove, erase
		mm.remove(5);	// 0부터 시작. 5번째 데이터를 지워주세요
		System.out.println(mm);
		
	}
}
*/

/*
//ex86) 비트 연산
public class Hello 
{
	static String HexaToBinary(int n){
		String s = Integer.toBinaryString(n);	
		while(s.length() < 32) 
			s = "0" + s;
		
		StringBuffer s1 = new StringBuffer(s);
			
		for (int i = 0; i < 7; i++) 
			s1.insert((7-i)*4, " ");
		

		return s1.toString();
	}
	
	public static void main(String[] args) 
	{
		int a = 0x3b12cd59;
		int b = 0x12345678;
		// bit and
		System.out.println(HexaToBinary(a));
		System.out.println(HexaToBinary(b));
		System.out.println(HexaToBinary(a & b)); // and
		System.out.println();
		
		// bit or
		System.out.println(HexaToBinary(a));
		System.out.println(HexaToBinary(b));
		System.out.println(HexaToBinary(a | b)); // or
		System.out.println();
		
		// ex-or : 둘중의 한개만 1일때 1이 나온다.
		// 0 0 >> 0   				// 일명 반전
		// 0 1 >> 1  				// 
		// 1 0 >> 1					//
		// 1 1 >> 0					//
		System.out.println(HexaToBinary(a));
		System.out.println(HexaToBinary(b));
		System.out.println(HexaToBinary(a ^ b)); // ex-or
		System.out.println();
		
		// shift : >> << 오른쪽이든 왼쪽이든 미는것
		System.out.println(HexaToBinary(a));
		a = a << 4;	// 네자리씩 왼쪽으로 밀어라 
		System.out.println(HexaToBinary(a)); //절벽으로 나간애는 없어지고 새로 들어오는 애는 0으로 들어옴
		System.out.println();
		
		System.out.println(HexaToBinary(b));
		b = b >> 4; // 네자리씩 오른쪽으로 밀어라 
		System.out.println(HexaToBinary(b)); //절벽으로 나간애는 없어지고 새로 들어오는 애는 0으로 들어옴
		System.out.println();
		
		//	0x0000ff00
		int c = 0x3b12cd59;
		// 0x 3b 12 cd 59			cd만 10진수로 얼만지가 궁금하다.. 궁금해..
		// 0xcd >> 205
		// System.out.println(HexaToBinary(c & 0x0000ff00));
		// System.out.println(HexaToBinary(c & 0xff00)); 이렇게 해도 결과는 같다.
		// cd00을 얻고 있다.. 그럼 어케? cd를 오른쪽으로 8자리를 옮기면 밑으로 내려간다!
		System.out.println(HexaToBinary( (c & 0x0000ff00) >> 8 ));	//확인하기 위해
		System.out.println((c & 0x0000ff00) >> 8 );
		System.out.println();
		
		// 그럼 3b가 얼만지? 계산긴 59라는데..
		System.out.println((c & 0xff000000) >> 24 );
		
		
		//질의 다시 설명해주시는거 기록
		System.out.println();
		System.out.println();
		System.out.println(HexaToBinary(0x3b12cd59));
		System.out.println(HexaToBinary(0x0000ff00));
		System.out.println(HexaToBinary(0x0000ff00 & 0x3b12cd59));
		
	}
}
*/

/*
//ex85-3) 85-2를 팔아먹기 위해 코드 정리
public class Hello 
{
	static String HexaToBinary(int n){
		String s = Integer.toBinaryString(n);	
		while(s.length() < 32) {
			s = "0" + s;
		}
		StringBuffer s1 = new StringBuffer(s);
			
		for (int i = 0; i < 7; i++) {
			s1.insert((7-i)*4, " ");
		}

		return s1.toString();
	}	
	
	public static void main(String[] args) 
	{
		System.out.println(HexaToBinary(0x3b12cd59));
		System.out.println(HexaToBinary(1));		
		System.out.println(HexaToBinary(0x1234));	
		System.out.println(HexaToBinary(1234));	
	}
}
*/

/*
//ex85-2)
public class Hello 
{
	static String HexaToBinary(int n){
		String s = Integer.toBinaryString(n);
		System.out.println(s);
		System.out.println(s.length());
		// s.length() >> 몇자리가 나올지 모른다.
		while(s.length() < 32) {
			s = "0" + s;
		}
		System.out.println(s.length());
		System.out.println(s);
		// 0011 1011 0001 0010 1100 1101 0101 1001 네자리마다 space를 집어넣겠다.
		// 배열 4번 다음에 space를 집어넣어라.
		
		// StringBuffer를 써야하니(?) String이 가지고 있는 데이터를 StringBuffer에 넣어야한다.
		StringBuffer s1 = new StringBuffer(s);
		//s1.insert(4, " ");		//앞에서부터 하니 데이터 변형이 오네?
		//System.out.println(s1);	//뒤에서부터해야겠다
		
		for (int i = 0; i < 7; i++) {
			System.out.println((7-i)*4);
			s1.insert((7-i)*4, " ");
		}
		//System.out.println(s1);		
		//s = s1.toString();	// 스트링버퍼는 단순히 insert를 쓰기 위했으니 다시 string으로 받고싶어서 씀
		return s1.toString();
	}	
	
	public static void main(String[] args) 
	{
		System.out.println(HexaToBinary(0x3b12cd59));
		
	}
}
*/

/*
//ex85-1)
public class Hello 
{
	public static void main(String[] args) 
	{
		int num1 = 1000;
		int num2 = 0x1000;	// 0x 를 붙이면 16진수 표기법이 되어버림.
		System.out.println(num1);
		System.out.println(num2);	//허나 10진수로 변환 후 표시
		
		int num3 = 0x3b12cd59;
		//  3     b    1    2     c    d    5    9
		// 0011 1011  0001 0010 1100 1101 0101  1001
		// 11   1011  0001 0010 1100 1101 0101  1001
		System.out.println(num3);
		
		String s = Integer.toBinaryString(num3);
		System.out.println(s);
		
		//111011000100101100110101011001	사람이 이렇게 보려면 불편.. 
		//0011 1011 0001 0010 1100 1101 0101 1001 네자리씩 끊어서 16진수로 봐야 그나마 보기가 편함..
		
		// 32비트로 끊어서 보고싶다!
		
		int num4 = 1;
		// 다음과 같이 출력되는 표준 클래스 함수는 없는가?
		// 없다. 직접 짜야한다. -> 85-2에서 해결하자
		//0000 0000 0000 0000 0000 0000 0000 0001 목적: 32비트로 끊어서 보고싶다..
	}
}
*/

/*
//ex84) 진법이론
public class Hello 
{
	public static void main(String[] args) 
	{
		
		// 2진수 네자리는 16진수 한자리와 동일하다.
		// 숫자를 사용할 때 사용할 수 있는 문자의 개수가 10개 일 때
		// 10진법 : 16진법
		//	 10 : A
		// 	 11 : B
		// 	 12 : C
		// 	 13 : D
		// 	 14 : E
		// 	 15 : F
		
		//  컴터 인간 16진수
		//  0000 0 0
		//  0001 1 1
		//  0010 2 2
		//  0011 3 3
		//  0100 4 4
		//  0101 5 5
		//  0110 6 6 
		//  0111 7 7
		//  1000 8 8
		//  1001 9 9 
		//  1010 10 A
		//  1011 11 B
		//  1100 12 C
		//  1101 13 D
		//  1110 14 E
		//  1111 15 F
		// 2진수 4자리는 16진수 1자리와 같다.
		// 그래서 네개씩 끊어서 암산을 한다.
		
	}
}
*/

/*
//ex83)
public class Hello 
{
	public static void main(String[] args) 
	{
		String s = "무궁화꽃이피었습니다";
		
		// 1. 문자열이나 배열의 길이를 얻을 때
		System.out.println(s.length());
		
		// 2. 문자열에서 문자 하나를 검색할 때
		// char charAt(int index)
		char ch = s.charAt(3);
		System.out.println(ch);
		
		// 3.indexOf
		// int indexOf(String str)
		System.out.println(s.indexOf("화꽃이"));
		// 못찾는 경우엔 어떻게? 인덱스로 받을 수 없는 숫자 최소값인 -1이 출력된다.
		System.out.println(s.indexOf("호궁화"));	
		
		int findNum = s.indexOf("습니");
		if(findNum != -1 ) {
			System.out.println("검색 성공 : " + findNum);
		}else {
			System.out.println("검색 실패");
		}
		
		// 4. 글자를 검색한 후 바꿔치기
		//s.replace("꽃이", "나무가");
		// s 객체가 실제로 변경되었는가? 
		System.out.println(s); // 변경되지 않았음 ㅠ
		// 주의 1 : 원본이 변경 되었는가를 반드시 확인하는 것.
		// 주의 2 : 실패했을 때를 반드시 확인해라
		String result = s.replace("꽃이", "나무가");
		System.out.println(result);
		
		// 5. 부분적으로 짤라올 때 사용한다. (slicing) 
		System.out.println(s.substring(5));
		// 3번부터 6번 앞까지(=5번까지) (6번은 포함 안됨! 주의할 것!)
		System.out.println(s.substring(3, 6));
		
		String s2 = "  호  랑  이  ";
		System.out.print(s2);
		System.out.println("독수리");		//뒤의 공백 확인용
		
		System.out.print(s2.trim());	// 앞과 뒤의 공백을 없앰 (중간의 것은 ㄴㄴ)
		System.out.println("독수리");		//뒤에 공백 사라졌는지 확인용
		
		
		// 6.
		//데이터를 받는 놈의 코드
		byte[] data = new byte[] {65, 'B', 'C', 'D'};
		String s3 = new String(data, 0, data.length);	// 0은 '배열번호 0부터 변환시켜라'는 뜻 , 마지막 랭스는 ~개를 변환시켜라
		System.out.println(s3);							// 데이터를, 0번부터, 데이터길이개 변환시켜라
		
		//데이터를 보내는 놈의 코드
		String s4 = "Banana";
		byte[] recv = s4.getBytes();
		for (byte b : recv) {
			System.out.println((char)b);
		}
		
		// 7. 문자열 검색 횟수를 카운팅 할 때 자주 사용된다.
		String s5 = "Apple";
		System.out.println(s5.toUpperCase());	//글자를 전부 대문자로 바꾸어줌
		System.out.println(s5.toLowerCase());	//글자를 전부 소문자로 바꾸어줌
		
		// covid Covid coVid = COVID , covid 
		// 같은 글자를 찾기 위해서 (대소문자 구분해서 검색에 걸리니, 전부 같은 대문자나 소문자로 바꾸어 찾기 위해서 씀) 
		
	}
}
*/


/*
//ex82) finally{}의 이유
class Tiger{
	void m1(int a, int b) {
		if(a>b) {
			System.out.println(1);
		}else {
			System.out.println(2);
			return;
		}
		System.out.println(3);
	}
	void m2(int a, int b) {
		try {
			if(a>b) {
				System.out.println(1);
			}else {
				System.out.println(2);
				return;		// try 안에 있으면 반드시 finally 안으로 들어간다.
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println(3);
		}
	}
		
	void m3(int a, int b) {
			if(a>b) {
				System.out.println(1);
			}else {
				System.out.println(2);
				System.out.println(3);
				return;		
			}		
				
	 	//이 코드가 만약 1000줄 짜리 코드라면...
			System.out.println(3);		
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		try {
			int a = 10 / 0;
			//int a = 10 / 2;
		} catch (Exception e) {
			System.out.println("익셉션이 발생");
		} finally {
			System.out.println("익셉션 발생여부와 관계없이 실행된다.");
		}
		System.out.println("---------------");
		Tiger t1 = new Tiger();
		t1.m2(20, 10);
		t1.m2(10, 20);
		System.out.println("---------------");
		t1.m2(20, 10);
		t1.m2(10, 20);
	}
}
*/

/*
//ex81)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 1이 출력이 되고 나서, 3초 뒤에 2가 출력이 되었으면 참 좋겠다.
		System.out.println(1);
		
		// 1000ms = 1초
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {Thread.sleep(3000);} catch (Exception e) {}	
			// 쓰레드슬립은 일반적으로 이렇게 쓰기때문에 한줄처리를 함
		}
		
		System.out.println(2);
	}
}
*/

/*
//ex80)
// 프로그래머가 직접 익셉션을 발생시킬 수가 있다.
class Tiger{
	void m1() {
		System.out.println("1 번 호출");
		
		try {
			throw new Exception();	//익셉션을 발생시키는 명령어 허나 try-catch와 함께 써야함
		} catch (Exception e) {
			System.out.println("익셉션이 발생함");
		}		
	}
	// throws Exception은
	// '이 익셉션은 함수 안에서 처리를 하지 않고
	// 이 함수를 호출한 놈이 처리를 하세요.' 라는 뜻
	void m2() throws Exception{
		System.out.println("2 번 호출");
		throw new Exception();
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Tiger();
		t1.m1();
		
		// Unhandled exception 
		try {
			t1.m2();
		} catch (Exception e) {
			System.out.println("말미잘");
		}
	}
}
*/

/*
//ex79) 예외처리(Exception)
//이 문법이 끝나면 "이 문법이 대체 뭐지?" 허나 맨 마지막에 무언가 하기 위한 과정이었다 라고 생각하시면 좋다.
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println("호랑이1");
		
		// 핵심은 : 에러가 발생하니까 프로그램이 중단되었다.
		// java.lang.ArithmeticException: / by zero
		// 예외처리는 에러가 발생을 하더라도 프로그램을 중단시키지 않겠다.
		
		//ex1)
		try {
			// 예외가 발생하면 catch로 분기한다.
			// 예외가 발생하지 않으면 catch로 가지 않는다.
			int a = 10 / 0;
		} catch (Exception e) {
			// e.printStackTrace(); //방금 발생한 익셉션이 어떤 것인지 출력해준다. 에러메세지아님
		}
		
		// ex2) java.lang.ArrayIndexOutOfBoundsException:
		//      Index 3 out of bounds for length 3
		int[] ar = {1, 2, 3};
		try {
			ar[3] = 1000;
		} catch (Exception e) {
			System.out.println("1");
		}
		
		// ex3) Null Pointer Exception
		String s = null;
		s = "무궁화꽃이피었습니다";
		//int num = s.length();
		System.out.println("문자열 길이 : " + s.length());
		
		// NullPointerException
		s = null;
		
		try {
			s.length();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("호랑이2");
	}
}
*/

/*
//ex78-4) 
//한게임이 서비스하고 있다.
class Baduk{
	AI ai;
	Baduk(AI ai){
		this.ai = ai;
		System.out.println("대국을 시작합니다.");
	}
	void play() {
		ai.play();
		// this.ai.play(); 와 동일한 코드
	}
	
	void stop() {
		ai.stop();
	}
}

interface AI{
	void play();
	void stop();
}

//구글
class AlphaGo implements AI{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수를 계산합니다.");
	}
}
//아마존
class BetaGo implements AI{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수를 계산합니다.");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Baduk baduk1 = new Baduk(new AlphaGo());
		Baduk baduk2 = new Baduk(new AlphaGo());
		baduk1.play();
		baduk1.stop();
		baduk2.play();
		baduk2.stop();
	}
}
*/

/*
//ex78-3) 문제점 : stop()이라는 함수를 만들때 인공지능을 또 전달해야한다.
//한게임이 서비스하고 있다.
// 비용이 많이 드는 경우 >> 파일 입출력
// 객체를 생성하는 경우 >> 시간 비용이 든다.
// 함수를 호출하는 것도 비용이 들고, 인수 전달을 하는 것도 비용이 든다.
// 비용이 들지 않는 방법이 있다면... 그 방법을 사용하는것이 옳다.
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play(AI ai) {
		ai.play();
	}
	
	void stop(AI ai) {
		ai.stop();
	}
}

//abstract class AI{
//	abstract void play();
//}
interface AI{
	void play();
	void stop();
}

//구글
class AlphaGo implements AI{
	public void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
	public void stop() {
		System.out.println("알파고가 점수를 계산합니다.");
	}
}
//아마존
class BetaGo implements AI{
	public void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
	public void stop() {
		System.out.println("베타고가 점수를 계산합니다.");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
		baduk.stop(new AlphaGo());
		baduk.stop(new BetaGo());
	}
}
*/

/*
//ex78-2) 문제점 : 새로운 인공지능이 생길때마다 함수를 계속 만들어야한다.
//한게임이 서비스하고 있다.
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play(AlphaGo alphaGo) {
		alphaGo.play();
	}
	void play(BetaGo betaGo) {
		betaGo.play();
	}
}

// 구글
class AlphaGo{
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}
//아마존
class BetaGo{
	void play() {
		System.out.println("인공지능은 베타고입니다.");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Baduk baduk = new Baduk();
		baduk.play(new AlphaGo());
		baduk.play(new BetaGo());
	}
}
*/

/*
//ex78-1) 문제점 : 인공지능이 변경된다면..? (베타고, 감마고)
class Baduk{
	Baduk(){
		System.out.println("대국을 시작합니다.");
	}
	void play() {
		System.out.println("인공지능은 알파고입니다.");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Baduk baduk = new Baduk();
		baduk.play();
	}
}
*/

/*
//ex77)
interface Fruit{
	void eat();
}

class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("맛없다");		
	}
}
class Tiger{
	Fruit fruit;
	Tiger(Fruit fruit){
		this.fruit = fruit;				//전형적인 코드 세줄
	}
	void m1() {
		fruit.eat();
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Tiger(new Fruit() {
			@Override
			public void eat() {
				System.out.println("맛있다...");				
			}
		});
		t1.m1();
		
		Apple apple = new Apple();
		Tiger t2 = new Tiger(apple);
		t2.m1();
	}
}
*/

/*
//ex76) 복습 해보자 한번 해보자
interface Tiger{
	void m1();	
}

class Lion implements Tiger{
	@Override
	public void m1() {
		System.out.println(1);
	}
}
class Apple{
	void m2(Tiger t) {
		t.m1();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Lion();
		t1.m1();
		
		Tiger t2 = new Tiger() {
			@Override
			public void m1() {
				System.out.println(2);		
			}
		};
		t2.m1();
		
		Apple t3 = new Apple();
		t3.m2(new Tiger() {
			@Override
			public void m1() {
				System.out.println(3);
				
			}
		});
	}
}
*/

/*
//ex75) 
interface Tiger{
	void m1();
	
}

class Lion implements Tiger{
	public void m1() {
		System.out.println(1);
	}
}

class Apple{
	// void m2(int a, String s, Tiger t, Lion l) {
	// new Lion() >> 된다. new Tiger() >> 안된다.
	void m2(Tiger t) {
		 t.m1();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		// 1
		Lion t1 = new Lion();
		t1.m1();
		// 2 업캐스팅
		Tiger t2 = new Lion(); // 업캐스팅
		t2.m1();
		
		// 3
		// Tiger t3 = new Tiger(); 코드는 성립이 안된다 (미완성 클래스는 생성하지 못한다.) 
		// 그런데 성립 시킬 수 있다.
		// t3는 누구 클래스를 보고 만들어졌는가? 
		// 익명 클래스를 이용한 방법 (클래스 이름이 뒤에 없다고 해서)
		Tiger t3 = new Tiger() {
			public void m1() {	//인터페이스 너는 코드가 없지만 아예 만들어 줄게
				System.out.println("호랑이");
				}
		}; 
		t3.m1();
		
		// 4 익명개체
		new Tiger() {
			public void m1() {	
				System.out.println("코끼리");
			}
		}.m1(); //도트사용
		
		// 이 문법의 활용  
		Apple t5 = new Apple();
		t5.m2(new Lion());
		
		System.out.println("---------------------");
		  t5.m2(new Tiger() {
		   public void m1() {
		    System.out.println("말미잘"); 
		   }
		  });
		 }
		}
*/

/*
//ex74) final은 총 3군데 사용할 수 있다.
	// 용도 3. 클래스 이름 앞에 final을 붙이면, 상속이 마지막이다.
final class Tiger{
	// 용도 1. 값을 대입 받는 것이 여기서 마지막이다. 
	final int num = 100;
	
	// 용도 2. 함수이름 앞에 final을 붙이면, 함수 오버라이딩이 마지막이다.
	final void m1() {
		
	}
}

// Tiger가 파이널이라 Lion은 상속을 할 수가 없다.
//class Lion extends Tiger{
//	// void m1() {} // 파이널이 걸린 함수이름이 있어서 성립이 안됨
//}

//스트링은 파이널이라 상속이 안된다.
class Test extend String{
	
}
// 쓰레드는 된다.
class Apple ext Thread{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		// t.num = 200; // 파이널이 100으로 잡혀서 성립이 안됨
	}
}
*/

/*
//ex73-3) 한개 이상 상속을 받을 목적이라면 인터페이스로 받는 것이 좋다
class A{
	void m1() {
		System.out.println(1);
	}
}
interface B{
	void m2();
}
interface C{
	void m3();
}

class E extends A implements B, C{	//B,C 때문에 m2,m3를 구현 해줘야함
	public void m2() {
		System.out.println(2);
	}
	public void m3() {
		System.out.println(3);
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{	
		E t = new E();
		t.m1();
		t.m2();
		t.m3();
		
		String s1 = "호랑이";
		String s2 = null; // null은 아직 객체가 아니다 라는 뜻 =도 안쓰고 안넣어도 같은 뜻임
		
		StringBuffer s3 = null;
	}
}
*/

/*
//ex73-2) 부모는 (클래스는 하나) 하나지만 인터페이스는 여럿이 된다.
class A{}
interface B{}
interface C{}
interface D{}

class E extends A implements B, C, D{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{	
	}
}
*/

/*
//ex73-1)
class A{}
class B extends A{}	 // 모양은 A <-B <-C 이런 모양
class C extends B{}  // 여기서 B가 D도 상속받는 다중상속이 됩니까? 자바는 안됨 (클래스는 하나) 허나 인터페이스는 여럿이 됨

public class Hello 
{
	public static void main(String[] args) 
	{	
	}
}
*/

/*
//ex72-3) 한국은행은 인터페이스 역할만 하고 있다.
// 1. abstract class가 interface 로 변경이 되었다.
// 2. 함수 이름 앞의 abstract를 생략했다.
// 3. extends이라 쓰지않고 implements 로 수정한다.
// 4. 구현 함수는 반드시 앞에 public 이 붙어야한다.
interface 한국은행{	//abstract도 되지만 인터페이스로 쓰는게 훨씬 낫다.
	void 입금();		//인터페이스를 넣는 순간  abstract는 안써도 된다.
	void 출금();
	void 대출();
	void 이체();
}

class 국민은행 implements 한국은행{
	public void 입금() {}
	public void 출금() {}
	public void 대출() {}
	public void 이체() {}
}

class 하나은행 implements 한국은행{
	public void 입금() {}
	public void 출금() {}
	public void 대출() {}
	public void 이체() {}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		국민은행 a = new 국민은행(); 
		한국은행 b = new 하나은행(); 
	}
}
*/

/*
//ex72-2)
abstract class 한국은행{
	abstract void 입금();
	abstract void 출금();
	abstract void 대출();
	abstract void 이체();
}

class 국민은행 extends 한국은행{
	void 입금() {}
	void 출금() {}
	void 대출() {}
	void 이체() {}
}

class 하나은행 extends 한국은행{
	void 입금() {}
	void 출금() {}
	void 대출() {}
	void 이체() {}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		국민은행 a = new 국민은행(); // 스스로 받던지
		한국은행 b = new 하나은행(); //업캐스팅 하던지 둘 다 가능
	}
}
*/

/*
//ex71)
abstract class 대장장이{
	void 칼() {
		System.out.println("멋진 칼");	//방패 못만들면 쓰지마가 되어버림
	}
	abstract void 방패();	//대장장이는 방패를 잘 못만드니까 누군가 만들어주길 바랫다. 
}

class 나그네1 extends 대장장이{
	void 방패() {
		System.out.println("억지로 만듬...");
		칼();	//부모가 칼을 가지고 있으니 칼을 사용하는 것은 문제가 안됨
	}
	
class 나그네2 extends 대장장이{
		void 방패() {
			System.out.println("전문가");
			for (int i = 0; i < 3; i++) {
				칼();
			}
		}
	
}


public class Hello 
{
	public static void main(String[] args) 
	{
		//대장장이 t1 = new 대장장이();	//미완성 되었기 때문에 객체 생성이 안된다.
		대장장이 t1 = new 나그네1(); // 나그네1 = new 나그네1(); 해도 됨
		t1.칼();
		t1.방패();
		
		대장장이 t2 = new 나그네2();
		t2.칼();
		t2.방패();
	}
} //에러
*/

/*
//ex70) 쉬는 시간 전 짜투리 코드 - 표준클래스를 잘 사용하는 것이 자바를 잘한다는 것
public class Hello 
{
	public static void main(String[] args) 
	{
		// Math 라는 표준 클래스 사용하는 법
		System.out.println(Math.PI); //Math는 스태틱이기때문에 바로 사용가능 , 파이값 구하기
		System.out.println(Math.abs(-15));
		System.out.println(Math.max(10, 20)); // 큰 값을 리턴시켜줌
		System.out.println(Math.min(10, 20)); // 작은 값을 리턴시켜줌
		System.out.println(Math.sin(50)); // sin값을 구하는 함수
		// 소수점 이하 자리를 자신을 기준으로 바닥쪽 숫자로 맞춘다.
		//							 4.00	
		System.out.println(Math.floor(3.99)); 
		//							 3.00	
		// 소수점 이하 자리를 자신을 기준으로 위쪽 숫자로 맞춘다.
		//							 4.00	
		System.out.println(Math.ceil(3.01)); 
		//							 3.00	
		// 소수점 이하 자리를 자신을 기준으로 바닥쪽 숫자로 맞춘다.
		//							  -3.00	
		System.out.println(Math.floor(-3.99)); 
		//							  -4.00	
		// 소수점 이하 자리를 자신을 기준으로 위쪽 숫자로 맞춘다.
		//							 -3.00
		System.out.println(Math.ceil(-3.01)); 
		//							 -4.00
	}
}
*/

/*
//ex69)
abstract class Tiger{
	// 부모 함수가 할일이 없을때 함수 이름앞에 abstract를 붙인다. {}를 생략
	// abstract - 추상 이라는 뜻
	// 추상함수라고 함
	// 클래스 안에 추상함수가 1개라도 있으면 그 클래스도 추상 클래스이어야 한다.
	abstract void m1(); 
	
	//추상의 뜻 : 미완성 이라는 뜻을 가진다.
	//m1 함수 코드가 미완성 되었다 라는 뜻  
}
class Lion extends Tiger{
	void m1() {
		System.out.println(1000);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Lion(); //부-자 : 업캐스팅
		t.m1();
		
		// 이 코드가 성립이 안된다. 왜? 
		// 추상 클래스만으로 되어 있기 때문에 객체를 생성시킬 수 없다.
		// Tiger t2 = new Tiger();
		
		//추상 클래스를 상속받은 자식은 반드시 반드시 함수를 오버라이딩 해야한다. 
		// (반드시 부모가 이루지 못한 꿈을 이뤄줘야 하는 책임이 있음) 그렇지 않으면 문법 에러.
	}
}
*/

/*
//ex68-3) 68-2번이 68-3으로 어떻게 바뀌는가, 결국 모두 68-1에서 유도된 과정
class Animal{
	//다양한 형태의 결과가 나올 수 있는 이 상황을 : "다형성" 이라고 한다.
	void cry() {System.out.println("...");}
}
class Dog extends Animal{
	//오버라이딩(주의 : 오버로딩하고 다름) : 상속관계에서 부모,자식 이름을 똑같이 짓고 사용하는 것
	void cry() {System.out.println("멍멍");}
}
class Cat extends Animal{
	void cry() {System.out.println("야옹");}
}
class Snake extends Animal{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Random rn = new Random();
		Animal[] ani = {new Dog(), new Cat(), new Snake()}; //업캐스팅 덕분에 이렇게 사용 가능
		for (int i = 0; i < 5; i++) {	// for문을 사용해봅시다.
			int num = rn.nextInt(3); // 0, 1, 2
			ani[num].cry(); 	//결국 업캐스팅에서 유도되어서 사용되는 문장
		}		
	}
}
*/

/*
//ex68-2)
class Animal{
	void cry() {System.out.println(2);}
}
class Dog extends Animal{
	void cry() {System.out.println(0);}
}
class Cat extends Animal{
	void cry() {System.out.println(1);}
}
class Snake extends Animal{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Dog t0 = new Dog();
		Cat t1 = new Cat();
		Snake t2 = new Snake();
		
		int num = 1; // 0, 1, 2
		switch (num) {
		case 0:
			t0.cry();
		break;
		case 1:
			t1.cry();
		break;
		case 2:
			t2.cry();
		break;
		}
	}
}
*/

/*
//ex68-1)
public class Hello 
{
	public static void main(String[] args) 
	{
		int[] ar = new int[10];
		String[] br = new String[3]; //문자를 저장할 수 있는 변수가 세개만들어짐
		br[0] = new String("호랑이"); // br[0] = "호랑이"; 와 같다.
		br[1] = new String("코끼리");
		br[2] = new String("독수리");
		
		int[] cr = new int[] {10,20,30};
		String[] dr = new String[] {
					new String("호랑이"),
					new String("코끼리"),
					new String("독수리")
		};
		
		int[] er = {10, 20, 30};		// ar cr er 다 문법이 같음
		String[] fr = {
				new String("호랑이"),
				new String("코끼리"),
				new String("독수리")
		};
	
	}
}
*/

/*
//ex67) 업캐스팅을 사용하는 이유
class Animal{
	void cry() {
		System.out.println("...");
	}
}

class Dog extends Animal{
	void cry() {	//업캐스팅의 가능성
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("야옹");
	}
}

class Snake extends Animal{

}
//  동물이 한마리 생길때마다 함수를 계속 만들어 줘야했었던 것을 업캐스팅으로 해결
class Zoo{
	//Animal ani = new Dog(); new Cat(); new Snake(); 
	void sound(Animal ani) {
		ani.cry();
	}
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Zoo zoo = new Zoo();
		zoo.sound(new Dog());
		zoo.sound(new Cat());
		zoo.sound(new Snake());
	}
}
*/

/*
//ex66)
class Animal{
	void cry() {
		System.out.println("...");
	}
}

class Dog extends Animal{
	void cry() {	//업캐스팅의 가능성
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("야옹");
	}
}

class Snake extends Animal{

}

public class Hello 
{
	public static void main(String[] args) 
	{
		Animal t1 = new Dog();
		Animal t2 = new Cat();
		Animal t3 = new Snake();
		t1.cry();	//업캐스팅 사용. 자식의 것이 있으니 자식의 것으로
		t2.cry();
		t3.cry();	//자식의 것이 없으니.. 그냥 부모의 것		
		
		System.out.println("---------------"); 
		//아래도 같은 결과값이 나올텐데 엌배스팅을 그럼 왜 했니? -> 67번으로
		Dog t4 = new Dog();
		Cat t5 = new Cat();
		Snake t6 = new Snake();
		t4.cry();
		t5.cry();
		t6.cry();
	}
}
*/

/*
//ex65) 업캐스팅 반드시 자식을 쳐다보고 자식이 있으면 자식것을, 없으면 부모것을 실행한다. 
class Tiger{
	void m1() {
		System.out.println(1);
	}
	
	void m3() {
		System.out.println(31);
	}
}
class Lion extends Tiger{
	void m2() {
		System.out.println(2);
	}
	//뒤에 만든 m3임
	void m3() {
		System.out.println(32);
		m2(); //이 상황에선 가능 (자기가 자식이고) 자식것이니
		m1(); //자신의 것(이 상황에서 자식) 찾아보고 없으면 부모 찾는것이니 가능
		super.m3();
	}
}


public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Lion();
		t.m1(); // 이것(부모의것) 말고는 없다. m2는 메모리는 존재하지만 사용 할 수 없다
		t.m3(); // 업캐스팅이니 자식것을 찾아보고 자식도 있으면 자식것을 실행		
	}
}
*/

/*
//ex64) (업캐스팅, 다형성) : 디자인패턴
class Tiger{
	void m1() {
		System.out.println(1);
	}
}
class Lion extends Tiger{
	void m2() {
		System.out.println(2);
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		//(클래스를 사용할 수 있는) 방법1 ( 부모이름 = 뉴 부모이름 ) - 상속과 관계가 없다.
		Tiger 1t = new Tiger();
		
		//방법2 ( 자식 = 자식 ) - 
		Lion t2 = new Lion();
		
		//방법3 ( 자식 = 부모 ) - 자바에서 이런 문법은 지원하지 않음
		// Lion t3 = new Tiger(); //다운캐스팅 
		
		//방법4 ( 부모 = 자식 ) - 
		//'부=자관계'로 암기 : 전문용어로 "업캐스팅"이라고 한다. -타입이 같지 않은것을 타입이 같게 만들어주는것
		Tiger t4 = new Lion();
		
		int a = 10;
		short b = 20; 
		// a = b; // 4 = 2 작은놈을 큰놈에 넣으니 넘어가준다. 허나 잘못된 문법이다. 왼쪽과 오른쪽의 타입이 같아야한다.
		
		// 이 한줄의 코드에서만 b가 int 라고 가정하라. - 타입캐스팅
		a = (int)b; // 		
		//a야 지금 이 순간만은 short로.. -타입캐스팅
		b = (short)a; 
		
	}
}
*/

/*
//ex63) 시간상 짜투리 문법
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10;
		a = a + 3;
		System.out.println(a);
		
		// 쓰는 이유 뽀대가 난다. +=가 붙어있어서 치는 속도가 빠르다 
		a += 3; // 복합 대입 연산자 (위의 코드나 밑의 코드나 똑같다)
		System.out.println(a);
		
		// 실행 속도는 동일하다. 그럼 차이가 뭡니까?
		// 밑의 코드가 컴파일(기계어로 번역하는 속도)이 빠르다. 
		// 요즘은 기계가 좋아서 컴파일 속도 체감 거의 못함 30년 전에나 속도 때문에 썻음
		
		int b = 20;
		b = b * 3;
		b *= 3;
		
		int c = 10; 
		c = c + 1; // 컴파일 속도 문제 초보 일때나, 복합대입 연산을 안할때 일반적으로 사용
		c += 1;	   // 컴파일 속도 문제 컴파일 속도가 빠르다
		c++;	// 대입증가  / 실행속도 제일 빠르다. 
		++c;	// 실행속도 제일 빠르다.
		
	}
}
*/

/*
//ex62)
class Tiger{
	int money;
	Tiger(int num){
		money = num;
		System.out.println(1);
		}
	}

class Lion extends Tiger{
	int money;
	Lion(int num){
		// super(); 코드 한줄이 생략되어 있다. super 코드는 반드시 첫줄에 와야한다.
		super(num/5); // 부모 생성자 콜 하세요.
		//super(3, 4); 만약 두개 잡혀있으면 이것도 가능
		money = num/2;
		System.out.println(2);
	}
	
	void show() {
		System.out.println(this.money + " " + super.money);
	}
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Lion on = new Lion(5000);
		// 생성순서 : 부모 생성자가 콜이 되고, 자식 생성자가 콜된다
		// 는 거짓말이다 
		// 정답은 : 자식이 먼저 콜이 되고, 부모 콜 순서가 된다. 그런데 왜 출력은? = 생략된 코드 때문
		
		on.show();
	}
}
*/

/*
//ex61) 자식이 또 다른 부모가 되어 자식을 만들 수 있느냐
class A{		//부모
	void m1() {
		System.out.println(1);
	}	
}
class B extends A{	//A의 자식
	void m2() {
		System.out.println(2);
	}	
}

class C extends B{	//B의 자식, A의 손자
	void m3() {			//쓸 수 있는 함수 : 3번 2번 1번 쓴다
		System.out.println(3);
	}
}

class D extends A{ //A의 자식이고, B,C와는 남남
	void m4() {			//쓸 수 있는 함수 : 1번 4번만 쓴다.
		System.out.println(2);
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		C c = new C();  // C에 커서를 대고 F4를 누르면 상속 계층도를 볼 수 있다. 
		c.m1();
		c.m2();
		c.m3();
		
		D d = new D();
		d.m1();
		d.m4();
		
		System.out.println(d.hashCode());
	}
}
*/

/*
//ex60) 상속
class Tiger{ // 부모
	// 만약 본 클래스의 기능이 훌륭하다.
	void m1() {
		System.out.println(1);
	}
	
	void m3() {
		System.out.println(31);
	}
	
}

class Lion extends Tiger { // 자식
	void m2() {
		System.out.println(2);
	}
	
	void m3() {
		System.out.println(32);
	}
	
	void m4() {
		m3();	   // 자기 것
		this.m3(); // 자기를 이야기 하니까, 결국 자기것 
		super.m3(); // 슈퍼맨이 돌아왔다 생각해봐라 슈퍼맨 = 아빠
	}
} 


public class Hello 
{
	public static void main(String[] args) 
	{
		//상속과 아무 관계가 없다. 기존의 타이거를 이용하여 타이거를 만들었음 그냥 타이거를 사용했을 뿐
		Tiger t = new Tiger();
		
		Lion on = new Lion();
		on.m1(); //본인에게 가보고 없으니 부모꺼 그대로 씀
		on.m2();
		on.m3(); // 무조건 자기꺼 먼저 보고, 없으면 부모로 간다.
				System.out.println("------------");
		//부모 m3를 사용할 수 있는 방법은 없습니까?
		//직접적으로는 없다.
		//간접적으로는 있다. 자식을 거쳐서 부모를 사용하는 법
		on.m4();
		
	}
}
*/

/*
//ex59-4)
//스태틱이 있으면 객체 생성 없이 클래스 이름으로 바로 사용할 수 있다.
public class Hello 
{
	void m1() {
		System.out.println(1);
	}
	public static void main(String[] args) 
	{
		Hello h = new Hello();
		h.m1();
		h.m2();
		Hello.m3();
	}
	void m2() {
		System.out.println(2);
	}
	static void m3() {
		System.out.println(3);
	}
}
*/

/*
//ex59-3)
public class Hello 
{
	//생성자 만들 수 있느냐?
	static int a = 10;	
	int b, c;
	Hello(){
		
	}
	static void m1() {	
		System.out.println("호랑이");
	}
	
	void m2() {
		System.out.println("코끼리");
	}
	
	//main함수(운영체제가 호출한다.) "windowOS.main()" 
	//Hello.main() 
	//클래스가 나온 이유 스태틱 덕분에
	public static void main(String[] args) 
	{
		// static 함수 안에서는 반드시 static변수(필드), static함수(메쏘드)만 사용할 수 있습니다.
		System.out.println(a);
		m1();
		
		Hello h = new Hello();
		h.b = 20;
		h.m1();
		h.m2();
	}
}
*/

/*
//ex59-2)
class Tiger{
	static int num = 0;
	Tiger(){
		num++;
	}
	
	static void m1() {
		System.out.println("호랑이");
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		//Tiger t1 = new Tiger();
		//Tiger t2 = new Tiger();
		//Tiger t3 = new Tiger();
		//System.out.println(Tiger.num); //이를 통해 객체가 3번 생성되었음을 알 수 있다.(스태틱3)
		
		System.out.println(Tiger.num);
		//Tiger t1 = new Tiger(); //아래와 비교하기 위해 
		//t1.m1();				  // 객체를 생성해봄
		Tiger.m1(); // 스태틱은 객체를 생성시키지 않고 사용 할 수 있다.
		
		System.out.println( Math.PI ); //M 첫자가 대문자라는 이유는 클래스, PI에 스태틱을 걸어놨구나
		System.out.println( Math.abs(30)); 
	}
}
*/

/*
//ex59-1)
class Tiger{
	static int num = 0; // t1,2,3 의 공동소유, 비행기의 설계도의 관제탑, 관제탑은 1개다
	int count = 0; // 각각의 카운트 (공동소유x), 각각 비행기의 좌석
	void show() {
		System.out.println(num + " " + count);
	}
	void add() {
		num++;
		count++;
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		t1.add();
		t2.add();
		t3.add();
		t1.show();	//t1도 t2도 t3도 ++해줘서 공동의 관제탑엔 3이 됐고
		t2.show();	//별도의 count엔 0에서 각자 자신의 것에 ++해줘서
		t3.show();	//각자 1씩
	}
}
*/

/*
//ex58) this의 3번째 용법
//호랑이가 사자에게 사랑한다고 할 것이다.
//다른 클래스에 나의 클래스의 정보를 넘길때 사용한다.
class Tiger{
	void m1() {
		Lion lion = new Lion();
		if(lion.love(this) == true){ //여기서 this는 호랑이의 정보 모든 것을 다 던진 것임
		System.out.println("감사합니다");
	}else{
		System.out.println("잉잉잉...");
	}
}
	int 재산() {
		return 500;
	}
	String 성격() {
		return "포악함";
	}
}

class Lion{
	boolean love(Tiger t) {
		// ok, NG 둘 중 하나를 할 것
		int money = t.재산();
		if(money > 520) {
			System.out.println("OK");
			return true;
		}else {
			if(t.성격() == "포악함") {
				System.out.println("NG");
				return false;
			}else {
				System.out.println("OK");
				return true;
			}
		}
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1();
	}
}
*/

/*
//ex57) 58번을 위한 밑밥
class Tiger{
	Tiger m1() {
		System.out.println(1);
		return this; // 생성시켰던 걔로 리턴시켜줄게
	}
	void m2(Tiger t) {
		t.m1();
		System.out.println(2);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m2(t.m1());
	}
}
*/

/*
//ex56)
class Tiger{
	Tiger m1() {
		System.out.println("아침을 먹는다.");
		return this;
	}
	Tiger m2() {
		System.out.println("점심을 먹는다.");
		return this;
	}
	Tiger m3() {
		System.out.println("저녁을 먹는다.");
		return this;
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		//쓸 데 없는 코드 난입을 방지한다. (체이닝 기법을 사용하는 이유)  
		t.m1().m1().m2().m3();
		System.out.println("-----------------"); //아래와 같은 출력결과지만 엉뚱한 둥근해(코드) 난입을 막음
		t.m1(); // 1번 장비의 시동을 건다.
		t.m1(); // 2번 장비의 시동을 건다.
		System.out.println("둥근해가 떴습니다.");
		t.m2(); // 장비를 운용시킨다.
		t.m3(); // 장비를 리셋시킨다.
	}
}
*/

/*
//ex55) This에 대한 2번째 사용법 (53번과 이어서) : 메쏘드 호출 체이닝을 위해서 사용된다.
class Tiger{
	int m1() {
		System.out.println("m1");
		return 100;
	}
	String m2() {
		System.out.println("m2");
		return "호랑이";
	}
	Lion m3() {
		System.out.println("m3");
		return new Lion();
	}
	
	// 여기 코드가 핵심
	Tiger m4() {
		System.out.println("m4");
		return new Tiger();
	}
	
	Tiger m5() {
		System.out.println("m5");
		System.out.println(this.hashCode());
		return this;
	}
	
}

class Lion{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		System.out.println(t.m1());
		System.out.println(t.m2());
		t.m3();
		t.m4();
		Tiger t3 = t.m5();
		System.out.println(t.hashCode());
		System.out.println(t3.hashCode());
		
		// 체이닝 기법 
		t.m5().m5().m5().m1();
	}
}
*/

/*
//ex54)짜투리 문법임 55번이 this를 사용하는 두번째 이유 (시간이 애매해서 잠시 짜투리)
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10, b;
		b = a++; // 대입 증가 : a가 가지고 있는 내용을 먼저 대입하고 나서 증가하겠다.
		System.out.println(a + " " + b);
		
		int c = 10, d;
		d = ++c; // 증가 대입 : c가 가지고 있는 내용을 먼저 증가하고 나서 대입하겠다.
		System.out.println(c + " " + d);
		
	}
}
*/

/*
//ex53) 단축 메뉴를 이용해서 생성자 생성
class Tiger{
	int apple;
	int banana;
	Tiger(int apple, int banana) {
		this.apple = apple;
		this.banana = banana;
	}
	void show() {
		System.out.println( apple + " " + banana);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger(100, 200);
		t.show();
		
	}
}
*/

/*
//ex52) this를 사용하는 첫번째 이유
class Tiger{
	int a, b;
	Tiger(int a, int b){
		this.a = a; // 필드 = 인수
		this.b = b; // 필드 = 인수
	}
	void show() {
		System.out.println(this.a + " " + this.b);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger(100, 200);
		t.show();
		
		int a = 10;
		a = a; // 자기대입코드는 의미가 없다.
		
	}
}
*/

/*
//ex51) this
class Tiger{
	int age;
	
	Tiger(){
		System.out.println(this.hashCode()); //미래에 태어날 아기를 가르킨다.
	}
	
	void showData() {
		// System.out.println(age); 아래의 코드에서 this가 생략된 것, 이렇게 써도 된다.
		System.out.println(this.age);
		
		//m1(); 여기서도 this를 생략할 수 있기때문에 생략된 코드, 이렇게 쓸 수 있음
		this.m1();
	}
	
	void m1() {
		
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger 홍길동 = new Tiger();
		System.out.println(홍길동.hashCode()); //(길동이) this와 해쉬코드가 같다.
		
		Tiger 개똥이 = new Tiger();
		System.out.println(개똥이.hashCode()); //개똥이는 개똥이 대로 해쉬코드가 같다.
	}
}
*/

/*
//ex50) 49번과 같은 프로그램
class Tiger{
	int age;
	Tiger(){
		System.out.println(1);
		age = 0;
	}
	Tiger(int a){
		System.out.println(2);
		age = a;
	}
	Tiger(String s){
		System.out.println(3);
		age = s.length();
	}
	Tiger(int a, int b){
		System.out.println(4);
		age = a * b;
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(20);
		Tiger t3 = new Tiger("무궁화꽃이피었습니다");
		Tiger t4 = new Tiger(20,30);
		System.out.println(t1.age);
		System.out.println(t2.age);
		System.out.println(t3.age);
		System.out.println(t4.age);
	}
}
*/

/*
//ex49) 생성자 목적에 대한 프로그램
class Tiger{
	int a=10, b=20;
	
	//인수전달이 없는 생성자를 디폴트 생성자라고 한다.
	Tiger(){
		System.out.println("생성자콜1");
	}
	Tiger(int x, int y){
		System.out.println("생성자콜2");
		a = x;
		b = y;
	}
	
	void showData() {
		System.out.println( a + " " + b );
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger(50, 60);
		t1.showData();
		t2.showData();
	}
}
*/

/*
//ex48)
class Tiger{
	// 생성자 - 1.생성자는 생성자메쏘드의 약자
	// 		  2.생성자는 반드시 클래스이름이랑 동일해야한다.
	//		  3.생성자는 return 값을 가질 수 없다.	 (void도 없다.)
	//		  4.생성자 함수(메쏘드)는 객체가 생성될때 자동 호출된다.
	//		  5.생성자는 자동호출을 제외하고 임의로 호출 할 수 없다.
	//					객체 1개당 1번만 호출된다.
	//		  6.어디에 사용하는 물건인가? 멤버 필드를 초기화 하는 목적 (다른 목적 없음 이게 다임)
	Tiger() {
		System.out.println("생성자 콜");
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		Tiger t = new Tiger();
		System.out.println(2);
		Tiger s = new Tiger();
		System.out.println(s.hashCode());
		System.out.println(3);
		
		s = new Tiger();
		System.out.println(s.hashCode());
	}
}
*/

/*
//ex47) 함수 이름을 동일하게 작성할 수 있는 방법이 있다. 2가지나
// 방법1. 전달되는 인수의 개수가 다르던지
// 방법2. 전달되는 인수의 개수가 같다고 하더라도 타입이 다르면
// 함수 이름을 동일하게 작명할 수 있다. 이것을 함수 재정의(OverLoading)이라고 한다.
class Tiger{
	void m1() {
		System.out.println(1);
	}
	void m1(int a) {
		System.out.println(2);
	}
	void m1(int a, int b) {
		System.out.println(3);
	}
	void m1(String a, int b) {
		System.out.println(4);
	}
	
	
	void showMessage(String title, String content) {
		System.out.println("제목은" + title + "입니다.");
		System.out.println("내용은" + content + "입니다.");
	}
	
	void showMessage(String content) {
		System.out.println("내용은" + content + "입니다.");
	}
	
	void getAreaRectangle(int length) {
		
	}
	void getAreaRectangle(int width, int height) {
		
	}
	void getAreaRectangle(int width, int height, int color) {
		
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1();
		t.m1(10);
		t.m1(10,20);
		t.m1("호랑이", 20);
		t.showMessage("...부처 장관님에게", "코로나 종식" );
	}
}
*/

/*
//ex46)
class Tiger{
	// Lion on = new Lion(); 
	void m1(String s, Lion on) {
		System.out.println("나는 호랑이" + s );
		System.out.println(on.age);
		on.m1();
	}
	
}

class Lion{
	int age = 100;
	
	void m1() {
		System.out.println("나는 사자");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1("독수리1", new Lion()); //방법 1
		System.out.println("-------------------");
		Lion t2 = new Lion();
		t.m1("독수리2", t2);			// 방법 2
	}
}
*/

/*
//ex45)
class Tiger{
	int num = 10;
	float ff = 3.14f;
	String s1 = "홍길동";
	String s2 = new String("이순신장군님");
	
	
	void m1(int a, boolean b, String s) {
		System.out.println(s);
		System.out.println(s.length());
	}
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		// 기본타입
		// byte, char, short, int, long, float, double, boolean
		
		//String의 첫자가 대문자이다. (표준 타입이 아니라 클래스 라는 말임)
		//자바에서 제공하고 있는 클래스이다.
		
		String s1 = "호랑이"; // 우리가 이렇게 적었어도 내부적으로는 new를 사용하고 있다.
		System.out.println(s1);
		
		//F3번을 이용해서 가끔씩 오픈소스를 구경한다.
		//String클래스는 잘만들어진(유용한) 메쏘드가 20개 정도 있다.
		// 8개 정도만 잘 사용해도 프로그램 짜는데 전혀 문제 없다. good
		String s2 = new String(); //보편적인 클래스 사용법
		s2 = "무궁화꽃이피었습니다";
		System.out.println(s2.length());
		
		Tiger t = new Tiger();
		t.m1(0, false, "앵무새");
		t.m1(0, false, new String("사과"));
	}
}
*/

/*
//ex44)
class Tiger
{
	void m1(int num) {
		System.out.println("m1 call");
		for (int i = 0; i < 10; i++) {
			if(num == i) {
				System.out.println("찾았다.");
				break;
			}
		}
		System.out.println("국민은행을 찾아주셔서 감사합니다.1"); // for문만 중단했기에 출력됨
	}
	
	void m2(int num) {
		System.out.println("m2 call");
		for (int i = 0; i < 10; i++) {
			if(num == i) {
				System.out.println("찾았다.");
				return;
			}
		}
		System.out.println("국민은행을 찾아주셔서 감사합니다.2"); // 함수를 탈출해서 출력이안됨
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1(6);
		t.m2(6);
	}
}
*/

/*
//ex43)
class Tiger
{
	void m1() {
		//단독으로 return 키워드를 사용할 때는 함수를 탈출(중단)한다
		return;		
	}
	
	void m2(int num) {
		if( num < 0) {
			System.out.println("음수는 입력할 수 없습니다.");
		}else {
			if( num % 2 == 0 ) 	{
			System.out.println( num + "짝수");
		}
		else{
			System.out.println( num + "홀수");
		}
	 }
	}		
	//m2는 안좋은 예시(제어문이쓸데없이많음)임 returen을 사용해서 m3를 만들면 더 깔끔한 코드
	void m3(int num) {
		if( num < 0) {
			System.out.println("음수는 입력할 수 없습니다.");
			return;
		}
		if( num % 2 == 0 ) 	{
		System.out.println( num + "짝수");
		}
	else{
		System.out.println( num + "홀수");
		}
	}
	
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m2(100);
		t.m2(101);
		t.m2(-10);
	
	}
}
*/

/*
//ex42) 
class Tiger
{
	void m1() {
		m2();
		System.out.println(1); // 출력순서 3
		m2();
		m3();
	}
	void m2() {
		System.out.println(2); // 출력순서 1	4	
		m3();
	}

	void m3() {
		System.out.println(3); // 출력순서 2	5	6
	}
	
	//서로가 서로를 부르는 형태로는 사용할 수 없다.
	void m4() {
		m5();
	}
	
	void m5() {
		m4();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1();
		//t.m5();
	}
}
*/

/*
//ex41)
class Tiger{
	void m1() {
	System.out.println(1);
		//인수 전달 없고 리턴이 없다.
	}
	void m2(int a, int b) {
		System.out.println(2);
		//인수 전달 있고 리턴이 없다.
	}
	int m3() {
		System.out.println(3);
		//인수 전달 없고 리턴이 있다.
		return 100; 
	}
	int m4(int num) {
		System.out.println(4);
		 //인수 전달 있고 리턴이 있다.
		return 100;
	}
}
public class Hello  //아직 다 못함
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1();
		t.m2(10, 20);
		System.out.println(t.m3());
		System.out.println(t.m4(10));		
	}
}
*/


/*
//ex40)
class Tiger{
	// void는 없다 라는 뜻을 가지고 있다.
	// 강아지가 주인에게 리턴하는 게 없다 라는 뜻
	void m1() {
		System.out.println("m1 call");
	}
	
	int m2() {
		System.out.println("m2 call");
		return 100;
	}	
	int m3() {
		int a = 1000, b = 2000;
		return a + b;		
	}
	
	int m4(int a, int b) {
		return a * b + a;
	}
	
	// 반드시 로직상으로 return을 만나야 한다.
	int m5(int a, int b) {
		if(a > b) {
			return 1000;
		}
		else {
			System.out.println("멍멍");
			return 2000;
		}
	}
	
	int m6(int a, int b) {
		return a + b;
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		
		System.out.println(t.m6(4, 3));
		System.out.println("---------------");
		
		t.m1();
		//방법1
		int a = t.m2();
		System.out.println(a);
		
		//방법2
		System.out.println(t.m2());
				
		//안받아줌 100이 사라짐
		t.m2();
		
		System.out.println(t.m3());
		
		int b = t.m4(3, 4); 
		System.out.println(b);
		
		System.out.println(t.m5(4, 3));
		System.out.println(t.m5(3, 4));
	}
}
*/

/*
//ex39)
class Tiger{
	// ex1)
	void m1() {
		System.out.println("m1 call");
	}
	// ex2)
	void m2(int num) {
			System.out.println("m2 call " + num);
		}
	// ex3) int a = 10, int b = 20, int c = 30
	// 주의 : int a, b, c 라고 쓰면 안된다. 
	void m3(int a, int b, int c) {
		System.out.println("m3 call " + (a + b + c));
	}	
	void m4(int a, float b, boolean c, char d) {
		System.out.println("m4 call");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}	
	void m5() {
		for (int i = 0; i < 10; i++) {
			System.out.println( 5 + " * " + i + " = " + 5 * i);
		}System.out.println();
	}
	void m6(int num) {
		for (int i = 0; i < 10; i++) {
			System.out.println( num + " * " + i + " = " + num * i);
		}System.out.println();
	}
	void m7() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = sum + 1;
		}
			System.out.println(sum);	
	}
	void m8(int num) {  
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum = sum + 1;
		}
			System.out.println(sum);
	}
	void m9() {
		for (int i = 0; i < 3; i++) { //세로
			for (int j = 0; j < 4; j++) { //가로
				if((i+j) % 2 == 0) 
				{
					System.out.print('o');
				}
				else 
				{
					System.out.print('x');
				}
			}
			System.out.println();
		}
	}
	
	void m10(int width, int height, char ch1, char ch2) {
		for (int i = 0; i < height; i++) { //세로
			for (int j = 0; j < width; j++) { //가로
				if( (i+j) % 2 == 0) {
					System.out.print(ch1 + " ");
				}
				else {
					System.out.print(ch2 + " ");
				}
			}
			System.out.println();
		}
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger tiger = new Tiger();
		tiger.m1();
		tiger.m2(100);
		tiger.m3(10, 20, 30);
		tiger.m4(100, 3.14f, false, '한');
		tiger.m5();
		tiger.m6(13);
		tiger.m7();
		tiger.m8(100);
		tiger.m9();
		tiger.m10(14, 10, 'O', '.');
	}
}
*/

/*
//ex38)
class Car{
	int fuel = 100;
	
	void move() {
		System.out.println("자동차가 달린다.");
		fuel = fuel - 13;
	}
	void stop() {
		System.out.println("자동차가 멈춘다.");
		fuel = fuel -2;
	}
	void inject(int num) {
		System.out.println("자동차의 연료를 주입합니다.");
		fuel = fuel + num;
	}
	void show() {
		System.out.println("현재 연료량은 : " + fuel);
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Car car = new Car();
		car.move();
		car.move();
		car.show();
		car.stop();
		car.show();
		car.inject(75);
		car.show();
	}
}
*/

/*
//ex37)
class Tiger{
	// 3.메쏘드 : 자주 사용되는 코드를 저장해놓고 필요할때 불러서 사용하는 목적이다.
	// 부른다를 전문 용어로 : call(콜)한다 라고 한다. 메쏘드를 콜한다.
	void merry() {
		System.out.println("멍");
	}
	// int num = 7;
	void happy(int num) {
		System.out.println(num);
		for (int i = 0; i < num; i++) {
			System.out.print("월 ");
		}System.out.println();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.merry();
		t.merry();
		for (int i = 0; i < 5; i++) {
			t.merry();
		}
		System.out.println("-----------------------");
		t.happy(7);
	}
}
*/

/*
//ex36)
// 클래스 안에 들어 있는 놈들은 모두 가족이다. (필드, 생성자, 메쏘드) 
// 클래스 멤버들 이라고 한다.
// int a; //필드, 멤버 필드, 멤버변수 라는 용어를 병행해서 사용함
class Airplane{
	// 1. 필드 ( 변수랑 완전히 똑같다. )
	int a;
	int b, c;
	int d = 10, e = 20;
	int f, g = 30;
	int fuel;
	int windowNumber;					//여기선(클래스) 컴퓨터가 메모리를 주지 않는다.
}

public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(100);
		// 호랑이 apple = new 호랑이;
		Airplane air1 = new Airplane(); //이때 메모리를 잔뜩 받게 된다.
		Airplane air2 = new Airplane();
		System.out.println( air1.hashCode() ); //고유 번호를 보는 법
		System.out.println( air2.hashCode() );
		
		air1.a = 100;
		air2.a = 200;			// 좌석번호가 같다고 같은 것이 아님을 알자 비행기가 다르다.
		System.out.println(air1.a + " " + air2.a); //클래스 안의 필드를 사용했다.
		System.out.println(air1.g + " " + air2.g); //같은 값으로 지정 되어있다.
		
		air1.fuel = 100;				// 1번 비행기 연료 100으로 
		air1.fuel = air1.fuel - 20;		// 허나 20 사용
		System.out.println(air1.fuel + " " + air2.fuel); //2비행기는 애초에 넣지 않음
	}
}
*/

/*
//ex35) 자바의 꽃 : 클래스(객체(Object) 지향(Oriended) 프로그램(program))
//OOP라고 함
// 절차적 프로그램 (구조적 프로그램)
// 객체 지향 프로그램
//설계도를 만들자 
//클래스(설계도) 이름은 첫자를 대문자로 하는 것이 관례(암묵적인 약속)이다.
class Airplane{
	// 1. field 필드(변수)가 들어갈 수 있다.
	// 2. 생성자가 들어갈 수 있다.
	// 3. method 메쏘드(함수)가 들어갈 수 있다.
}


public class Hello 
{
	public static void main(String[] args) 
	{
		
	}
}
*/

/*
//ex34) forEach
public class Hello 
{
	public static void main(String[] args) 
	{
		int[]ar = new int[] {10, 20, 50, 70};
		//ex1)
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		//ex2) forEach, 간략화된 for문
		// x, data, value 라는 변수 이름을 주로 사용함
		for (int x : ar) {
			System.out.print(x + " ");
		}System.out.println();
	}
}
*/

/*
//ex33) 앞 뒤를 더하는 프로그램
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 10;
		int[]ar = new int[num];
		Random rn = new Random();
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(6);
		}
		
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}System.out.println();
		
		//[0] + [9] = 90
		//[1] + [8] = 70
		//[2] + [7] 
		//[3] + [6]
		//[4] + [5]
		
		for (int i = 0; i < ar.length / 2; i++) {
			System.out.println(ar[i] + ar[ar.length-1-i]);
			//System.out.println( i + " " + (num-i));
		}
	}
}
*/

/*
//ex32)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 난수(랜덤)를 발생시키는 프로그램
		Random rn = new Random(); //첫자 R에 집중
		
		for (int i = 0; i < 10; i++) {
			System.out.println(rn.nextInt(10));
		}
	}
}

 */

/*
//ex31)
public class Hello 
{
	public static void main(String[] args) 
	{
		//배열을 선언하는 방법1
		int[]ar = new int[10];
		
		//배열을 선언하는 방법2
		int[]br = new int[] { 1, 2, 3, 4 };
		
		//배열을 선언하는 방법3
		int[]cr = { 1, 2, 3, 4, 5, 6 };
		
		System.out.println(ar.length);
		System.out.println(br.length);
		System.out.println(cr.length);
		
		// 2,3은 문법적으로 같기때문에 2번 쓸 바에 3번 쓰는게 나음
		// 1,3 비교할때 1을 꼭 써야 하는 경우가 있음 따라서 3번만 쓰지말고 1,2,3 다 알아둬라
		// 실전에서는 3번은 거의 안씀 몇개 안되기 때문에 
		// 실전에서는 보통 1번 씀 고로 다 익혀라
		
		//실전 예
		int num = 100; // 1번 응용 방법, 많이 씀
		int[]dr = new int[num];
		System.out.println(dr.length);
	}
}
*/

/*
//ex30) 배열 ( array )
public class Hello 
{
	public static void main(String[] args) 
	{
		// 호랑이 t1 = new 호랑이; 앞의 것과 맨 뒤의 글자가 같아야함 (호랑이)
		
		int[] arr = new int[10];
		
		arr[0] = 10;
		arr[3] = 20;
		arr[9] = 30;
		//정말 정말 주의합시다
		System.out.println("호랑이");
		// arr[10] 라는 변수는 없다. 0번부터 사용하기 때문 
		System.out.println(arr[0]);
		System.out.println(arr[3]);
		System.out.println(arr[9]);
		
		System.out.println(arr[0] + 100);
		arr[5] = arr[3] * 3;
		System.out.println(arr[5]);
		
		System.out.println(arr[4]); //지정안한 변수에는 0으로 다 초기화 되어잇음 
		
		int num = 7;
		arr[num] = 999;
		System.out.println(arr[7]);
		// [  ] 사이에 들어가는 숫자나 변수를 우리는 인덱스(aka 첨자)라고 한다
		
		arr[num*2-10] = 888; //인덱스로 연산식을 써넣어도 가능
		System.out.println(arr[4]);
		
		arr[2] = 3;			
		arr[arr[2]+4] = 666;	//이렇게 하진 않겠지만 이론상 가능하단 것을 보여주기 위해
		System.out.println(arr[7]);
		
		System.out.println("----------------"); //배열에 지정해둔 값을 확인하기 위해 for문 사용
		System.out.println("배열의 크기는 " + arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("-------------------------");
	}
}
*/

/*
//ex29)
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 20;
		switch (num) 
		{
		case 10:{
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum = sum + i;
			}
			System.out.println(sum);
		}break;			
		
		case 20:{
			for (int i = 0; i < 10; i++) {
				System.out.println(5 + " * " + i + " = " + i * 5);
			}
		}break;						   
		}
	}
}
*/

/*
//ex28)
public class Hello 
{
	public static void main(String[] args) 
	{
		//주의점 1. case 뒤에 오는 숫자는 중복될 수 없다.
		//	2. case 뒤에는 변수가 올 수 없다. num 등 변수로 넣을 수 없다는 뜻
		//	3. switch 안에는 변수가 올 수 있다.
		//	4. 혹시라도 break;를 생략하면 제어가 밑으로 내려간다. 의도적으로 그렇게 사용할 순 있다.		
		int num = 1;
		switch (num) {
		case 1:
			System.out.println("앵1");	//단문장이라 {}가 없음
			break;			
		case 2:{
			System.out.println("앵2");  //혹시 한문장 이상이면 {열고 
		}break;						   //break 앞에서 }를 치기도 한다.
		case 3:
			System.out.println("앵3");
			break;
		default:
			System.out.println("앵4");
			break;
		}
	}
}
*/

/*
//ex27) 
public class Hello 
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			if(i < 4) 
			{
				continue;
			}
			System.out.println(i + "호랑이");
			
			if( i == 8 )
			{
				System.out.println(i + "탈출직전");
				break;
			}
		}
	}
}
*/

/*
//ex26) break, continue 의 공통점 반복문에서 사용된다.
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 0;
		while(true)
		{
			num++;
			
			if(num<3)
			{
				System.out.println(num + "호랑이"); // 앞에 num + 를 써줌으로 
				continue;
			}
			System.out.println(num + "독수리");    // 식별하기가 더 좋다
			if( num > 5 )
			{
				System.out.println(num); // num이 어떤 상황에서 탈출하는지 알기위한다면
				break;
			}
		}
				System.out.println("exit");
	}
}
*/

/*
//ex25)
public class Hello 
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if( i == 4 ) 			
				break; //단문장임으로 스코프 생략
			
		}
		System.out.println(100);
	}
}
*/

/*
//ex24) while 우박수 출력 프로그램
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 9;
		while(true) 
		{
			System.out.println(num);
			if( num % 2 == 0) 
			{
				num = num / 2;
			}
			else 
			{
				num = num * 3 + 1;
			}
			if(num == 1)
			{
				System.out.println(num);
				break;
			}
		}
	}
}
*/

/*
//ex23) 한 문장일 때는 {}를 생략할 수 있다.  
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 3 , b = 2;
		if(a > b)
		{
			System.out.println("호랑이");
		}
		
		if(a > b)
			System.out.println("호랑이");
		for (int i = 0; i < 3; i++) 
			System.out.println(i);
		System.out.println("------------------");
		for (int i = 0; i < 3; i++); //;를 여기서 붙인다면? 
		{
			System.out.println("호랑이");
		}; //for의 }뒤에 ;는 생략된 것임
	}
}
*/

/*
//ex22)
public class Hello 
{
	public static void main(String[] args) 
	{
		// while(){}
		// 반복을 위한 제어문이다.
		// for는 반복횟수를 알 때 사용한다.
		// while는 반복횟수를 모를 때 사용한다.
		
		// ex1) 이 예는 실제로 사용하지 않는다.
		// 폭주가 일어나기 때문에 주석을 잡음 (무한 루프에 빠짐)
		// int num = 0;
		// while(true) // while(조건)
		// {
		// 	num++;
		//	System.out.println(num + "호랑이 ");
		// }
		
		// ex2)
		// int num = 0;
		// while( num < 4 )
		// {
		// 	System.out.println(num + "호랑이 ");
		// }
		
		//ex3) 반복 횟수를 알고 있에도 for문이 아닌, while을 사용하고 있다.
		// 따라서, 잘못된 프로그램이다
		int num = 0;  
		while(num < 4)
		{
			System.out.println(num + "호랑이 ");
			num++;
		}
		
		System.out.println("while문 빠져 나옴");
		System.out.println("----------------------");
		//ex4)
		int num2 = 0;
		while(true)
		{
			System.out.println(num2);
			if( num2 == 4 ) 
			{
				System.out.println("탈출하기 일보직전");
				break; // break를 만나는 순간에 while 반복문을 탈출한다.
			}
			num2++;
		}
		System.out.println("탈출됨");
				
	}
}
*/

/*
//ex21) 
public class Hello 
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				System.out.print("["+ i + " " + j + "]");
			}
			System.out.println(); //4번하고 줄바꿈하도록 작성
		}
		
		// 제어문 안에서 제어문의 다른 예 
		for (int i = 0; i < 10; i++) 
		{
			if(i % 2 == 0)
			{
				System.out.println(i + ":" + "짝수" );
			}			
			else 
			{
				System.out.println(i + ":" + "홀수");
			}
			
		}
	}
}
*/

/*
//ex20) 4자리 정수값을 모두 합하는 프로그램
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 1234;
		int sum = 0;
		for (int i = 0; i < 4; i++) 
		{
			int q = num / 10; // 123	12
			int r = num % 10; // 4		 3
			num = q;		  // 123	12
			System.out.println(i + " " + q + " " + r ); //코드가 무얼 의미하는지 확인
			sum = sum + r;    // 1+2+3+4를 더한 값
		}
		System.out.println(sum);
	}
}
*/

/*
//ex19) a의 b승을 구하는 프로그램
public class Hello 
{
	public static void main(String[] args) 
	{
		int sum = 1;
		int a = 2, b= 8; 
		for (int i = 0; i < b; i++) {
			sum = sum * a;
		}
		// a을 b번 곱했다. (a의 b승)
		System.out.println(sum);
	}
}
*/

/*
//ex18)
public class Hello 
{
	public static void main(String[] args) 
	{
		//ex1)
		for (int i = 0; i < 10; i++) {
			System.out.println( 5 + " * " + i + " = " + i * 5 );
		}
		System.out.println("---------------------");
		
		//ex2)
		int num = 19; // 변수를 이렇게 이용해주면, 여기 하나만 바꾸면 되니까, 훨씬 좋다. 
		for (int i = 0; i < 10; i++) {
			System.out.println( num + " * " + i + " = " + i * num );
		}
		System.out.println("-------------------");
		
		//ex3) 합산프로그램(혹은 누적프로그램)
		int sum = 0;
		for (int i = 1; i <= 100; i++) 
		{
			//System.out.print(i + " " );
			sum = sum + i;
			//System.out.println(i + " " + sum);
		}System.out.println();
		System.out.println(sum);
	}
}
*/

/*
//ex17)
public class Hello 
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 5; i++) 
		{
			System.out.println(i + "호랑이");
		}
		
		{
			int num = 10;
			System.out.println(num);
		} // }가 끝나는 데서 위의 num은 메모리가 사라짐 (지역변수에 해당)
		
		//System.out.println(num);
		{
			int num = 20; //위에서 사라졌기때문에 이름이 같아도 됨
		}
		
		for (int i = 0; i < 3; i++) 
		{
			System.out.println(i + "독수리");
		}
		
		System.out.println("-----------------------");
		System.out.print("앵무새1"); //ln을 빼면 줄바꿈 하지마라 는 뜻
		System.out.print("앵무새2");
		System.out.println("앵무새3"); // 마지막은 줄바꿈을 했다 는 뜻
		
		for (int i = 0; i < 6; i++) {
			System.out.print( i + " " ); // i후 띄어쓰기
		}
		System.out.println(); //줄바꿈만 일어난다.
		System.out.println("독수리");
	}
}
*/

/*
//ex16)
// 자바를 잘하느냐? 아래의 3가지로 귀결 될 것임
// 1. for을 잘 사용할 수 있는가? 프로그램의 70% 이상이 for문이 사용됨 
// 2. 클래스를 잘 사용할 수 있는가?
// 3. 다형성을 잘 사용할 수 있는가?
public class Hello 
{
	public static void main(String[] args) 
	{
		// 제어문( if, for, switch, while)
		System.out.println("호랑이");
		
		for (int i = 0; i < 10; i++) //이 for문은 몇번 돌까요?  'i< n' 값의 n번 돕니다. 
		{
		System.out.println(i);	
		}
		
		System.out.println("코끼리");
	}
}
*/

/*
//ex15)
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 10;
		System.out.println(num); // 10
		num = num + 5;
		System.out.println(num); // 15
		num = num + 1;	
		System.out.println(num); // 16
		num = num - 1;
		System.out.println(num); // 15
		
		//반드시 1개만 증가(감소)시킨다는 전제 아래에서
		// 단항 연산자를 사용할 수 있다.
		num++; // num = num + 1; 완전히 동일한 코드이다.
		++num; // num = num + 1; 완전히 동일한 코드이다. 바로 위의 코드와 차이는 뒤에서 설명
		System.out.println(num); // 17
		num--;
		--num;
		System.out.println(num); // 15 
	}
}
*/

/*
//ex14)
public class Hello 
{
	public static void main(String[] args) 
	{
		
		//띠를 판별해주는 프로그램
		int year = 1969;
		System.out.println(year % 12); //나머지가 1이 나오면 다 닭띠
		
		if( year % 12 == 0)
		{
			
		}
		else if( year % 12 == 1 )
		{
			System.out.println("당신은 닭띠 입니다.");
		}
		else if ( year % 12 == 2 ) 
		
		System.out.println("무궁화");
		// 1. if() {}
		// 2. if() {} else {}
		// n개 중에 반드시 1개만 선택하고 싶을때 사용하는 조건문 else if()
		// 3. if() {} else if() {} else {}
		//ex1)
		if(false)
		{			
			System.out.println(1);
		}
		else if(4 < 3) 
		{
			System.out.println(2);
		}
		else if(10 != 10 ) 
		{
			System.out.println(3);
		}
		else
		{
			System.out.println(4);
		}
		
		//ex2)
		int jumsu = 79;
		if(jumsu >= 90 )
		{
			System.out.println("당신의 학점은 A 입니다.");
		}
		else if( jumsu >= 80 )
		{
			System.out.println("당신의 학점은 B 입니다.");
		}
		else if( jumsu >= 70 )
		{
			System.out.println("당신의 학점은 C 입니다.");
		}
		else if( jumsu >= 60 )
		{
			System.out.println("당신의 학점은 D 입니다.");
		}
		else 
		{
			System.out.println("당신의 학점은 F 입니다.");
		}		
	}
}
*/

/*
//ex13)
public class Hello 
{
	public static void main(String[] args) 
	{
		//ex1)
		System.out.println(1);
		if(false) 
		{
			System.out.println(2);	// (조건에 만족하면) 1번 블록 
		}
		else //둘중에 하나를 반드시 사용해야 할때 if - else 를 쓴다
		{
			System.out.println(3);	// (그렇지 않으면) 2번 블록
		}
			System.out.println(4);
			
			System.out.println("---------------");
		
		
		//ex2)
			System.out.println(5);
			if(true) 
			{
				System.out.println(6);	
			}
			else 
			{
				System.out.println(7);	
			}
				System.out.println(8);
				System.out.println("---------------");
				
		//ex3) 짝수인지 홀수인지 판단하는 프로그램.
				int num = 23;
				if( num % 2 == 0 ) 
				{
					System.out.println( num + "는 짝수입니다.");
				}
				else 
				{
					System.out.println(num + "는 홀수입니다.");
				}
				
		//ex4)
				//		   1000000
				int num2 = 2109211;
				if( num2 / 1000000 == 1)
				{
					System.out.println("남자 민증");
				}
				else 
				{
					System.out.println("여자 민증");
				}
	}
}
*/

/*
//ex12)
public class Hello 
{
	public static void main(String[] args) 
	{
		int num = 10;
		System.out.println(num);
		num = 20;
		System.out.println(num);
		num = 10 + 20;
		System.out.println(num);
		num = num + 100;
		System.out.println(num);
	}
}
*/

/*
//ex11)
public class Hello 
{
	public static void main(String[] args) 
	{
		//
		// 4대 제어문 ( if, for, while, switch ) do(는 버려도됨)
		// () {} 를 반드시 무조건 동반한다.
		//if(조건) : 컴퓨터가 참과 거짓을 판단할 수 있는 요소가 들어간다
		// ex1		
		if( false )
		{
			System.out.println("호랑이");
		}
		System.out.println("코끼리");		
		
		// ex2
		if( 30 > 20 )
		{
			System.out.println("독수리");
		}
		System.out.println("앵무새");
		
		// ex3)
		// 산술연산과 비교연산이 같이 일어나고 있다.
		// 같이 일어나는 경우 우선순위는 1순위 산술연산 2순위 비교연산
		int a = 12, b = 5;
		// if ( 0 == a % b )
		if( a % b == 0 )
		{
			System.out.println("5의 배수이다");
		}

		// ex4)
		if( 3 > 2)
		{
			System.out.println("호랑이1");
			System.out.println("호랑이2");
			System.out.println("호랑이3");
			System.out.println("호랑이4");
			System.out.println("호랑이5");
		}
		
		// ex5)
		int c = 3;
		// 6 < 9 
		if( c * 2 < c * 3) 
		{
			System.out.println("공룡");
		}
		System.out.println("---------------");
		// ex6) 제어문 안에서 제어문을 사용할 수 있다.
		System.out.println(1);
		if(false) 
		{
			System.out.println(2);
			if(true) 
			{
				System.out.println(3);
			}
			System.out.println(4);
		}
		System.out.println(5);
		// 밖의 if	 안의 if
		// false	 false : 1 5
		// false	 true : 1 5 
		// true  	false : 1 2 4 5 
		// true		 true : 1 2 3 4 5
		
		// ex7)
		// if()
		// {
		//  if()
		//  {
		  
		//  }
		 
		//  if()
		//  {
		// 		if()
		// 		{
		  
		//  	}
		//  }
		// }
  		 
  		 
	}
}
*/

/*
//ex10)
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println( 30 > 20 );
		System.out.println( 30 < 20 );
		// 주의사항 : >= (옳바른 문장), => (잘못된 문장) 크거나 같냐, 작거냐 같냐 라고 해야
		System.out.println( 20 >= 20 );
		System.out.println( 20 <= 19 );
		// 주의사항 : ==이 2번이다. 1번이 아님
		System.out.println( 20 == 20 );
		// !를 부정연산자라고 한다. !는 같지 않습니까 라는 뜻
		System.out.println( 20 != 10 );
		
		System.out.println("---------------------");		
		int a = 10, b = 9;
		System.out.println( a > b );
		System.out.println( a < b );
		System.out.println( a >= b );
		System.out.println( a <= b );
		System.out.println( a == b );
		System.out.println( a != b );
		// 크냐 작냐 같냐 같지않냐를 묻는 것은 관계연산자 라고도 하고 비교연산자 라고도 함 
	}
}
*/

/*
//ex9)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 초기화 되지 않은 변수는 사용할 수 없다.
		//int a;
		//System.out.println(a);
		int a = 20, b = 4;
		System.out.println( a + b );
		System.out.println( a - b );
		System.out.println( a * b );
		System.out.println( a / b );
		System.out.println( a % b );
		System.out.println("--------------------");
		
		// 두 변수의 값을 교환하는 swap 프로그램.
		int a1 = 88, a2 = 99; // 기존에 10 20으로 하다 바꾼것임 혼동ㄴㄴ
		int temp; // t라고 약자를 쓰기도 한다.
		
		System.out.println(a1 + " " + a2);
		temp = a1; // temp:10
		a1 = a2;   // a1 : 20
		a2 = temp; // a2 : 10
		System.out.println(a1 + " " + a2);
	}
}
*/

/*
//ex8)
public class Hello 
{
	public static void main(String[] args) 
	{
		// ex1)
		int a;
		a = 10;
		System.out.println(a);
		
		// ex2)
		int b = 20; // 컴퓨터야 4byte를 주고 그것을 b라 하세요, 그리고 거기에 20을 넣어 합성명령
		System.out.println(b);
		
		// ex3)
		int c, d, e; // 1개 이상 사용할 수 있다.
		c = 1;
		d = 2;
		e = 3;
		System.out.println( c + " " + d + " " + e);
		
		// ex4)
		int f, g=100, h = 200;
		f = 400;
		System.out.println( f + " " + g + " " + h);
		
		System.out.println("-----------------");
		
		// ex5)
		int apple = 100;
		System.out.println(apple);
		// 대입 연산을 시킨다. 과거는 잊어버리고, 이 순간값을 기억합니다. 다음 기억이 들어오기 전까지는
		apple = 200;
		System.out.println(apple);
		apple = 500;
		System.out.println(apple);
	}
}
*/

/*
//ex7)
public class Hello 
{
	public static void main(String[] args) 
	{
		byte apple;
		// -128 ~ +127 범위
		apple = 100;
		System.out.println(apple);
		System.out.println(Byte.MAX_VALUE); //대문자로 시작하는 Byte
		System.out.println(Byte.MIN_VALUE);	
		
		// 2 byte요청 = 16bit 요청
		short banana;
		banana = 5000;
		System.out.println(Short.MAX_VALUE); //대문자로 시작하는 Short
		System.out.println(Short.MIN_VALUE);
		
		// 4 byte요청 = 32bit 요청
		int kiwi; // int 는 integer가 생략된 것
		System.out.println(Integer.MAX_VALUE); //int는 줄임말이니 Integer를 다 써야함 
		System.out.println(Integer.MIN_VALUE); //역시 시작은 대문자로
		
		// 8 byte요청 = 64bit 요청
		long orange;
		System.out.println(Long.MAX_VALUE); //대문자로 Long
		System.out.println(Long.MIN_VALUE);
		
		// 4byte주세요. ( 정수, 소숫점 ) 
		float tiger;
		tiger = 1234.5678f; //소수로 마지막엔 반드시 소문자 f를 넣어줘야한다.
		System.out.println(tiger); //소수점 사용시 오류가 빈번히 발생 오차가 생길 수 있음
		
		// 8byte 주세요. (정수, 소숫점 )
		double lion;
		lion = 1234.5678; //뒤에 f를 안붙임 이걸로 구분하도록
		System.out.println(lion); // 플롯보다 소수점 오차 발생이 적음 허나 길어지면 오차나긴남
		
		// 1byte ( true / false 참과 거짓만 기억하기 위함)
		boolean cat;
		cat = true; // 혹은 false;
		System.out.println(cat);
		
		// 2byte (문자만 전문적으로 보관하는 놈이다.)
		char dog;
		dog = '한';
		System.out.println(dog);		
		
		// 8가지를 표준 타입이다. 예시 int 타입이란 변수를 사용하는데 오렌지로 
	}
}
*/

/*
//ex6)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 컴터야 박스 1개 줘봐라...
		byte apple;
		
		// 컴터야 방금 apple이라는 변수(메모리)에 30을 넣어봐라.
		// = 은 대입연산이라고 하는데 항상 오른쪽에서 왼쪽으로 들어간다.
		// <---
		apple = 30; //애플에 30을 넣음
		System.out.println(apple); //그럼 애플을 출력해봐라
		
		byte banana;
		banana = 40;
		System.out.println(banana); // banana도 ctrl + space 이용하면 쉬움
		
		System.out.println(apple + banana);
		System.out.println(apple + " " + banana);
		
		// 변수이름 작명법
		// 1. 동일한 이름으로 중복정의 할 수 없다.
		// byte banana;
		// 단 이름이 동일해도 대소문자는 서로 다르게 해석한다. (구분한다)
		// 허나 가급적이면 사용하지 않는것이 좋다. (프로그래머가 헷갈리니까)
		byte Banana;
		
		// 2. 첫글자가 숫자가 아니면 숫자를 사용할 수 있다.
		byte apple1234;
		// byte 7apple; // 첫글자가 숫자라 안된다.
		
		// 3. _(언더바)와 $을 제외하면 특수문자를 사용할 수 없다.
		byte _apple;
		byte apple$;
		// byte #apple; 두개 특수문자를 제외하면 사용할 수 없다.
		
		// 4. 한글은 사용할 수 있지만 가급적 피한다.
		byte 사과;
		사과 = 60;
		System.out.println(사과);
		
		// 5.한 단어 이상일때는 낙타를 생각한다. // 낙타 봉우리가 올라와있다 두번째단어시작대문자로
		// 카멜 표기법이라고 한다
		byte appleNumberPrice; 
	}
}
*/

/*
//ex5)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 1. 숫자 2. 문자(1글자) 3. 문자열(문자들의 집합)
		System.out.println( 100 );    // 숫자
		System.out.println( '한' );    // 문자
		System.out.println( "무궁화" ); // 문자열
		System.out.println( "100" );  // "문자열"취급
		System.out.println( '7' );    //  '문자'취급
		System.out.println( "-------------" );
		System.err.println( 100 ); // 정상출력은 되나 에러취급이 되어서 빨간글로 출력
		System.out.println( "-------------" );
		// + 를 사용할 것인데,

		// 1. 숫자 + 숫자 = 숫자
		System.out.println( 10 + 20 ); // 숫자연산 숫자 + 숫자
		
		// 2. 숫자 + 문자열 = 문자열
		//문자열 연결이 일어난다.
		System.out.println( 10 + "호랑이" ); // 숫자 + 문자열
		//System.out.println( "10" + "호랑이" ); // (바로 위의) 프로그램과 동격
		
		// 3.문자열 + 숫자 = 문자열
		System.out.println( "호랑이" + 10 );
		
		//
		// 4.문자열 + 문자열 = 문자열
		System.out.println( "호랑이" + "코끼리" );
		
		// 결과 : 7호랑이
		System.out.println( 3 + 4 + "호랑이" );
		
		System.out.println( 3 + "호랑이" + 4 );
		
		System.out.println( "호랑이" + 3 + 4 );
		// 10 20 : 밑의 프로그램을 자주 사용한다.
		System.out.println( 10 + " " + 20 );
	}
}
*/

/*
//ex4)
public class Hello 
{
	public static void main(String[] args) 
	{
		// syso >> Ctrl + Space
		System.out.println("호랑이");
		// " " 사이에 있는 문자들의 집합을 문자열(string)
		System.out.println( "13 + 7" );
		System.out.println("---------------"); //세퍼
		
		//산술연산자.
		System.out.println( 13 + 7 );
		System.out.println( 13 - 7 );
		System.out.println( 13 * 7 );
		System.out.println( 13 / 7 ); // 몫
		System.out.println( 13 % 7 ); // 나머지
		System.out.println("---------------"); 		
		System.out.println( 13 + 7 - 5 ); 
		System.out.println( 13 + 7 * 5 );     // 1 
		System.out.println( (13 + 7) * 5 );   // 2
		System.out.println( 13 + (7 * 5) );   // 3
		
		
	}
}
*/

/*
// ex3)
public class Hello 
{
	public static void main(String[] args) 
	{
		// 주석
		// 프로그램을 설명하는 용도로 많이 사용된다.
		System.out.println("무궁화");
		//System.out.println("호랑이");
		System.out.println("소나무");
	}
}
*/