package network15D;

import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket ss;
	
	public ClientThread(Socket ss) {
		this.ss = ss;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				InputStream is = ss.getInputStream();
				byte[] data = new byte[128];
				int size = is.read(data); //네트웍을 읽어와서 저장하는것
 				if (size == -1) { // -1이면 끊긴것임 
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
