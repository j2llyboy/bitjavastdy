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

