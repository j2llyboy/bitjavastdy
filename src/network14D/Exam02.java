package network14D;

import javafx.application.Application;
import javafx.stage.Stage;

public class Exam02 extends Application{ // C + S + O 해서 연결시킬것

	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init");	// start 매써드 전에 init이 먼저 나옴 
	}								//=> start 전에'사전 처리할 내용이 있으면 init 처리하면 되는구나'

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("stop"); //launch로 빠져나와서 stop이 먼저 나옴.
	}

	
	
	
	
	@Override
	public void start(Stage stage) throws Exception { 	//stage = window stage뒤엔(arg) scene
		// TODO Auto-generated method stub
		System.out.println("2");
		stage.setTitle("Server");	//스테이지 창 이름을 설정해줄 수 있다.
		stage.show();
		System.out.println("3");
	}

	public static void main(String[] args) {
		System.out.println("1");
		launch();	// Application 클래스가 갖고 있는 스태틱 매써드 
		System.out.println("4"); // 런치가 창으로 막고 있음 이를 종료하면 4번이 출력
	}
	
	
}
