package network14D;

import javafx.application.Application;
import javafx.stage.Stage;

public class Exam01 extends Application{

	@Override
	public void start(Stage stage) throws Exception { 	//stage = window stage뒤엔(arg) scene
		// TODO Auto-generated method stub
		System.out.println("2");
		stage.show();
		System.out.println("3");
	}
	
	public static void main(String[] args) {
		System.out.println("1");
		launch();	// Application 클래스가 갖고 있는 스태틱 매써드 
		System.out.println("4"); // 런치가 창으로 막고 있음 이를 종료하면 4번이 출력
	}
		
}

