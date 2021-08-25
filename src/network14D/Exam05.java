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
	// ��ư�� ������ �۾��� �������� ��ư2�� �ؽ�Ʈ�� �ٲ㺸�� (�۾��� �Ϸ�� �� �˷��ֱ� ���ؼ�)
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(); 
		root.setPrefSize(400, 300); 
		root.setSpacing(5); 
		
		Button btn1 = new Button("��ư1"); 
		Button btn2 = new Button("��ư2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			//�͸� �����带 ���� �غ���
			//Ÿ �����忡���� �ڹ�fx ui�� ���� ���ǵ帮�ϱ�
			// �ڹ�fx���� ������
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("Thread call");
//						btn2.setText("�ٲ�");
						Platform.runLater(()->{btn2.setText("�ٲ�");}); //(���ٽ�����)�̷��� �����~~ 
					}
					
				}.start();
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			//2. changbutton �����带 ����� ���̱�
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

