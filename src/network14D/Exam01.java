package network14D;

import javafx.application.Application;
import javafx.stage.Stage;

public class Exam01 extends Application{

	@Override
	public void start(Stage stage) throws Exception { 	//stage = window stage�ڿ�(arg) scene
		// TODO Auto-generated method stub
		System.out.println("2");
		stage.show();
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		System.out.println("1");
		launch();	// Application Ŭ������ ���� �ִ� ����ƽ �Ž�� 
		System.out.println("4"); // ��ġ�� â���� ���� ���� �̸� �����ϸ� 4���� ���
	}
		
}

