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

//ex ��-1) ������
public class Hello 
{
	public static void main(String[] args) 
	{
		
		Runnable flagTask = new FlagTask();
		Thread thread = new Thread(flagTask);
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("û��");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	
		
	}
}


/*
//ex103-1) ����
// �����Լ�, ���ٽ�, (�Լ��� ���α׷���)
// �Լ� �Ѱ��� ���� ����� �� �ִ�.

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
		
		Test1 t2 = ()-> {			//���� t1�ڵ�� ����. �̸� �����Լ� ��� �Ѵ�.
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
		t7.f1(100, "ȣ����");
	
		Test4 t8 = (n,s)->{
			System.out.println(8);
			return 0;
		};
		t8.f1(100, "ȣ����");
		
		// ----------------------------------
		
		Test3 t9 = ()->{
			return 1000;
		};
		System.out.println(t9.f1());
		
		Test3 t10 = ()-> 2000; // 9���� 10���� ���� �ڵ� �ܹ����̶� {}�� ������ ���, return�� ���� ��������� �Ѵ�
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
//ex102) ���� ���� ���α׷� << �÷��� (LinkedList)
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
		mm.add(new Book("�ڹٸ������", "ȫ�浿", "���������ǻ�", 1000));
		mm.add(new Book("�����ڴ¹�", "������", "�������ǻ�", 1500));
		mm.add(new Book("�����Ͷ������ΰ�", "�̼���", "�������ǻ�", 5000));
		mm.add(new Book("�����������", "��������", "�������ǻ�", 2500));
		System.out.println(mm.size()); //���ָӴ� å�� ��� �־��~?
		
		// Read From CRUD	
		for (Book book : mm) {
			book.showInfo();
		}
		
		System.out.println();
		
		// Update From CRUD	
		mm.set(1, new Book("�����Ͼ�¹�","������","�������ǻ�",1590));
		
		for (Book book : mm) {
			book.showInfo();
		}
		
		System.out.println();
		
		// Delete From CRUD	
		mm.remove(3);
		
		for (Book book : mm) {
			book.showInfo();
		}
		
		//�˻� ���α׷�! 
		Book findBook = search(mm, "�̼���");
		
		if(findBook != null) {
			System.out.println("�˻�����");
			findBook.showInfo();
		}else {
			System.out.println("�˻�����");
		}
		
	}
	static Book search(LinkedList<Book> rm, String author) {
		for (Book book : rm) {
			if(book.author.equals(author)) {
				return book; //ã������ �׸� ���� ������ �ɾ���
			}
		}
		return null;
	}
}
*/

/*
//ex101-2) ���׸� ���� : Ŭ������ �ݺ��ؼ� ������ �ʰ� �ѹ� ���� � �����͵� �޾Ƽ� ó���ϰڴ�.
class Tiger<T>{		//��ǥ������ <T> �� <E>�� ����.
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
		t2.setData("ȣ����");
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
		
		//�̹� �츮�� ���׸� ������ �˱����� �̷��� ���� �־���..!
		LinkedList<Integer> mm = new LinkedList<Integer>();
	}
}
*/

/*
//ex101-1)
//������ : ���Ǵ� ����Ÿ�� Ÿ���� �ٲ𶧸��� ���ο� Ŭ������ ������ �Ѵ�.
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
		b.setData("ȣ����");
		System.out.println(b.getData());
		
		C c = new C();
		c.setData(3.14f);
		System.out.println(c.getData());
	}
}
*/

/*
//ex100-3) ���ڷ��̼� ���� : ���ΰ� ���ΰ� ���Ѵٰ�.. Ű����ũ �����غ��� ��~
class Ŀ��{
	int ���� = 30;
	
	int ���() {
		System.out.println("Ŀ�� �ֹ�");
		return ����;
	}
}

class ���� extends Ŀ��{
	int ���� = 20;
	
	Ŀ�� a;
	����(Ŀ�� a){
		this.a = a;
		
	}
	int ���() {
		System.out.println("���� �ֹ�");
		return ���� + a.���();
	}
}
class ���� extends Ŀ��{
	int ���� = 10;
	
	Ŀ�� a;
	����(Ŀ�� a){
		this.a = a;
		
	}
	int ���() {
		System.out.println("���� �ֹ�");
		return ���� + a.���();
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
//		Ŀ�� a = new Ŀ��();
//		System.out.println(a.���());

		Ŀ�� �մ� = new Ŀ��();
		//System.out.println(�մ�.���());
		�մ� = new ����(�մ�);
		System.out.println(�մ�.���());
		System.out.println("---------------");
		�մ� = new ����(�մ�);
		System.out.println(�մ�.���());
		System.out.println("---------------");
		�մ� = new ����(�մ�);
		�մ� = new ����(�մ�);
		�մ� = new ����(�մ�);
		�մ� = new ����(�մ�);
		System.out.println(�մ�.���());
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
		// ���ο� ��ü�� ���� = new B(����ϰ� ���� (=BŬ���� �ȿ��� ���� ��������))
		a = new B(a); 
		System.out.println(a.run());
		System.out.println("---------------");
		//a�� ���ΰ� �ִ� b�� �ٽ� C�� 
		a = new C(a);
		System.out.println(a.run());
	}
}
/*


/*
//ex100-1) 100-2�� ���๮��
class AA{}
class BB extends AA{}
class CC extends AA{}

public class Hello 
{
	public static void main(String[] args) 
	{
		// ��ĳ���� ����
		AA a1 = new BB();
		AA a2 = new CC();
		
	
		AA a3 = null;
		a3 = new BB();
		System.out.println(a3.hashCode());
		
		// AA temp = a3; �� �ڵ尡 �־��ٸ� �Ȼ���� temp�� ����� ������� ������
		
		//�ؿ� �ڵ尡 ����Ǵ� �� ������ ���� ��ü�� �Ҿ������. (=�����)
		a3 = new CC(); 
		System.out.println(a3.hashCode());
		
		a3 = new BB();
		System.out.println(a3.hashCode());
	}
}
*/

/*
//ex99) ���ڸ� ���ڷ�, ���ڸ� ���ڷ�
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 100; // ����
		String b = "200"; // ���ڿ�
		System.out.println( a + 100);
		System.out.println( b + 100);
		
		// 1. ���� >> ���ڿ�
		int n1 = 123;
		String s1 = Integer.toString(n1);
		System.out.println(s1 + 456);	//����
		
		// 2. ���� >> ���ڿ�
		int n2 = 123;
		// ���� �ڵ� (�޴��ϴ�) : ������ �ƴ����� ���� ����
		String s2 = "" + n2;
		
		// 3. ���ڿ� >> ����
		String s3 = "999";
		int n3 = Integer.parseInt(s3);
		System.out.println(n3 + 1);
						
	}
}
*/

/*
//ex98) ���׿��� ����
public class Hello 
{


	public static void main(String[] args) 
	{
		// 1��
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
		
		// 2�� ��°� ���õ� ��
		if( a > b ) {
			System.out.println("ȣ����");
		}else {
			System.out.println("�ڳ���");
		}
		
		System.out.println( a > b ? "ȣ����" : "�ڳ���" );
		
		// 3�� ����ƽ, Ŭ����
		
		static int m1( int a, int b ) { ##����
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
//ex97) ¥���� ���� ���Ѱ� �ϱ�!
@FunctionalInterface	//�̱����� �Լ��� �ݵ�� �ϳ����� �Ѵ�. ��� �˷��ִ� ��
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
//ex96) ���� ����
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10;
		short b;
		b = (short)a; // ������ �޴� ������ Ÿ���� �����.
		
		try {
			Reader r = new FileReader ( "hello.txt");			
						
			//int read()
			while(true) {
				int readData = r.read();
				if( readData == -1 ) {	//������ �� ������ -1�� ��µǹǷ� �ݺ��� ���� ���� -1���� �극��ũ�� �ɱ�����)
					System.out.println("������ ������ ����");
					break;
				}
				char ch = (char)readData; // �� ���� ���� �� �Ʒ� ��¿� (char)readerData �̷��� �־ ��
				System.out.println(ch);				
			}			
			
			r.close();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("�бⰡ ����");
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
			
			for (int i = 0; i < 6; i++) {	// ���η� ���� ��
				for (int j = 0; j < 8; j++) {	// ���η� ���� ��
//					if((i+j)%2 == 0) {
//						w.write("O ");
//					}else {
//						w.write("X ");
//					}
					//���׿������� �غ���
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
		// if else�� ����ϰ� �ִ°� Ȯ��
		// (if �� else ��) � ���� ���� ������ ���� ���Թ޴°� Ȯ��
		// �̷� ��쿡�� ���׿����� ����ϴ� ���� �����̴�. 
		if(a > 0) {
			b = a + 2;
		}else {
			b = a - 2;
		}
		// �Ʒ��� ���׿���, ���� ���� ������
		b = (a > 0) ? a + 2 : a - 2;
		
		if(a > 0) {
			System.out.println("ȣ����");
		}else {
			System.out.println("������");
		}
		
		// �Ʒ��� ���׿������� �ٲ� ��, ���� ���� �����̴�
		System.out.println( (a > 0) ? "ȣ����" : "������");
			
			
	}
}
*/

/*
//ex94) �ð��� ¥���� ���� File I/O (Input/Output)
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		
		try {
			// ���� ����¿��� ���� �߿��� �κ� ���ǻ���!
			// 1. import
			// 2. unhandle exception
			// 3. ������ �Ѳ��� �ݾ�����Ѵ�. ��!! ���� �ݾ� ���� ���̿��� ������ ��!
			Writer w = new FileWriter( "test.txt" );	//����
			w.write("ȫ�浿");
			w.write("\n\n");
			w.write("����ȭ");
			w.close();									//Ŭ����
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		System.out.println(2);
	}
}
*/

/*
//ex93) singleton pattern Ŭ������ �̿��� ����� �� �� �ִ� ��ü�� 1���� �����ϱ�
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
	// Ŭ������ �̿��ؼ� ����� �� �� �ִ� 
	// ��ü�� 1���� ������ �� ����Ѵ�. ex)t1
		
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
//ex92) private �Լ��� ���� ���� : �б��������θ� ���� �� �ִ�. (setter�� getter �ɼ��� �ذͻ� �ȸ�����൵ �׸�)
class Tiger{
	private int money;	// read, write 
//	// setter �Լ�
//	void setMoney(int money) {	//�Լ��� �̷��� �����ϸ� ���� ���� �����̺����� ���ϰ�)
//		this.money = money;
//	}
//	// getter �Լ�
//	int getMoney() {
//		return this.money;
//	}
	
	private int num;
	//��Ŭ������ �ҽ� -> ���׷���Ʈ ����, ���� ���� �Ʒ��� ���� ������ֱ⵵..
	
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
//ex91) �ٽ� Ŭ���� �̾߱� private
class Tiger{
	
	// private���� �����ִ� ������ : ����Ÿ ���� ���� ��� �Ѵ�.
	// ���� ���α׷��� Ŭ���� ������ �ʵ�(����)��
	// ���� ��κ� (99%) ������ ���� ���ѹ�����.
	
	private int a; //private �̱����� ��������.. "Ŭ���� ���ο����� �� �� �ִ�."
	public int b;  // private�� ����ؼ� �ۿ����� �� �� �ִ�.
	
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
	//	t.a = 10; �����̺��� Ŭ���� �ܺο��� ��� �� �� ����.
		t.b = 20;
	//	t.m2();	  �����̺��� Ŭ���� �ܺο��� ��� �� �� ����.
		t.m3();
	}
}
*/

/*
//ex90-2) ¦�� ����
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
		//�����ϱ� ���� ���� �־��
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			mm.add(rn.nextInt(100));
		}
		System.out.println(mm);
		
		//i�� �����Ǹ鼭 skip�� �Ǿ������ skip�� ���� �������� ++�� ���ݴ�.
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
		
		//���� ¦���� ��� �����ϰڴ�!
		for (int i = 0; i < mm.size(); i++) {
			Integer num = mm.get(i);
			if(num%2==0) {
				mm.remove(i);
				
			}
			System.out.println(i + ":" + mm); //�� �� ���Ű� �ȵƳ�? �Ͼ�� ��Ȳ�� Ȯ���ϱ� ���� �ڵ�
		}
		//System.out.println(mm);
		//Ȯ���ߴ��� ¦���� �� ���Ű� �ȵƴ�...!
		//�ε��� ��ȣ���� �з�������....
		// �׷� �ذ��ϴ¹��� 90-2������!
	}
}
*/

/*
//ex89) �˻��ؼ� �����͸� ����
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
				// break�� ������� ���� ���
				// 1. �������� �ð������ �þ� ����.
				// 2. �ݺ�Ƚ������ ������ �߻��Ѵ�. (44�� ������ ����..)
				// 3. ���� 44�� ������ �� �ִٸ�..? 44�� ������ ã�� �� �����Ϸ��� �õ� �� ���̴�..
				//    �㳪 �� ���Ű� ���� �ʴµ�.... ù 44�� �����ϰ� ���� �� �ڸ��� �ٽ� ��ã�� �������� ����..
				// ex90)���� �̾� ����
				break;				
			}
		}
		System.out.println(mm);
		System.out.println("exit");
	}
}
*/

/*
// ex88) �˻��� ���õ� ���α׷�
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
				System.out.println(i + "��°���� ã�Ҵ�.");
				break;
			}
			
			if(i == mm.size()-1) {
				System.out.println("������ i�� ���� : " + i);
				System.out.println("ã�� �����Ͱ� ����");
			}
		}
		System.out.println("Exit");
	}
}
*/

/*
//ex87) �ݷ��� �߿��� LinkedList�� ����ߴ�. C R U D
public class Hello 
{
	public static void main(String[] args) 
	{
		// ǥ��Ÿ���� ����� �� ����.
		// Ŭ������ �����̳� �ȿ� �� �� �ִ�.
		LinkedList<Integer> mm = new LinkedList<Integer>();
		System.out.println(mm.size()); //���ָӴ� ����Ʈ � �ֽ��ϱ�?
		
		//C(reate)
		mm.add(100);	//���ָӴ� 100 �̶�� ���� �����̳� �ȿ� �־��ּ���
		System.out.println(mm.size()); //���� �����̳� �ȿ� � �ֽ��ϱ�? : 1�� �ִ�
		
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm.size() + "�� �ִ�.");
		
		// R(ead)
		// ��� 1) ���ָӴ� �̸��� �ٷ� �ִ� �� (�ܼ��ϰ� ����ϱ� ������, Ȱ���� �� ����..)
		System.out.println(mm); 
		
		// ��� 2) Ȱ�뵵�� ���� ����. 
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) + " ");	// get
		}System.out.println();
		 
		// ��� 3) 
		// ���� ���� ���� �̸��� data, item, value, x (�Ϲ������� ���� �̸����� i�� ���Ѵ�.)
		for (Integer data : mm) {
			System.out.print(data + " ");
		}System.out.println();
		
		// get Ȱ��
		int num = mm.get(2);
		System.out.println(num);
		
		// �迭 ��� ���
		int[] ar = {1, 2, 3};
		for (int data : ar) {
			System.out.print(data + " ");
		}System.out.println();
		
		// U(pdate)
		mm.set(5, 99);	// 0���� ����. 5��° �����͸� 99�� �ٲ��ּ���
		System.out.println(mm);	// ���⸸ �ϸ� �Ǵϱ� �츮�� �̷��� ���
		
		// D(elete)
		// delete, remove, erase
		mm.remove(5);	// 0���� ����. 5��° �����͸� �����ּ���
		System.out.println(mm);
		
	}
}
*/

/*
//ex86) ��Ʈ ����
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
		
		// ex-or : ������ �Ѱ��� 1�϶� 1�� ���´�.
		// 0 0 >> 0   				// �ϸ� ����
		// 0 1 >> 1  				// 
		// 1 0 >> 1					//
		// 1 1 >> 0					//
		System.out.println(HexaToBinary(a));
		System.out.println(HexaToBinary(b));
		System.out.println(HexaToBinary(a ^ b)); // ex-or
		System.out.println();
		
		// shift : >> << �������̵� �����̵� �̴°�
		System.out.println(HexaToBinary(a));
		a = a << 4;	// ���ڸ��� �������� �о�� 
		System.out.println(HexaToBinary(a)); //�������� �����ִ� �������� ���� ������ �ִ� 0���� ����
		System.out.println();
		
		System.out.println(HexaToBinary(b));
		b = b >> 4; // ���ڸ��� ���������� �о�� 
		System.out.println(HexaToBinary(b)); //�������� �����ִ� �������� ���� ������ �ִ� 0���� ����
		System.out.println();
		
		//	0x0000ff00
		int c = 0x3b12cd59;
		// 0x 3b 12 cd 59			cd�� 10������ ������ �ñ��ϴ�.. �ñ���..
		// 0xcd >> 205
		// System.out.println(HexaToBinary(c & 0x0000ff00));
		// System.out.println(HexaToBinary(c & 0xff00)); �̷��� �ص� ����� ����.
		// cd00�� ��� �ִ�.. �׷� ����? cd�� ���������� 8�ڸ��� �ű�� ������ ��������!
		System.out.println(HexaToBinary( (c & 0x0000ff00) >> 8 ));	//Ȯ���ϱ� ����
		System.out.println((c & 0x0000ff00) >> 8 );
		System.out.println();
		
		// �׷� 3b�� ����? ���� 59��µ�..
		System.out.println((c & 0xff000000) >> 24 );
		
		
		//���� �ٽ� �������ֽô°� ���
		System.out.println();
		System.out.println();
		System.out.println(HexaToBinary(0x3b12cd59));
		System.out.println(HexaToBinary(0x0000ff00));
		System.out.println(HexaToBinary(0x0000ff00 & 0x3b12cd59));
		
	}
}
*/

/*
//ex85-3) 85-2�� �ȾƸԱ� ���� �ڵ� ����
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
		// s.length() >> ���ڸ��� ������ �𸥴�.
		while(s.length() < 32) {
			s = "0" + s;
		}
		System.out.println(s.length());
		System.out.println(s);
		// 0011 1011 0001 0010 1100 1101 0101 1001 ���ڸ����� space�� ����ְڴ�.
		// �迭 4�� ������ space�� ����־��.
		
		// StringBuffer�� ����ϴ�(?) String�� ������ �ִ� �����͸� StringBuffer�� �־���Ѵ�.
		StringBuffer s1 = new StringBuffer(s);
		//s1.insert(4, " ");		//�տ������� �ϴ� ������ ������ ����?
		//System.out.println(s1);	//�ڿ��������ؾ߰ڴ�
		
		for (int i = 0; i < 7; i++) {
			System.out.println((7-i)*4);
			s1.insert((7-i)*4, " ");
		}
		//System.out.println(s1);		
		//s = s1.toString();	// ��Ʈ�����۴� �ܼ��� insert�� ���� �������� �ٽ� string���� �ް�; ��
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
		int num2 = 0x1000;	// 0x �� ���̸� 16���� ǥ����� �Ǿ����.
		System.out.println(num1);
		System.out.println(num2);	//�㳪 10������ ��ȯ �� ǥ��
		
		int num3 = 0x3b12cd59;
		//  3     b    1    2     c    d    5    9
		// 0011 1011  0001 0010 1100 1101 0101  1001
		// 11   1011  0001 0010 1100 1101 0101  1001
		System.out.println(num3);
		
		String s = Integer.toBinaryString(num3);
		System.out.println(s);
		
		//111011000100101100110101011001	����� �̷��� ������ ����.. 
		//0011 1011 0001 0010 1100 1101 0101 1001 ���ڸ��� ��� 16������ ���� �׳��� ���Ⱑ ����..
		
		// 32��Ʈ�� ��� ����ʹ�!
		
		int num4 = 1;
		// ������ ���� ��µǴ� ǥ�� Ŭ���� �Լ��� ���°�?
		// ����. ���� ¥���Ѵ�. -> 85-2���� �ذ�����
		//0000 0000 0000 0000 0000 0000 0000 0001 ����: 32��Ʈ�� ��� ����ʹ�..
	}
}
*/

/*
//ex84) �����̷�
public class Hello 
{
	public static void main(String[] args) 
	{
		
		// 2���� ���ڸ��� 16���� ���ڸ��� �����ϴ�.
		// ���ڸ� ����� �� ����� �� �ִ� ������ ������ 10�� �� ��
		// 10���� : 16����
		//	 10 : A
		// 	 11 : B
		// 	 12 : C
		// 	 13 : D
		// 	 14 : E
		// 	 15 : F
		
		//  ���� �ΰ� 16����
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
		// 2���� 4�ڸ��� 16���� 1�ڸ��� ����.
		// �׷��� �װ��� ��� �ϻ��� �Ѵ�.
		
	}
}
*/

/*
//ex83)
public class Hello 
{
	public static void main(String[] args) 
	{
		String s = "����ȭ�����Ǿ����ϴ�";
		
		// 1. ���ڿ��̳� �迭�� ���̸� ���� ��
		System.out.println(s.length());
		
		// 2. ���ڿ����� ���� �ϳ��� �˻��� ��
		// char charAt(int index)
		char ch = s.charAt(3);
		System.out.println(ch);
		
		// 3.indexOf
		// int indexOf(String str)
		System.out.println(s.indexOf("ȭ����"));
		// ��ã�� ��쿣 ���? �ε����� ���� �� ���� ���� �ּҰ��� -1�� ��µȴ�.
		System.out.println(s.indexOf("ȣ��ȭ"));	
		
		int findNum = s.indexOf("����");
		if(findNum != -1 ) {
			System.out.println("�˻� ���� : " + findNum);
		}else {
			System.out.println("�˻� ����");
		}
		
		// 4. ���ڸ� �˻��� �� �ٲ�ġ��
		//s.replace("����", "������");
		// s ��ü�� ������ ����Ǿ��°�? 
		System.out.println(s); // ������� �ʾ��� ��
		// ���� 1 : ������ ���� �Ǿ��°��� �ݵ�� Ȯ���ϴ� ��.
		// ���� 2 : �������� ���� �ݵ�� Ȯ���ض�
		String result = s.replace("����", "������");
		System.out.println(result);
		
		// 5. �κ������� ©��� �� ����Ѵ�. (slicing) 
		System.out.println(s.substring(5));
		// 3������ 6�� �ձ���(=5������) (6���� ���� �ȵ�! ������ ��!)
		System.out.println(s.substring(3, 6));
		
		String s2 = "  ȣ  ��  ��  ";
		System.out.print(s2);
		System.out.println("������");		//���� ���� Ȯ�ο�
		
		System.out.print(s2.trim());	// �հ� ���� ������ ���� (�߰��� ���� ����)
		System.out.println("������");		//�ڿ� ���� ��������� Ȯ�ο�
		
		
		// 6.
		//�����͸� �޴� ���� �ڵ�
		byte[] data = new byte[] {65, 'B', 'C', 'D'};
		String s3 = new String(data, 0, data.length);	// 0�� '�迭��ȣ 0���� ��ȯ���Ѷ�'�� �� , ������ ������ ~���� ��ȯ���Ѷ�
		System.out.println(s3);							// �����͸�, 0������, �����ͱ��̰� ��ȯ���Ѷ�
		
		//�����͸� ������ ���� �ڵ�
		String s4 = "Banana";
		byte[] recv = s4.getBytes();
		for (byte b : recv) {
			System.out.println((char)b);
		}
		
		// 7. ���ڿ� �˻� Ƚ���� ī���� �� �� ���� ���ȴ�.
		String s5 = "Apple";
		System.out.println(s5.toUpperCase());	//���ڸ� ���� �빮�ڷ� �ٲپ���
		System.out.println(s5.toLowerCase());	//���ڸ� ���� �ҹ��ڷ� �ٲپ���
		
		// covid Covid coVid = COVID , covid 
		// ���� ���ڸ� ã�� ���ؼ� (��ҹ��� �����ؼ� �˻��� �ɸ���, ���� ���� �빮�ڳ� �ҹ��ڷ� �ٲپ� ã�� ���ؼ� ��) 
		
	}
}
*/


/*
//ex82) finally{}�� ����
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
				return;		// try �ȿ� ������ �ݵ�� finally ������ ����.
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
				
	 	//�� �ڵ尡 ���� 1000�� ¥�� �ڵ���...
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
			System.out.println("�ͼ����� �߻�");
		} finally {
			System.out.println("�ͼ��� �߻����ο� ������� ����ȴ�.");
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
		// 1�� ����� �ǰ� ����, 3�� �ڿ� 2�� ����� �Ǿ����� �� ���ڴ�.
		System.out.println(1);
		
		// 1000ms = 1��
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {Thread.sleep(3000);} catch (Exception e) {}	
			// �����彽���� �Ϲ������� �̷��� ���⶧���� ����ó���� ��
		}
		
		System.out.println(2);
	}
}
*/

/*
//ex80)
// ���α׷��Ӱ� ���� �ͼ����� �߻���ų ���� �ִ�.
class Tiger{
	void m1() {
		System.out.println("1 �� ȣ��");
		
		try {
			throw new Exception();	//�ͼ����� �߻���Ű�� ��ɾ� �㳪 try-catch�� �Բ� �����
		} catch (Exception e) {
			System.out.println("�ͼ����� �߻���");
		}		
	}
	// throws Exception��
	// '�� �ͼ����� �Լ� �ȿ��� ó���� ���� �ʰ�
	// �� �Լ��� ȣ���� ���� ó���� �ϼ���.' ��� ��
	void m2() throws Exception{
		System.out.println("2 �� ȣ��");
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
			System.out.println("������");
		}
	}
}
*/

/*
//ex79) ����ó��(Exception)
//�� ������ ������ "�� ������ ��ü ����?" �㳪 �� �������� ���� �ϱ� ���� �����̾��� ��� �����Ͻø� ����.
public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println("ȣ����1");
		
		// �ٽ��� : ������ �߻��ϴϱ� ���α׷��� �ߴܵǾ���.
		// java.lang.ArithmeticException: / by zero
		// ����ó���� ������ �߻��� �ϴ��� ���α׷��� �ߴܽ�Ű�� �ʰڴ�.
		
		//ex1)
		try {
			// ���ܰ� �߻��ϸ� catch�� �б��Ѵ�.
			// ���ܰ� �߻����� ������ catch�� ���� �ʴ´�.
			int a = 10 / 0;
		} catch (Exception e) {
			// e.printStackTrace(); //��� �߻��� �ͼ����� � ������ ������ش�. �����޼����ƴ�
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
		s = "����ȭ�����Ǿ����ϴ�";
		//int num = s.length();
		System.out.println("���ڿ� ���� : " + s.length());
		
		// NullPointerException
		s = null;
		
		try {
			s.length();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("ȣ����2");
	}
}
*/

/*
//ex78-4) 
//�Ѱ����� �����ϰ� �ִ�.
class Baduk{
	AI ai;
	Baduk(AI ai){
		this.ai = ai;
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {
		ai.play();
		// this.ai.play(); �� ������ �ڵ�
	}
	
	void stop() {
		ai.stop();
	}
}

interface AI{
	void play();
	void stop();
}

//����
class AlphaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ������ ����մϴ�.");
	}
}
//�Ƹ���
class BetaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ������ ����մϴ�.");
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
//ex78-3) ������ : stop()�̶�� �Լ��� ���鶧 �ΰ������� �� �����ؾ��Ѵ�.
//�Ѱ����� �����ϰ� �ִ�.
// ����� ���� ��� ��� >> ���� �����
// ��ü�� �����ϴ� ��� >> �ð� ����� ���.
// �Լ��� ȣ���ϴ� �͵� ����� ���, �μ� ������ �ϴ� �͵� ����� ���.
// ����� ���� �ʴ� ����� �ִٸ�... �� ����� ����ϴ°��� �Ǵ�.
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
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

//����
class AlphaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
	public void stop() {
		System.out.println("���İ� ������ ����մϴ�.");
	}
}
//�Ƹ���
class BetaGo implements AI{
	public void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
	}
	public void stop() {
		System.out.println("��Ÿ�� ������ ����մϴ�.");
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
//ex78-2) ������ : ���ο� �ΰ������� ���涧���� �Լ��� ��� �������Ѵ�.
//�Ѱ����� �����ϰ� �ִ�.
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play(AlphaGo alphaGo) {
		alphaGo.play();
	}
	void play(BetaGo betaGo) {
		betaGo.play();
	}
}

// ����
class AlphaGo{
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
	}
}
//�Ƹ���
class BetaGo{
	void play() {
		System.out.println("�ΰ������� ��Ÿ���Դϴ�.");
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
//ex78-1) ������ : �ΰ������� ����ȴٸ�..? (��Ÿ��, ������)
class Baduk{
	Baduk(){
		System.out.println("�뱹�� �����մϴ�.");
	}
	void play() {
		System.out.println("�ΰ������� ���İ��Դϴ�.");
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
		System.out.println("������");		
	}
}
class Tiger{
	Fruit fruit;
	Tiger(Fruit fruit){
		this.fruit = fruit;				//�������� �ڵ� ����
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
				System.out.println("���ִ�...");				
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
//ex76) ���� �غ��� �ѹ� �غ���
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
	// new Lion() >> �ȴ�. new Tiger() >> �ȵȴ�.
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
		// 2 ��ĳ����
		Tiger t2 = new Lion(); // ��ĳ����
		t2.m1();
		
		// 3
		// Tiger t3 = new Tiger(); �ڵ�� ������ �ȵȴ� (�̿ϼ� Ŭ������ �������� ���Ѵ�.) 
		// �׷��� ���� ��ų �� �ִ�.
		// t3�� ���� Ŭ������ ���� ��������°�? 
		// �͸� Ŭ������ �̿��� ��� (Ŭ���� �̸��� �ڿ� ���ٰ� �ؼ�)
		Tiger t3 = new Tiger() {
			public void m1() {	//�������̽� �ʴ� �ڵ尡 ������ �ƿ� ����� �ٰ�
				System.out.println("ȣ����");
				}
		}; 
		t3.m1();
		
		// 4 �͸�ü
		new Tiger() {
			public void m1() {	
				System.out.println("�ڳ���");
			}
		}.m1(); //��Ʈ���
		
		// �� ������ Ȱ��  
		Apple t5 = new Apple();
		t5.m2(new Lion());
		
		System.out.println("---------------------");
		  t5.m2(new Tiger() {
		   public void m1() {
		    System.out.println("������"); 
		   }
		  });
		 }
		}
*/

/*
//ex74) final�� �� 3���� ����� �� �ִ�.
	// �뵵 3. Ŭ���� �̸� �տ� final�� ���̸�, ����� �������̴�.
final class Tiger{
	// �뵵 1. ���� ���� �޴� ���� ���⼭ �������̴�. 
	final int num = 100;
	
	// �뵵 2. �Լ��̸� �տ� final�� ���̸�, �Լ� �������̵��� �������̴�.
	final void m1() {
		
	}
}

// Tiger�� ���̳��̶� Lion�� ����� �� ���� ����.
//class Lion extends Tiger{
//	// void m1() {} // ���̳��� �ɸ� �Լ��̸��� �־ ������ �ȵ�
//}

//��Ʈ���� ���̳��̶� ����� �ȵȴ�.
class Test extend String{
	
}
// ������� �ȴ�.
class Apple ext Thread{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		// t.num = 200; // ���̳��� 100���� ������ ������ �ȵ�
	}
}
*/

/*
//ex73-3) �Ѱ� �̻� ����� ���� �����̶�� �������̽��� �޴� ���� ����
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

class E extends A implements B, C{	//B,C ������ m2,m3�� ���� �������
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
		
		String s1 = "ȣ����";
		String s2 = null; // null�� ���� ��ü�� �ƴϴ� ��� �� =�� �Ⱦ��� �ȳ־ ���� ����
		
		StringBuffer s3 = null;
	}
}
*/

/*
//ex73-2) �θ�� (Ŭ������ �ϳ�) �ϳ����� �������̽��� ������ �ȴ�.
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
class B extends A{}	 // ����� A <-B <-C �̷� ���
class C extends B{}  // ���⼭ B�� D�� ��ӹ޴� ���߻���� �˴ϱ�? �ڹٴ� �ȵ� (Ŭ������ �ϳ�) �㳪 �������̽��� ������ ��

public class Hello 
{
	public static void main(String[] args) 
	{	
	}
}
*/

/*
//ex72-3) �ѱ������� �������̽� ���Ҹ� �ϰ� �ִ�.
// 1. abstract class�� interface �� ������ �Ǿ���.
// 2. �Լ� �̸� ���� abstract�� �����ߴ�.
// 3. extends�̶� �����ʰ� implements �� �����Ѵ�.
// 4. ���� �Լ��� �ݵ�� �տ� public �� �پ���Ѵ�.
interface �ѱ�����{	//abstract�� ������ �������̽��� ���°� �ξ� ����.
	void �Ա�();		//�������̽��� �ִ� ����  abstract�� �Ƚᵵ �ȴ�.
	void ���();
	void ����();
	void ��ü();
}

class �������� implements �ѱ�����{
	public void �Ա�() {}
	public void ���() {}
	public void ����() {}
	public void ��ü() {}
}

class �ϳ����� implements �ѱ�����{
	public void �Ա�() {}
	public void ���() {}
	public void ����() {}
	public void ��ü() {}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		�������� a = new ��������(); 
		�ѱ����� b = new �ϳ�����(); 
	}
}
*/

/*
//ex72-2)
abstract class �ѱ�����{
	abstract void �Ա�();
	abstract void ���();
	abstract void ����();
	abstract void ��ü();
}

class �������� extends �ѱ�����{
	void �Ա�() {}
	void ���() {}
	void ����() {}
	void ��ü() {}
}

class �ϳ����� extends �ѱ�����{
	void �Ա�() {}
	void ���() {}
	void ����() {}
	void ��ü() {}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		�������� a = new ��������(); // ������ �޴���
		�ѱ����� b = new �ϳ�����(); //��ĳ���� �ϴ��� �� �� ����
	}
}
*/

/*
//ex71)
abstract class ��������{
	void Į() {
		System.out.println("���� Į");	//���� ������� �������� �Ǿ����
	}
	abstract void ����();	//�������̴� ���и� �� ������ϱ� ������ ������ֱ� �ٷ���. 
}

class ���׳�1 extends ��������{
	void ����() {
		System.out.println("������ ����...");
		Į();	//�θ� Į�� ������ ������ Į�� ����ϴ� ���� ������ �ȵ�
	}
	
class ���׳�2 extends ��������{
		void ����() {
			System.out.println("������");
			for (int i = 0; i < 3; i++) {
				Į();
			}
		}
	
}


public class Hello 
{
	public static void main(String[] args) 
	{
		//�������� t1 = new ��������();	//�̿ϼ� �Ǿ��� ������ ��ü ������ �ȵȴ�.
		�������� t1 = new ���׳�1(); // ���׳�1 = new ���׳�1(); �ص� ��
		t1.Į();
		t1.����();
		
		�������� t2 = new ���׳�2();
		t2.Į();
		t2.����();
	}
} //����
*/

/*
//ex70) ���� �ð� �� ¥���� �ڵ� - ǥ��Ŭ������ �� ����ϴ� ���� �ڹٸ� ���Ѵٴ� ��
public class Hello 
{
	public static void main(String[] args) 
	{
		// Math ��� ǥ�� Ŭ���� ����ϴ� ��
		System.out.println(Math.PI); //Math�� ����ƽ�̱⶧���� �ٷ� ��밡�� , ���̰� ���ϱ�
		System.out.println(Math.abs(-15));
		System.out.println(Math.max(10, 20)); // ū ���� ���Ͻ�����
		System.out.println(Math.min(10, 20)); // ���� ���� ���Ͻ�����
		System.out.println(Math.sin(50)); // sin���� ���ϴ� �Լ�
		// �Ҽ��� ���� �ڸ��� �ڽ��� �������� �ٴ��� ���ڷ� �����.
		//							 4.00	
		System.out.println(Math.floor(3.99)); 
		//							 3.00	
		// �Ҽ��� ���� �ڸ��� �ڽ��� �������� ���� ���ڷ� �����.
		//							 4.00	
		System.out.println(Math.ceil(3.01)); 
		//							 3.00	
		// �Ҽ��� ���� �ڸ��� �ڽ��� �������� �ٴ��� ���ڷ� �����.
		//							  -3.00	
		System.out.println(Math.floor(-3.99)); 
		//							  -4.00	
		// �Ҽ��� ���� �ڸ��� �ڽ��� �������� ���� ���ڷ� �����.
		//							 -3.00
		System.out.println(Math.ceil(-3.01)); 
		//							 -4.00
	}
}
*/

/*
//ex69)
abstract class Tiger{
	// �θ� �Լ��� ������ ������ �Լ� �̸��տ� abstract�� ���δ�. {}�� ����
	// abstract - �߻� �̶�� ��
	// �߻��Լ���� ��
	// Ŭ���� �ȿ� �߻��Լ��� 1���� ������ �� Ŭ������ �߻� Ŭ�����̾�� �Ѵ�.
	abstract void m1(); 
	
	//�߻��� �� : �̿ϼ� �̶�� ���� ������.
	//m1 �Լ� �ڵ尡 �̿ϼ� �Ǿ��� ��� ��  
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
		Tiger t = new Lion(); //��-�� : ��ĳ����
		t.m1();
		
		// �� �ڵ尡 ������ �ȵȴ�. ��? 
		// �߻� Ŭ���������� �Ǿ� �ֱ� ������ ��ü�� ������ų �� ����.
		// Tiger t2 = new Tiger();
		
		//�߻� Ŭ������ ��ӹ��� �ڽ��� �ݵ�� �ݵ�� �Լ��� �������̵� �ؾ��Ѵ�. 
		// (�ݵ�� �θ� �̷��� ���� ���� �̷���� �ϴ� å���� ����) �׷��� ������ ���� ����.
	}
}
*/

/*
//ex68-3) 68-2���� 68-3���� ��� �ٲ�°�, �ᱹ ��� 68-1���� ������ ����
class Animal{
	//�پ��� ������ ����� ���� �� �ִ� �� ��Ȳ�� : "������" �̶�� �Ѵ�.
	void cry() {System.out.println("...");}
}
class Dog extends Animal{
	//�������̵�(���� : �����ε��ϰ� �ٸ�) : ��Ӱ��迡�� �θ�,�ڽ� �̸��� �Ȱ��� ���� ����ϴ� ��
	void cry() {System.out.println("�۸�");}
}
class Cat extends Animal{
	void cry() {System.out.println("�߿�");}
}
class Snake extends Animal{
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Random rn = new Random();
		Animal[] ani = {new Dog(), new Cat(), new Snake()}; //��ĳ���� ���п� �̷��� ��� ����
		for (int i = 0; i < 5; i++) {	// for���� ����غ��ô�.
			int num = rn.nextInt(3); // 0, 1, 2
			ani[num].cry(); 	//�ᱹ ��ĳ���ÿ��� �����Ǿ ���Ǵ� ����
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
		String[] br = new String[3]; //���ڸ� ������ �� �ִ� ������ �����������
		br[0] = new String("ȣ����"); // br[0] = "ȣ����"; �� ����.
		br[1] = new String("�ڳ���");
		br[2] = new String("������");
		
		int[] cr = new int[] {10,20,30};
		String[] dr = new String[] {
					new String("ȣ����"),
					new String("�ڳ���"),
					new String("������")
		};
		
		int[] er = {10, 20, 30};		// ar cr er �� ������ ����
		String[] fr = {
				new String("ȣ����"),
				new String("�ڳ���"),
				new String("������")
		};
	
	}
}
*/

/*
//ex67) ��ĳ������ ����ϴ� ����
class Animal{
	void cry() {
		System.out.println("...");
	}
}

class Dog extends Animal{
	void cry() {	//��ĳ������ ���ɼ�
		System.out.println("�۸�");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("�߿�");
	}
}

class Snake extends Animal{

}
//  ������ �Ѹ��� ���涧���� �Լ��� ��� ����� ����߾��� ���� ��ĳ�������� �ذ�
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
	void cry() {	//��ĳ������ ���ɼ�
		System.out.println("�۸�");
	}
}

class Cat extends Animal{
	void cry() {
		System.out.println("�߿�");
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
		t1.cry();	//��ĳ���� ���. �ڽ��� ���� ������ �ڽ��� ������
		t2.cry();
		t3.cry();	//�ڽ��� ���� ������.. �׳� �θ��� ��		
		
		System.out.println("---------------"); 
		//�Ʒ��� ���� ������� �����ٵ� ���轺���� �׷� �� �ߴ�? -> 67������
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
//ex65) ��ĳ���� �ݵ�� �ڽ��� �Ĵٺ��� �ڽ��� ������ �ڽİ���, ������ �θ���� �����Ѵ�. 
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
	//�ڿ� ���� m3��
	void m3() {
		System.out.println(32);
		m2(); //�� ��Ȳ���� ���� (�ڱⰡ �ڽ��̰�) �ڽİ��̴�
		m1(); //�ڽ��� ��(�� ��Ȳ���� �ڽ�) ã�ƺ��� ������ �θ� ã�°��̴� ����
		super.m3();
	}
}


public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Lion();
		t.m1(); // �̰�(�θ��ǰ�) ����� ����. m2�� �޸𸮴� ���������� ��� �� �� ����
		t.m3(); // ��ĳ�����̴� �ڽİ��� ã�ƺ��� �ڽĵ� ������ �ڽİ��� ����		
	}
}
*/

/*
//ex64) (��ĳ����, ������) : ����������
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
		//(Ŭ������ ����� �� �ִ�) ���1 ( �θ��̸� = �� �θ��̸� ) - ��Ӱ� ���谡 ����.
		Tiger 1t = new Tiger();
		
		//���2 ( �ڽ� = �ڽ� ) - 
		Lion t2 = new Lion();
		
		//���3 ( �ڽ� = �θ� ) - �ڹٿ��� �̷� ������ �������� ����
		// Lion t3 = new Tiger(); //�ٿ�ĳ���� 
		
		//���4 ( �θ� = �ڽ� ) - 
		//'��=�ڰ���'�� �ϱ� : �������� "��ĳ����"�̶�� �Ѵ�. -Ÿ���� ���� �������� Ÿ���� ���� ������ִ°�
		Tiger t4 = new Lion();
		
		int a = 10;
		short b = 20; 
		// a = b; // 4 = 2 �������� ū�� ������ �Ѿ�ش�. �㳪 �߸��� �����̴�. ���ʰ� �������� Ÿ���� ���ƾ��Ѵ�.
		
		// �� ������ �ڵ忡���� b�� int ��� �����϶�. - Ÿ��ĳ����
		a = (int)b; // 		
		//a�� ���� �� �������� short��.. -Ÿ��ĳ����
		b = (short)a; 
		
	}
}
*/

/*
//ex63) �ð��� ¥���� ����
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10;
		a = a + 3;
		System.out.println(a);
		
		// ���� ���� �Ǵ밡 ����. +=�� �پ��־ ġ�� �ӵ��� ������ 
		a += 3; // ���� ���� ������ (���� �ڵ峪 ���� �ڵ峪 �Ȱ���)
		System.out.println(a);
		
		// ���� �ӵ��� �����ϴ�. �׷� ���̰� ���ϱ�?
		// ���� �ڵ尡 ������(����� �����ϴ� �ӵ�)�� ������. 
		// ������ ��谡 ���Ƽ� ������ �ӵ� ü�� ���� ���� 30�� ������ �ӵ� ������ ����
		
		int b = 20;
		b = b * 3;
		b *= 3;
		
		int c = 10; 
		c = c + 1; // ������ �ӵ� ���� �ʺ� �϶���, ���մ��� ������ ���Ҷ� �Ϲ������� ���
		c += 1;	   // ������ �ӵ� ���� ������ �ӵ��� ������
		c++;	// ��������  / ����ӵ� ���� ������. 
		++c;	// ����ӵ� ���� ������.
		
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
		// super(); �ڵ� ������ �����Ǿ� �ִ�. super �ڵ�� �ݵ�� ù�ٿ� �;��Ѵ�.
		super(num/5); // �θ� ������ �� �ϼ���.
		//super(3, 4); ���� �ΰ� ���������� �̰͵� ����
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
		// �������� : �θ� �����ڰ� ���� �ǰ�, �ڽ� �����ڰ� �ݵȴ�
		// �� �������̴� 
		// ������ : �ڽ��� ���� ���� �ǰ�, �θ� �� ������ �ȴ�. �׷��� �� �����? = ������ �ڵ� ����
		
		on.show();
	}
}
*/

/*
//ex61) �ڽ��� �� �ٸ� �θ� �Ǿ� �ڽ��� ���� �� �ִ���
class A{		//�θ�
	void m1() {
		System.out.println(1);
	}	
}
class B extends A{	//A�� �ڽ�
	void m2() {
		System.out.println(2);
	}	
}

class C extends B{	//B�� �ڽ�, A�� ����
	void m3() {			//�� �� �ִ� �Լ� : 3�� 2�� 1�� ����
		System.out.println(3);
	}
}

class D extends A{ //A�� �ڽ��̰�, B,C�ʹ� ����
	void m4() {			//�� �� �ִ� �Լ� : 1�� 4���� ����.
		System.out.println(2);
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		C c = new C();  // C�� Ŀ���� ��� F4�� ������ ��� �������� �� �� �ִ�. 
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
//ex60) ���
class Tiger{ // �θ�
	// ���� �� Ŭ������ ����� �Ǹ��ϴ�.
	void m1() {
		System.out.println(1);
	}
	
	void m3() {
		System.out.println(31);
	}
	
}

class Lion extends Tiger { // �ڽ�
	void m2() {
		System.out.println(2);
	}
	
	void m3() {
		System.out.println(32);
	}
	
	void m4() {
		m3();	   // �ڱ� ��
		this.m3(); // �ڱ⸦ �̾߱� �ϴϱ�, �ᱹ �ڱ�� 
		super.m3(); // ���۸��� ���ƿԴ� �����غ��� ���۸� = �ƺ�
	}
} 


public class Hello 
{
	public static void main(String[] args) 
	{
		//��Ӱ� �ƹ� ���谡 ����. ������ Ÿ�̰Ÿ� �̿��Ͽ� Ÿ�̰Ÿ� ������� �׳� Ÿ�̰Ÿ� ������� ��
		Tiger t = new Tiger();
		
		Lion on = new Lion();
		on.m1(); //���ο��� ������ ������ �θ� �״�� ��
		on.m2();
		on.m3(); // ������ �ڱⲨ ���� ����, ������ �θ�� ����.
				System.out.println("------------");
		//�θ� m3�� ����� �� �ִ� ����� �����ϱ�?
		//���������δ� ����.
		//���������δ� �ִ�. �ڽ��� ���ļ� �θ� ����ϴ� ��
		on.m4();
		
	}
}
*/

/*
//ex59-4)
//����ƽ�� ������ ��ü ���� ���� Ŭ���� �̸����� �ٷ� ����� �� �ִ�.
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
	//������ ���� �� �ִ���?
	static int a = 10;	
	int b, c;
	Hello(){
		
	}
	static void m1() {	
		System.out.println("ȣ����");
	}
	
	void m2() {
		System.out.println("�ڳ���");
	}
	
	//main�Լ�(�ü���� ȣ���Ѵ�.) "windowOS.main()" 
	//Hello.main() 
	//Ŭ������ ���� ���� ����ƽ ���п�
	public static void main(String[] args) 
	{
		// static �Լ� �ȿ����� �ݵ�� static����(�ʵ�), static�Լ�(�޽��)�� ����� �� �ֽ��ϴ�.
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
		System.out.println("ȣ����");
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		//Tiger t1 = new Tiger();
		//Tiger t2 = new Tiger();
		//Tiger t3 = new Tiger();
		//System.out.println(Tiger.num); //�̸� ���� ��ü�� 3�� �����Ǿ����� �� �� �ִ�.(����ƽ3)
		
		System.out.println(Tiger.num);
		//Tiger t1 = new Tiger(); //�Ʒ��� ���ϱ� ���� 
		//t1.m1();				  // ��ü�� �����غ�
		Tiger.m1(); // ����ƽ�� ��ü�� ������Ű�� �ʰ� ��� �� �� �ִ�.
		
		System.out.println( Math.PI ); //M ù�ڰ� �빮�ڶ�� ������ Ŭ����, PI�� ����ƽ�� �ɾ������
		System.out.println( Math.abs(30)); 
	}
}
*/

/*
//ex59-1)
class Tiger{
	static int num = 0; // t1,2,3 �� ��������, ������� ���赵�� ����ž, ����ž�� 1����
	int count = 0; // ������ ī��Ʈ (��������x), ���� ������� �¼�
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
		t1.show();	//t1�� t2�� t3�� ++���༭ ������ ����ž�� 3�� �ư�
		t2.show();	//������ count�� 0���� ���� �ڽ��� �Ϳ� ++���༭
		t3.show();	//���� 1��
	}
}
*/

/*
//ex58) this�� 3��° ���
//ȣ���̰� ���ڿ��� ����Ѵٰ� �� ���̴�.
//�ٸ� Ŭ������ ���� Ŭ������ ������ �ѱ涧 ����Ѵ�.
class Tiger{
	void m1() {
		Lion lion = new Lion();
		if(lion.love(this) == true){ //���⼭ this�� ȣ������ ���� ��� ���� �� ���� ����
		System.out.println("�����մϴ�");
	}else{
		System.out.println("������...");
	}
}
	int ���() {
		return 500;
	}
	String ����() {
		return "������";
	}
}

class Lion{
	boolean love(Tiger t) {
		// ok, NG �� �� �ϳ��� �� ��
		int money = t.���();
		if(money > 520) {
			System.out.println("OK");
			return true;
		}else {
			if(t.����() == "������") {
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
//ex57) 58���� ���� �ع�
class Tiger{
	Tiger m1() {
		System.out.println(1);
		return this; // �������״� �·� ���Ͻ����ٰ�
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
		System.out.println("��ħ�� �Դ´�.");
		return this;
	}
	Tiger m2() {
		System.out.println("������ �Դ´�.");
		return this;
	}
	Tiger m3() {
		System.out.println("������ �Դ´�.");
		return this;
	}
	
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		//�� �� ���� �ڵ� ������ �����Ѵ�. (ü�̴� ����� ����ϴ� ����)  
		t.m1().m1().m2().m3();
		System.out.println("-----------------"); //�Ʒ��� ���� ��°������ ������ �ձ���(�ڵ�) ������ ����
		t.m1(); // 1�� ����� �õ��� �Ǵ�.
		t.m1(); // 2�� ����� �õ��� �Ǵ�.
		System.out.println("�ձ��ذ� �����ϴ�.");
		t.m2(); // ��� ����Ų��.
		t.m3(); // ��� ���½�Ų��.
	}
}
*/

/*
//ex55) This�� ���� 2��° ���� (53���� �̾) : �޽�� ȣ�� ü�̴��� ���ؼ� ���ȴ�.
class Tiger{
	int m1() {
		System.out.println("m1");
		return 100;
	}
	String m2() {
		System.out.println("m2");
		return "ȣ����";
	}
	Lion m3() {
		System.out.println("m3");
		return new Lion();
	}
	
	// ���� �ڵ尡 �ٽ�
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
		
		// ü�̴� ��� 
		t.m5().m5().m5().m1();
	}
}
*/

/*
//ex54)¥���� ������ 55���� this�� ����ϴ� �ι�° ���� (�ð��� �ָ��ؼ� ��� ¥����)
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 10, b;
		b = a++; // ���� ���� : a�� ������ �ִ� ������ ���� �����ϰ� ���� �����ϰڴ�.
		System.out.println(a + " " + b);
		
		int c = 10, d;
		d = ++c; // ���� ���� : c�� ������ �ִ� ������ ���� �����ϰ� ���� �����ϰڴ�.
		System.out.println(c + " " + d);
		
	}
}
*/

/*
//ex53) ���� �޴��� �̿��ؼ� ������ ����
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
//ex52) this�� ����ϴ� ù��° ����
class Tiger{
	int a, b;
	Tiger(int a, int b){
		this.a = a; // �ʵ� = �μ�
		this.b = b; // �ʵ� = �μ�
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
		a = a; // �ڱ�����ڵ�� �ǹ̰� ����.
		
	}
}
*/

/*
//ex51) this
class Tiger{
	int age;
	
	Tiger(){
		System.out.println(this.hashCode()); //�̷��� �¾ �Ʊ⸦ ����Ų��.
	}
	
	void showData() {
		// System.out.println(age); �Ʒ��� �ڵ忡�� this�� ������ ��, �̷��� �ᵵ �ȴ�.
		System.out.println(this.age);
		
		//m1(); ���⼭�� this�� ������ �� �ֱ⶧���� ������ �ڵ�, �̷��� �� �� ����
		this.m1();
	}
	
	void m1() {
		
	}
}
public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger ȫ�浿 = new Tiger();
		System.out.println(ȫ�浿.hashCode()); //(�浿��) this�� �ؽ��ڵ尡 ����.
		
		Tiger ������ = new Tiger();
		System.out.println(������.hashCode()); //�����̴� ������ ��� �ؽ��ڵ尡 ����.
	}
}
*/

/*
//ex50) 49���� ���� ���α׷�
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
		Tiger t3 = new Tiger("����ȭ�����Ǿ����ϴ�");
		Tiger t4 = new Tiger(20,30);
		System.out.println(t1.age);
		System.out.println(t2.age);
		System.out.println(t3.age);
		System.out.println(t4.age);
	}
}
*/

/*
//ex49) ������ ������ ���� ���α׷�
class Tiger{
	int a=10, b=20;
	
	//�μ������� ���� �����ڸ� ����Ʈ �����ڶ�� �Ѵ�.
	Tiger(){
		System.out.println("��������1");
	}
	Tiger(int x, int y){
		System.out.println("��������2");
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
	// ������ - 1.�����ڴ� �����ڸ޽���� ����
	// 		  2.�����ڴ� �ݵ�� Ŭ�����̸��̶� �����ؾ��Ѵ�.
	//		  3.�����ڴ� return ���� ���� �� ����.	 (void�� ����.)
	//		  4.������ �Լ�(�޽��)�� ��ü�� �����ɶ� �ڵ� ȣ��ȴ�.
	//		  5.�����ڴ� �ڵ�ȣ���� �����ϰ� ���Ƿ� ȣ�� �� �� ����.
	//					��ü 1���� 1���� ȣ��ȴ�.
	//		  6.��� ����ϴ� �����ΰ�? ��� �ʵ带 �ʱ�ȭ �ϴ� ���� (�ٸ� ���� ���� �̰� ����)
	Tiger() {
		System.out.println("������ ��");
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
//ex47) �Լ� �̸��� �����ϰ� �ۼ��� �� �ִ� ����� �ִ�. 2������
// ���1. ���޵Ǵ� �μ��� ������ �ٸ�����
// ���2. ���޵Ǵ� �μ��� ������ ���ٰ� �ϴ��� Ÿ���� �ٸ���
// �Լ� �̸��� �����ϰ� �۸��� �� �ִ�. �̰��� �Լ� ������(OverLoading)�̶�� �Ѵ�.
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
		System.out.println("������" + title + "�Դϴ�.");
		System.out.println("������" + content + "�Դϴ�.");
	}
	
	void showMessage(String content) {
		System.out.println("������" + content + "�Դϴ�.");
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
		t.m1("ȣ����", 20);
		t.showMessage("...��ó ����Կ���", "�ڷγ� ����" );
	}
}
*/

/*
//ex46)
class Tiger{
	// Lion on = new Lion(); 
	void m1(String s, Lion on) {
		System.out.println("���� ȣ����" + s );
		System.out.println(on.age);
		on.m1();
	}
	
}

class Lion{
	int age = 100;
	
	void m1() {
		System.out.println("���� ����");
	}
}

public class Hello 
{
	public static void main(String[] args) 
	{
		Tiger t = new Tiger();
		t.m1("������1", new Lion()); //��� 1
		System.out.println("-------------------");
		Lion t2 = new Lion();
		t.m1("������2", t2);			// ��� 2
	}
}
*/

/*
//ex45)
class Tiger{
	int num = 10;
	float ff = 3.14f;
	String s1 = "ȫ�浿";
	String s2 = new String("�̼����屺��");
	
	
	void m1(int a, boolean b, String s) {
		System.out.println(s);
		System.out.println(s.length());
	}
	
}

public class Hello 
{
	public static void main(String[] args) 
	{
		// �⺻Ÿ��
		// byte, char, short, int, long, float, double, boolean
		
		//String�� ù�ڰ� �빮���̴�. (ǥ�� Ÿ���� �ƴ϶� Ŭ���� ��� ����)
		//�ڹٿ��� �����ϰ� �ִ� Ŭ�����̴�.
		
		String s1 = "ȣ����"; // �츮�� �̷��� ����� ���������δ� new�� ����ϰ� �ִ�.
		System.out.println(s1);
		
		//F3���� �̿��ؼ� ������ ���¼ҽ��� �����Ѵ�.
		//StringŬ������ �߸������(������) �޽�尡 20�� ���� �ִ�.
		// 8�� ������ �� ����ص� ���α׷� ¥�µ� ���� ���� ����. good
		String s2 = new String(); //�������� Ŭ���� ����
		s2 = "����ȭ�����Ǿ����ϴ�";
		System.out.println(s2.length());
		
		Tiger t = new Tiger();
		t.m1(0, false, "�޹���");
		t.m1(0, false, new String("���"));
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
				System.out.println("ã�Ҵ�.");
				break;
			}
		}
		System.out.println("���������� ã���ּż� �����մϴ�.1"); // for���� �ߴ��߱⿡ ��µ�
	}
	
	void m2(int num) {
		System.out.println("m2 call");
		for (int i = 0; i < 10; i++) {
			if(num == i) {
				System.out.println("ã�Ҵ�.");
				return;
			}
		}
		System.out.println("���������� ã���ּż� �����մϴ�.2"); // �Լ��� Ż���ؼ� ����̾ȵ�
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
		//�ܵ����� return Ű���带 ����� ���� �Լ��� Ż��(�ߴ�)�Ѵ�
		return;		
	}
	
	void m2(int num) {
		if( num < 0) {
			System.out.println("������ �Է��� �� �����ϴ�.");
		}else {
			if( num % 2 == 0 ) 	{
			System.out.println( num + "¦��");
		}
		else{
			System.out.println( num + "Ȧ��");
		}
	 }
	}		
	//m2�� ������ ����(����̾������̸���)�� returen�� ����ؼ� m3�� ����� �� ����� �ڵ�
	void m3(int num) {
		if( num < 0) {
			System.out.println("������ �Է��� �� �����ϴ�.");
			return;
		}
		if( num % 2 == 0 ) 	{
		System.out.println( num + "¦��");
		}
	else{
		System.out.println( num + "Ȧ��");
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
		System.out.println(1); // ��¼��� 3
		m2();
		m3();
	}
	void m2() {
		System.out.println(2); // ��¼��� 1	4	
		m3();
	}

	void m3() {
		System.out.println(3); // ��¼��� 2	5	6
	}
	
	//���ΰ� ���θ� �θ��� ���·δ� ����� �� ����.
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
		//�μ� ���� ���� ������ ����.
	}
	void m2(int a, int b) {
		System.out.println(2);
		//�μ� ���� �ְ� ������ ����.
	}
	int m3() {
		System.out.println(3);
		//�μ� ���� ���� ������ �ִ�.
		return 100; 
	}
	int m4(int num) {
		System.out.println(4);
		 //�μ� ���� �ְ� ������ �ִ�.
		return 100;
	}
}
public class Hello  //���� �� ����
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
	// void�� ���� ��� ���� ������ �ִ�.
	// �������� ���ο��� �����ϴ� �� ���� ��� ��
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
	
	// �ݵ�� ���������� return�� ������ �Ѵ�.
	int m5(int a, int b) {
		if(a > b) {
			return 1000;
		}
		else {
			System.out.println("�۸�");
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
		//���1
		int a = t.m2();
		System.out.println(a);
		
		//���2
		System.out.println(t.m2());
				
		//�ȹ޾��� 100�� �����
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
	// ���� : int a, b, c ��� ���� �ȵȴ�. 
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
		for (int i = 0; i < 3; i++) { //����
			for (int j = 0; j < 4; j++) { //����
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
		for (int i = 0; i < height; i++) { //����
			for (int j = 0; j < width; j++) { //����
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
		tiger.m4(100, 3.14f, false, '��');
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
		System.out.println("�ڵ����� �޸���.");
		fuel = fuel - 13;
	}
	void stop() {
		System.out.println("�ڵ����� �����.");
		fuel = fuel -2;
	}
	void inject(int num) {
		System.out.println("�ڵ����� ���Ḧ �����մϴ�.");
		fuel = fuel + num;
	}
	void show() {
		System.out.println("���� ���ᷮ�� : " + fuel);
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
	// 3.�޽�� : ���� ���Ǵ� �ڵ带 �����س��� �ʿ��Ҷ� �ҷ��� ����ϴ� �����̴�.
	// �θ��ٸ� ���� ���� : call(��)�Ѵ� ��� �Ѵ�. �޽�带 ���Ѵ�.
	void merry() {
		System.out.println("��");
	}
	// int num = 7;
	void happy(int num) {
		System.out.println(num);
		for (int i = 0; i < num; i++) {
			System.out.print("�� ");
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
// Ŭ���� �ȿ� ��� �ִ� ����� ��� �����̴�. (�ʵ�, ������, �޽��) 
// Ŭ���� ����� �̶�� �Ѵ�.
// int a; //�ʵ�, ��� �ʵ�, ������� ��� �� �����ؼ� �����
class Airplane{
	// 1. �ʵ� ( ������ ������ �Ȱ���. )
	int a;
	int b, c;
	int d = 10, e = 20;
	int f, g = 30;
	int fuel;
	int windowNumber;					//���⼱(Ŭ����) ��ǻ�Ͱ� �޸𸮸� ���� �ʴ´�.
}

public class Hello 
{
	public static void main(String[] args) 
	{
		System.out.println(100);
		// ȣ���� apple = new ȣ����;
		Airplane air1 = new Airplane(); //�̶� �޸𸮸� �ܶ� �ް� �ȴ�.
		Airplane air2 = new Airplane();
		System.out.println( air1.hashCode() ); //���� ��ȣ�� ���� ��
		System.out.println( air2.hashCode() );
		
		air1.a = 100;
		air2.a = 200;			// �¼���ȣ�� ���ٰ� ���� ���� �ƴ��� ���� ����Ⱑ �ٸ���.
		System.out.println(air1.a + " " + air2.a); //Ŭ���� ���� �ʵ带 ����ߴ�.
		System.out.println(air1.g + " " + air2.g); //���� ������ ���� �Ǿ��ִ�.
		
		air1.fuel = 100;				// 1�� ����� ���� 100���� 
		air1.fuel = air1.fuel - 20;		// �㳪 20 ���
		System.out.println(air1.fuel + " " + air2.fuel); //2������ ���ʿ� ���� ����
	}
}
*/

/*
//ex35) �ڹ��� �� : Ŭ����(��ü(Object) ����(Oriended) ���α׷�(program))
//OOP��� ��
// ������ ���α׷� (������ ���α׷�)
// ��ü ���� ���α׷�
//���赵�� ������ 
//Ŭ����(���赵) �̸��� ù�ڸ� �빮�ڷ� �ϴ� ���� ����(�Ϲ����� ���)�̴�.
class Airplane{
	// 1. field �ʵ�(����)�� �� �� �ִ�.
	// 2. �����ڰ� �� �� �ִ�.
	// 3. method �޽��(�Լ�)�� �� �� �ִ�.
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
		
		//ex2) forEach, ����ȭ�� for��
		// x, data, value ��� ���� �̸��� �ַ� �����
		for (int x : ar) {
			System.out.print(x + " ");
		}System.out.println();
	}
}
*/

/*
//ex33) �� �ڸ� ���ϴ� ���α׷�
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
		// ����(����)�� �߻���Ű�� ���α׷�
		Random rn = new Random(); //ù�� R�� ����
		
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
		//�迭�� �����ϴ� ���1
		int[]ar = new int[10];
		
		//�迭�� �����ϴ� ���2
		int[]br = new int[] { 1, 2, 3, 4 };
		
		//�迭�� �����ϴ� ���3
		int[]cr = { 1, 2, 3, 4, 5, 6 };
		
		System.out.println(ar.length);
		System.out.println(br.length);
		System.out.println(cr.length);
		
		// 2,3�� ���������� ���⶧���� 2�� �� �ٿ� 3�� ���°� ����
		// 1,3 ���Ҷ� 1�� �� ��� �ϴ� ��찡 ���� ���� 3���� �������� 1,2,3 �� �˾Ƶֶ�
		// ���������� 3���� ���� �Ⱦ� � �ȵǱ� ������ 
		// ���������� ���� 1�� �� ��� �� ������
		
		//���� ��
		int num = 100; // 1�� ���� ���, ���� ��
		int[]dr = new int[num];
		System.out.println(dr.length);
	}
}
*/

/*
//ex30) �迭 ( array )
public class Hello 
{
	public static void main(String[] args) 
	{
		// ȣ���� t1 = new ȣ����; ���� �Ͱ� �� ���� ���ڰ� ���ƾ��� (ȣ����)
		
		int[] arr = new int[10];
		
		arr[0] = 10;
		arr[3] = 20;
		arr[9] = 30;
		//���� ���� �����սô�
		System.out.println("ȣ����");
		// arr[10] ��� ������ ����. 0������ ����ϱ� ���� 
		System.out.println(arr[0]);
		System.out.println(arr[3]);
		System.out.println(arr[9]);
		
		System.out.println(arr[0] + 100);
		arr[5] = arr[3] * 3;
		System.out.println(arr[5]);
		
		System.out.println(arr[4]); //�������� �������� 0���� �� �ʱ�ȭ �Ǿ����� 
		
		int num = 7;
		arr[num] = 999;
		System.out.println(arr[7]);
		// [  ] ���̿� ���� ���ڳ� ������ �츮�� �ε���(aka ÷��)��� �Ѵ�
		
		arr[num*2-10] = 888; //�ε����� ������� ��־ ����
		System.out.println(arr[4]);
		
		arr[2] = 3;			
		arr[arr[2]+4] = 666;	//�̷��� ���� �ʰ����� �̷л� �����ϴ� ���� �����ֱ� ����
		System.out.println(arr[7]);
		
		System.out.println("----------------"); //�迭�� �����ص� ���� Ȯ���ϱ� ���� for�� ���
		System.out.println("�迭�� ũ��� " + arr.length);
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
		//������ 1. case �ڿ� ���� ���ڴ� �ߺ��� �� ����.
		//	2. case �ڿ��� ������ �� �� ����. num �� ������ ���� �� ���ٴ� ��
		//	3. switch �ȿ��� ������ �� �� �ִ�.
		//	4. Ȥ�ö� break;�� �����ϸ� ��� ������ ��������. �ǵ������� �׷��� ����� �� �ִ�.		
		int num = 1;
		switch (num) {
		case 1:
			System.out.println("��1");	//�ܹ����̶� {}�� ����
			break;			
		case 2:{
			System.out.println("��2");  //Ȥ�� �ѹ��� �̻��̸� {���� 
		}break;						   //break �տ��� }�� ġ�⵵ �Ѵ�.
		case 3:
			System.out.println("��3");
			break;
		default:
			System.out.println("��4");
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
			System.out.println(i + "ȣ����");
			
			if( i == 8 )
			{
				System.out.println(i + "Ż������");
				break;
			}
		}
	}
}
*/

/*
//ex26) break, continue �� ������ �ݺ������� ���ȴ�.
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
				System.out.println(num + "ȣ����"); // �տ� num + �� �������� 
				continue;
			}
			System.out.println(num + "������");    // �ĺ��ϱⰡ �� ����
			if( num > 5 )
			{
				System.out.println(num); // num�� � ��Ȳ���� Ż���ϴ��� �˱����Ѵٸ�
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
				break; //�ܹ��������� ������ ����
			
		}
		System.out.println(100);
	}
}
*/

/*
//ex24) while ��ڼ� ��� ���α׷�
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
//ex23) �� ������ ���� {}�� ������ �� �ִ�.  
public class Hello 
{
	public static void main(String[] args) 
	{
		int a = 3 , b = 2;
		if(a > b)
		{
			System.out.println("ȣ����");
		}
		
		if(a > b)
			System.out.println("ȣ����");
		for (int i = 0; i < 3; i++) 
			System.out.println(i);
		System.out.println("------------------");
		for (int i = 0; i < 3; i++); //;�� ���⼭ ���δٸ�? 
		{
			System.out.println("ȣ����");
		}; //for�� }�ڿ� ;�� ������ ����
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
		// �ݺ��� ���� ����̴�.
		// for�� �ݺ�Ƚ���� �� �� ����Ѵ�.
		// while�� �ݺ�Ƚ���� �� �� ����Ѵ�.
		
		// ex1) �� ���� ������ ������� �ʴ´�.
		// ���ְ� �Ͼ�� ������ �ּ��� ���� (���� ������ ����)
		// int num = 0;
		// while(true) // while(����)
		// {
		// 	num++;
		//	System.out.println(num + "ȣ���� ");
		// }
		
		// ex2)
		// int num = 0;
		// while( num < 4 )
		// {
		// 	System.out.println(num + "ȣ���� ");
		// }
		
		//ex3) �ݺ� Ƚ���� �˰� �ֿ��� for���� �ƴ�, while�� ����ϰ� �ִ�.
		// ����, �߸��� ���α׷��̴�
		int num = 0;  
		while(num < 4)
		{
			System.out.println(num + "ȣ���� ");
			num++;
		}
		
		System.out.println("while�� ���� ����");
		System.out.println("----------------------");
		//ex4)
		int num2 = 0;
		while(true)
		{
			System.out.println(num2);
			if( num2 == 4 ) 
			{
				System.out.println("Ż���ϱ� �Ϻ�����");
				break; // break�� ������ ������ while �ݺ����� Ż���Ѵ�.
			}
			num2++;
		}
		System.out.println("Ż���");
				
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
			System.out.println(); //4���ϰ� �ٹٲ��ϵ��� �ۼ�
		}
		
		// ��� �ȿ��� ����� �ٸ� �� 
		for (int i = 0; i < 10; i++) 
		{
			if(i % 2 == 0)
			{
				System.out.println(i + ":" + "¦��" );
			}			
			else 
			{
				System.out.println(i + ":" + "Ȧ��");
			}
			
		}
	}
}
*/

/*
//ex20) 4�ڸ� �������� ��� ���ϴ� ���α׷�
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
			System.out.println(i + " " + q + " " + r ); //�ڵ尡 ���� �ǹ��ϴ��� Ȯ��
			sum = sum + r;    // 1+2+3+4�� ���� ��
		}
		System.out.println(sum);
	}
}
*/

/*
//ex19) a�� b���� ���ϴ� ���α׷�
public class Hello 
{
	public static void main(String[] args) 
	{
		int sum = 1;
		int a = 2, b= 8; 
		for (int i = 0; i < b; i++) {
			sum = sum * a;
		}
		// a�� b�� ���ߴ�. (a�� b��)
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
		int num = 19; // ������ �̷��� �̿����ָ�, ���� �ϳ��� �ٲٸ� �Ǵϱ�, �ξ� ����. 
		for (int i = 0; i < 10; i++) {
			System.out.println( num + " * " + i + " = " + i * num );
		}
		System.out.println("-------------------");
		
		//ex3) �ջ����α׷�(Ȥ�� �������α׷�)
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
			System.out.println(i + "ȣ����");
		}
		
		{
			int num = 10;
			System.out.println(num);
		} // }�� ������ ���� ���� num�� �޸𸮰� ����� (���������� �ش�)
		
		//System.out.println(num);
		{
			int num = 20; //������ ������⶧���� �̸��� ���Ƶ� ��
		}
		
		for (int i = 0; i < 3; i++) 
		{
			System.out.println(i + "������");
		}
		
		System.out.println("-----------------------");
		System.out.print("�޹���1"); //ln�� ���� �ٹٲ� �������� �� ��
		System.out.print("�޹���2");
		System.out.println("�޹���3"); // �������� �ٹٲ��� �ߴ� �� ��
		
		for (int i = 0; i < 6; i++) {
			System.out.print( i + " " ); // i�� ����
		}
		System.out.println(); //�ٹٲ޸� �Ͼ��.
		System.out.println("������");
	}
}
*/

/*
//ex16)
// �ڹٸ� ���ϴ���? �Ʒ��� 3������ �Ͱ� �� ����
// 1. for�� �� ����� �� �ִ°�? ���α׷��� 70% �̻��� for���� ���� 
// 2. Ŭ������ �� ����� �� �ִ°�?
// 3. �������� �� ����� �� �ִ°�?
public class Hello 
{
	public static void main(String[] args) 
	{
		// ���( if, for, switch, while)
		System.out.println("ȣ����");
		
		for (int i = 0; i < 10; i++) //�� for���� ��� �����?  'i< n' ���� n�� ���ϴ�. 
		{
		System.out.println(i);	
		}
		
		System.out.println("�ڳ���");
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
		
		//�ݵ�� 1���� ����(����)��Ų�ٴ� ���� �Ʒ�����
		// ���� �����ڸ� ����� �� �ִ�.
		num++; // num = num + 1; ������ ������ �ڵ��̴�.
		++num; // num = num + 1; ������ ������ �ڵ��̴�. �ٷ� ���� �ڵ�� ���̴� �ڿ��� ����
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
		
		//�츦 �Ǻ����ִ� ���α׷�
		int year = 1969;
		System.out.println(year % 12); //�������� 1�� ������ �� �߶�
		
		if( year % 12 == 0)
		{
			
		}
		else if( year % 12 == 1 )
		{
			System.out.println("����� �߶� �Դϴ�.");
		}
		else if ( year % 12 == 2 ) 
		
		System.out.println("����ȭ");
		// 1. if() {}
		// 2. if() {} else {}
		// n�� �߿� �ݵ�� 1���� �����ϰ� ������ ����ϴ� ���ǹ� else if()
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
			System.out.println("����� ������ A �Դϴ�.");
		}
		else if( jumsu >= 80 )
		{
			System.out.println("����� ������ B �Դϴ�.");
		}
		else if( jumsu >= 70 )
		{
			System.out.println("����� ������ C �Դϴ�.");
		}
		else if( jumsu >= 60 )
		{
			System.out.println("����� ������ D �Դϴ�.");
		}
		else 
		{
			System.out.println("����� ������ F �Դϴ�.");
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
			System.out.println(2);	// (���ǿ� �����ϸ�) 1�� ��� 
		}
		else //���߿� �ϳ��� �ݵ�� ����ؾ� �Ҷ� if - else �� ����
		{
			System.out.println(3);	// (�׷��� ������) 2�� ���
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
				
		//ex3) ¦������ Ȧ������ �Ǵ��ϴ� ���α׷�.
				int num = 23;
				if( num % 2 == 0 ) 
				{
					System.out.println( num + "�� ¦���Դϴ�.");
				}
				else 
				{
					System.out.println(num + "�� Ȧ���Դϴ�.");
				}
				
		//ex4)
				//		   1000000
				int num2 = 2109211;
				if( num2 / 1000000 == 1)
				{
					System.out.println("���� ����");
				}
				else 
				{
					System.out.println("���� ����");
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
		// 4�� ��� ( if, for, while, switch ) do(�� ��������)
		// () {} �� �ݵ�� ������ �����Ѵ�.
		//if(����) : ��ǻ�Ͱ� ���� ������ �Ǵ��� �� �ִ� ��Ұ� ����
		// ex1		
		if( false )
		{
			System.out.println("ȣ����");
		}
		System.out.println("�ڳ���");		
		
		// ex2
		if( 30 > 20 )
		{
			System.out.println("������");
		}
		System.out.println("�޹���");
		
		// ex3)
		// �������� �񱳿����� ���� �Ͼ�� �ִ�.
		// ���� �Ͼ�� ��� �켱������ 1���� ������� 2���� �񱳿���
		int a = 12, b = 5;
		// if ( 0 == a % b )
		if( a % b == 0 )
		{
			System.out.println("5�� ����̴�");
		}

		// ex4)
		if( 3 > 2)
		{
			System.out.println("ȣ����1");
			System.out.println("ȣ����2");
			System.out.println("ȣ����3");
			System.out.println("ȣ����4");
			System.out.println("ȣ����5");
		}
		
		// ex5)
		int c = 3;
		// 6 < 9 
		if( c * 2 < c * 3) 
		{
			System.out.println("����");
		}
		System.out.println("---------------");
		// ex6) ��� �ȿ��� ����� ����� �� �ִ�.
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
		// ���� if	 ���� if
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
		// ���ǻ��� : >= (�ǹٸ� ����), => (�߸��� ����) ũ�ų� ����, �۰ų� ���� ��� �ؾ�
		System.out.println( 20 >= 20 );
		System.out.println( 20 <= 19 );
		// ���ǻ��� : ==�� 2���̴�. 1���� �ƴ�
		System.out.println( 20 == 20 );
		// !�� ���������ڶ�� �Ѵ�. !�� ���� �ʽ��ϱ� ��� ��
		System.out.println( 20 != 10 );
		
		System.out.println("---------------------");		
		int a = 10, b = 9;
		System.out.println( a > b );
		System.out.println( a < b );
		System.out.println( a >= b );
		System.out.println( a <= b );
		System.out.println( a == b );
		System.out.println( a != b );
		// ũ�� �۳� ���� �����ʳĸ� ���� ���� ���迬���� ��� �ϰ� �񱳿����� ��� �� 
	}
}
*/

/*
//ex9)
public class Hello 
{
	public static void main(String[] args) 
	{
		// �ʱ�ȭ ���� ���� ������ ����� �� ����.
		//int a;
		//System.out.println(a);
		int a = 20, b = 4;
		System.out.println( a + b );
		System.out.println( a - b );
		System.out.println( a * b );
		System.out.println( a / b );
		System.out.println( a % b );
		System.out.println("--------------------");
		
		// �� ������ ���� ��ȯ�ϴ� swap ���α׷�.
		int a1 = 88, a2 = 99; // ������ 10 20���� �ϴ� �ٲ۰��� ȥ������
		int temp; // t��� ���ڸ� ���⵵ �Ѵ�.
		
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
		int b = 20; // ��ǻ�;� 4byte�� �ְ� �װ��� b�� �ϼ���, �׸��� �ű⿡ 20�� �־� �ռ����
		System.out.println(b);
		
		// ex3)
		int c, d, e; // 1�� �̻� ����� �� �ִ�.
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
		// ���� ������ ��Ų��. ���Ŵ� �ؾ������, �� �������� ����մϴ�. ���� ����� ������ ��������
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
		// -128 ~ +127 ����
		apple = 100;
		System.out.println(apple);
		System.out.println(Byte.MAX_VALUE); //�빮�ڷ� �����ϴ� Byte
		System.out.println(Byte.MIN_VALUE);	
		
		// 2 byte��û = 16bit ��û
		short banana;
		banana = 5000;
		System.out.println(Short.MAX_VALUE); //�빮�ڷ� �����ϴ� Short
		System.out.println(Short.MIN_VALUE);
		
		// 4 byte��û = 32bit ��û
		int kiwi; // int �� integer�� ������ ��
		System.out.println(Integer.MAX_VALUE); //int�� ���Ӹ��̴� Integer�� �� ����� 
		System.out.println(Integer.MIN_VALUE); //���� ������ �빮�ڷ�
		
		// 8 byte��û = 64bit ��û
		long orange;
		System.out.println(Long.MAX_VALUE); //�빮�ڷ� Long
		System.out.println(Long.MIN_VALUE);
		
		// 4byte�ּ���. ( ����, �Ҽ��� ) 
		float tiger;
		tiger = 1234.5678f; //�Ҽ��� �������� �ݵ�� �ҹ��� f�� �־�����Ѵ�.
		System.out.println(tiger); //�Ҽ��� ���� ������ ����� �߻� ������ ���� �� ����
		
		// 8byte �ּ���. (����, �Ҽ��� )
		double lion;
		lion = 1234.5678; //�ڿ� f�� �Ⱥ��� �̰ɷ� �����ϵ���
		System.out.println(lion); // �÷Ժ��� �Ҽ��� ���� �߻��� ���� �㳪 ������� �������䳲
		
		// 1byte ( true / false ���� ������ ����ϱ� ����)
		boolean cat;
		cat = true; // Ȥ�� false;
		System.out.println(cat);
		
		// 2byte (���ڸ� ���������� �����ϴ� ���̴�.)
		char dog;
		dog = '��';
		System.out.println(dog);		
		
		// 8������ ǥ�� Ÿ���̴�. ���� int Ÿ���̶� ������ ����ϴµ� �������� 
	}
}
*/

/*
//ex6)
public class Hello 
{
	public static void main(String[] args) 
	{
		// ���;� �ڽ� 1�� �����...
		byte apple;
		
		// ���;� ��� apple�̶�� ����(�޸�)�� 30�� �־����.
		// = �� ���Կ����̶�� �ϴµ� �׻� �����ʿ��� �������� ����.
		// <---
		apple = 30; //���ÿ� 30�� ����
		System.out.println(apple); //�׷� ������ ����غ���
		
		byte banana;
		banana = 40;
		System.out.println(banana); // banana�� ctrl + space �̿��ϸ� ����
		
		System.out.println(apple + banana);
		System.out.println(apple + " " + banana);
		
		// �����̸� �۸��
		// 1. ������ �̸����� �ߺ����� �� �� ����.
		// byte banana;
		// �� �̸��� �����ص� ��ҹ��ڴ� ���� �ٸ��� �ؼ��Ѵ�. (�����Ѵ�)
		// �㳪 �������̸� ������� �ʴ°��� ����. (���α׷��Ӱ� �򰥸��ϱ�)
		byte Banana;
		
		// 2. ù���ڰ� ���ڰ� �ƴϸ� ���ڸ� ����� �� �ִ�.
		byte apple1234;
		// byte 7apple; // ù���ڰ� ���ڶ� �ȵȴ�.
		
		// 3. _(�����)�� $�� �����ϸ� Ư�����ڸ� ����� �� ����.
		byte _apple;
		byte apple$;
		// byte #apple; �ΰ� Ư�����ڸ� �����ϸ� ����� �� ����.
		
		// 4. �ѱ��� ����� �� ������ ������ ���Ѵ�.
		byte ���;
		��� = 60;
		System.out.println(���);
		
		// 5.�� �ܾ� �̻��϶��� ��Ÿ�� �����Ѵ�. // ��Ÿ ���츮�� �ö���ִ� �ι�°�ܾ���۴빮�ڷ�
		// ī�� ǥ����̶�� �Ѵ�
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
		// 1. ���� 2. ����(1����) 3. ���ڿ�(���ڵ��� ����)
		System.out.println( 100 );    // ����
		System.out.println( '��' );    // ����
		System.out.println( "����ȭ" ); // ���ڿ�
		System.out.println( "100" );  // "���ڿ�"���
		System.out.println( '7' );    //  '����'���
		System.out.println( "-------------" );
		System.err.println( 100 ); // ��������� �ǳ� ��������� �Ǿ �����۷� ���
		System.out.println( "-------------" );
		// + �� ����� ���ε�,

		// 1. ���� + ���� = ����
		System.out.println( 10 + 20 ); // ���ڿ��� ���� + ����
		
		// 2. ���� + ���ڿ� = ���ڿ�
		//���ڿ� ������ �Ͼ��.
		System.out.println( 10 + "ȣ����" ); // ���� + ���ڿ�
		//System.out.println( "10" + "ȣ����" ); // (�ٷ� ����) ���α׷��� ����
		
		// 3.���ڿ� + ���� = ���ڿ�
		System.out.println( "ȣ����" + 10 );
		
		//
		// 4.���ڿ� + ���ڿ� = ���ڿ�
		System.out.println( "ȣ����" + "�ڳ���" );
		
		// ��� : 7ȣ����
		System.out.println( 3 + 4 + "ȣ����" );
		
		System.out.println( 3 + "ȣ����" + 4 );
		
		System.out.println( "ȣ����" + 3 + 4 );
		// 10 20 : ���� ���α׷��� ���� ����Ѵ�.
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
		System.out.println("ȣ����");
		// " " ���̿� �ִ� ���ڵ��� ������ ���ڿ�(string)
		System.out.println( "13 + 7" );
		System.out.println("---------------"); //����
		
		//���������.
		System.out.println( 13 + 7 );
		System.out.println( 13 - 7 );
		System.out.println( 13 * 7 );
		System.out.println( 13 / 7 ); // ��
		System.out.println( 13 % 7 ); // ������
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
		// �ּ�
		// ���α׷��� �����ϴ� �뵵�� ���� ���ȴ�.
		System.out.println("����ȭ");
		//System.out.println("ȣ����");
		System.out.println("�ҳ���");
	}
}
*/