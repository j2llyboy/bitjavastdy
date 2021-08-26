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
				// ���Ӵ�� �����带 ���⼭ ������Ѿ� ��. ���������� ����� ���ƿͼ� �Ʒ��� ����.
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
