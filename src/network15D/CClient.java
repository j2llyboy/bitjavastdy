package network15D;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CClient extends Application{
	Socket cs;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root2 = new VBox();
		root2.setPrefSize(400, 300);

		Button btnn = new Button("connect");
		btnn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cs = new Socket();
				try {
					System.out.println("Trying connect");
					cs.connect(new InetSocketAddress("localhost",6666));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		Button btnn1 = new Button("Send");
		btnn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					OutputStream os = cs.getOutputStream();
					String s = text.getText();
					text.setText("");
					byte[] data = s.getBytes("UTF-8");
					os.write(data);
					System.out.println("data sended");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		Button btnn2 = new Button("Exit");
		
		
		
		TextArea textarea = new TextArea();
		TextField text = new TextField();
		text.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OutputStream os = cs.getOutputStream();
				String s = text.getText();
				text.setText("");
				byte[] data = s.getBytes("UTF-8");
				os.write(data);
				System.out.println("data sended");
				
				
			}
		});
		
		
		root2.getChildren().addAll(btnn, btnn1, textarea, btnn2);
		
		
		

		
		Scene scene = new Scene(root2);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
