package network15D;

import java.io.InputStream;
import java.net.Socket;

import javafx.scene.control.TextArea;

public class CClientThread extends Thread{
	Socket ss;
	TextArea textarea;
	
	public CClientThread(Socket ss) {
		this.ss = ss;
		this.textarea = textarea;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				InputStream is = ss.getInputStream();
				byte[] data = new byte[128];
				int size = is.read(data); 
 				if (size == -1) { 
					try {
						ss.close();
						System.out.println("client connecton closed");
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				String s = new String(data, 0, size, "UTF-8");
				System.out.println(s);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
}
