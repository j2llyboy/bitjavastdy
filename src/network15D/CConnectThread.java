package network15D;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CConnectThread extends Thread{


	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverSoket = null;
		
		try {
			serverSoket = new ServerSocket();
			System.out.println("create server socket");
			
			serverSoket.bind(new InetSocketAddress("localhost",6666));
			System.out.println("server bind");
			
//			Socket cs = serverSocket.accept();
			System.out.println("Somebody connected");

//			ClientThread client = new ClientThread(cs, textarea);
//			client.start();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	
	

}
