package network15D;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application{
	Socket cs;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		
		root.setPrefSize(400, 300);
		
		Button btn1 = new Button("Connect");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cs = new Socket(); // 클라이언트에서 서버와 통신할 소켓을 생성하는 것.
				try {
					System.out.println("Trying connect");
					cs.connect(new InetSocketAddress("localhost", 5001));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		Button btn2 = new Button("send");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					OutputStream os = cs.getOutputStream();
					String s = "apple" + count++;
					byte[] data = s.getBytes("UTF-8");
					os.write(data);
					System.out.println("data sended");
				}catch (Exception e) {
					
				}							
			}
		});
		
		Button btn3 = new Button("exit");
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					cs.close();
					System.out.println("client stopped");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		});
		
		root.getChildren().addAll(btn1, btn2, btn3);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch();		
	}
	
	
}
