package network14D;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam03 extends Application { // CSO 로 import 시키자

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(); // Ctrl shift o 로 import 시키자 , VBox객체 만들기
		root.setPrefSize(400, 300); // 크기 설정
		root.setSpacing(5); // VBox내에 각 컨트롤 사이 여백을 지정하는 것
		
		//아무 동작 안하는 버튼 두개 매달기
		Button btn1 = new Button("버튼1"); //javafx의 button 을 CSO로 import,  버튼 생성
		//root.getChildren().add(btn1);
		
		//이벤트 핸들러를 만들어보자 
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("버튼1 클릭");
			}
		});
			
		
		Button btn2 = new Button("버튼2");
		//root.getChildren().add(btn2);
		root.getChildren().addAll(btn1, btn2); // 한번에 매다는 법
		
		//스테이지에 씬을 매달음, 스테이지에 씬이 매달리고 씬 안에 VBox가 들어가고 그 안에 버튼 두개가 들어간 상태
		
		
		Scene scene = new Scene(root); // C S O 로 import 시키자 , 씬을 만듬
		stage.setScene(scene); 
		stage.setTitle("Server");	// 이름 설정
		stage.show();	//stage에 에러가 나면 arg를 수정했는지 확인
		
	}

	
	public static void main(String[] args) {
		launch();
	}
	
}
