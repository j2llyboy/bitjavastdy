package network14D;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exam03 extends Application { // CSO �� import ��Ű��

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(); // Ctrl shift o �� import ��Ű�� , VBox��ü �����
		root.setPrefSize(400, 300); // ũ�� ����
		root.setSpacing(5); // VBox���� �� ��Ʈ�� ���� ������ �����ϴ� ��
		
		//�ƹ� ���� ���ϴ� ��ư �ΰ� �Ŵޱ�
		Button btn1 = new Button("��ư1"); //javafx�� button �� CSO�� import,  ��ư ����
		//root.getChildren().add(btn1);
		
		//�̺�Ʈ �ڵ鷯�� ������ 
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("��ư1 Ŭ��");
			}
		});
			
		
		Button btn2 = new Button("��ư2");
		//root.getChildren().add(btn2);
		root.getChildren().addAll(btn1, btn2); // �ѹ��� �Ŵٴ� ��
		
		//���������� ���� �Ŵ���, ���������� ���� �Ŵ޸��� �� �ȿ� VBox�� ���� �� �ȿ� ��ư �ΰ��� �� ����
		
		
		Scene scene = new Scene(root); // C S O �� import ��Ű�� , ���� ����
		stage.setScene(scene); 
		stage.setTitle("Server");	// �̸� ����
		stage.show();	//stage�� ������ ���� arg�� �����ߴ��� Ȯ��
		
	}

	
	public static void main(String[] args) {
		launch();
	}
	
}
