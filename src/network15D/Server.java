package network15D;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Server extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		root.setPrefSize(400,300);
		
		Button btn1 = new Button("Start Server");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Server Start");
				// 접속대기 쓰레드를 여기서 실행시켜야 함. 마찬가지로 만들고 돌아와서 아래와 같이.
				ConnectThread ct = new ConnectThread();
				ct.start();
			}
		});
		
		root.getChildren().addAll(btn1);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Server");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
