package network14D;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class ChangeButton extends Thread {
//��ư2�� ��ư1�� ���ڸ� �ٲٴ� ���� ������� ������. �̹����� �����带 �ȿ��� ���� ������ �ʰ� ������ ����� ���� ������.

	private Button button;
	
	public ChangeButton() {}

	public ChangeButton(Button button) {

		this.button = button;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(()->{button.setText("change");});
	}
	

	// Platform.runLater�� {button.setText("change");}); �� �۾��� �ڹ�fx�� ó���� �۾��� ť�� �־��ִ� ��(�����ϴ°�)
	
}
