package network14D;

import javafx.application.Application;
import javafx.stage.Stage;

public class Exam02 extends Application{ // C + S + O �ؼ� �����ų��

	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init");	// start �Ž�� ���� init�� ���� ���� 
	}								//=> start ����'���� ó���� ������ ������ init ó���ϸ� �Ǵ±���'

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("stop"); //launch�� �������ͼ� stop�� ���� ����.
	}

	
	
	
	
	@Override
	public void start(Stage stage) throws Exception { 	//stage = window stage�ڿ�(arg) scene
		// TODO Auto-generated method stub
		System.out.println("2");
		stage.setTitle("Server");	//�������� â �̸��� �������� �� �ִ�.
		stage.show();
		System.out.println("3");
	}

	public static void main(String[] args) {
		System.out.println("1");
		launch();	// Application Ŭ������ ���� �ִ� ����ƽ �Ž�� 
		System.out.println("4"); // ��ġ�� â���� ���� ���� �̸� �����ϸ� 4���� ���
	}
	
	
}
