package network14D;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class ChangeButton extends Thread {
//버튼2도 버튼1의 글자를 바꾸는 것을 쓰레드로 만들어보자. 이번에는 쓰레드를 안에서 직접 만들지 않고 별도로 만들어 갖다 붙이자.

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
	

	// Platform.runLater는 {button.setText("change");}); 이 작업을 자바fx가 처리할 작업의 큐에 넣어주는 것(위임하는것)
	
}
