package network14D;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam05 extends Application{
	// 버튼을 눌러서 작업이 끝났을때 버튼2의 텍스트를 바꿔보자 (작업이 완료된 걸 알려주기 위해서)
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(); 
		root.setPrefSize(400, 300); 
		root.setSpacing(5); 
		
		Button btn1 = new Button("버튼1"); 
		Button btn2 = new Button("버튼2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			//익명 쓰레드를 만들어서 해보자
			//타 쓰레드에서는 자바fx ui를 직접 못건드리니까
			// 자바fx에게 콜해줌
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("Thread call");
//						btn2.setText("바뀜");
						Platform.runLater(()->{btn2.setText("바뀜");}); //(람다식으로)이렇게 해줘라~~ 
					}
					
				}.start();
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			//2. changbutton 쓰레드를 만들어 붙이기
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ChangeButton cb = new ChangeButton(btn1);
				cb.start();
			}
		});
				
		root.getChildren().addAll(btn1, btn2); 
		
		Scene scene = new Scene(root); 
		stage.setScene(scene); 
		stage.setTitle("Server");	
		stage.show();	
	}

	public static void main(String[] args) {
		launch();
	}	
}

// 스타트가 실행이 되면 버튼 두개를 만들고 이벤트는 이러이러 하다 
// 핸들 메써드가 실행되는데 내용을 보니까, 쓰레드 클래스의 정식명칭은 익명 자식객체를 만든 것.
// 자식 클래스로 객체를 만들고 스타트 하게 되어있는 것을 (부모 클래스 이름으로 new 붙여서 자식 객체로 한방에 만듬)
// 그 자식 객체 안에서 런메써드 오버라이드, 바로 하려고 하니 안돼서(자바FX에서 외부쓰레드로 못건드리게 해서)
//어쩔 수 없이 자바fx 어플리케이션 쓰레드가 처리하게 만듬
// 2. 외부 클래스를 만들어서 할  수도 있으니 외부 쓰레드를 만듬
// 같은 내용의 쓰레드를 만듬 쓰레드를 상속 받아서 프라이빗으로 버튼 가지고 있고
// 생성자에서 버튼을 받아서 디스 버튼에 넣어주고
// 그리고 이놈을 객체로 만들어서 스타트하면 런 매써드가 실행이 되고 플랫폼 런레이터로 
//여기서 버튼에 객체가 들어오는데  실제 작업은
// 돌아와서 체인지 버튼 cb로 만들고 btn1을 넣어서 스타트