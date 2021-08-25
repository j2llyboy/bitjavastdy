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
		
	
		Button btn1 = new Button("��ư1"); 

		Button btn2 = new Button("��ư2");
		
	
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btn2.setText("�ٲ����");
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
		
		
//		TextArea textArea = new TextArea(); // �ڹ�fx�� ����Ʈ �翬��, �ؽ�Ʈ����� ����
//		
//		TextField text = new TextField(); //import ��ų�� �翬�� javafx�� ���°� 
//		
//		//root.getChildren().addAll(btn1, text); // �ؽ�Ʈ�ʵ常 ����� add�� �� ����
//		text.setOnAction(new EventHandler<ActionEvent>() {//�ؽ�Ʈ �ʵ忡 �̺�Ʈ �ڵ鷯
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				String s = text.getText(); //���� �ؽ�Ʈ�� �������� ���� ��� �۾�
//				textArea.appendText(s + "\n"); //�ؽ�Ʈ�� ���̴� �� but ��� ���δ�..so +"\n"�� ���� �ٹٲ�
//				text.setText("");//�ؽ�Ʈâ�� �Է��ϰ� ���� �ؽ�Ʈ�� �����ֱ� ���� ��
//			}
//			
//		});
		
		
//		root.getChildren().addAll(btn1, text, textArea); //�ؽ�Ʈ�������� �Ŵ���
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
