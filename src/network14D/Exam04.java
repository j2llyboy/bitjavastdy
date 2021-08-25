package network14D;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam04 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(); 
		root.setPrefSize(400, 300); 
		root.setSpacing(5); 
		
	
		Button btn1 = new Button("버튼1"); 

		Button btn2 = new Button("버튼2");
		
	
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn2.setText("바뀌었다");
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				btn1.setVisible(false);
				btn1.setDisable(true);
			}
			
		});
		
		
//		TextArea textArea = new TextArea(); // 자바fx로 임포트 당연히, 텍스트에어리어 생성
//		
//		TextField text = new TextField(); //import 시킬것 당연히 javafx가 들어가는것 
//		
//		//root.getChildren().addAll(btn1, text); // 텍스트필드만 만들고 add만 한 상태
//		text.setOnAction(new EventHandler<ActionEvent>() {//텍스트 필드에 이벤트 핸들러
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				String s = text.getText(); //여기 텍스트를 가져오기 위해 담는 작업
//				textArea.appendText(s + "\n"); //텍스트를 붙이는 것 but 계속 붙인다..so +"\n"을 통해 줄바꿈
//				text.setText("");//텍스트창에 입력하고 나면 텍스트를 지워주기 위한 것
//			}
//			
//		});
		
		
//		root.getChildren().addAll(btn1, text, textArea); //텍스트에어리어까지 매달음
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
