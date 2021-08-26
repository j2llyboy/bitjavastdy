package network15D;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			System.out.println("create server socket");
			
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //바인드 : 아이피랑 코드 할당 하는 것 ->이를 마쳐야 통신이 가능한 상태
			System.out.println("server bind");
			
			Socket cs = serverSocket.accept();	//클라이언트가 들어올때까지 대기할겁니다. 서버 소캣으로 accept해서 대기하는 상태, 이 소켓으로 
			System.out.println("Somebody connected");
			
			//클라이언트 응대용 쓰레드가 하나 필요하므로 쓰레드를 만들고 돌아와서 아래와 같이
			ClientThread client = new ClientThread(cs);
			client.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}	
	
}


//21번째 줄 설명)
// 서버 소켓은 클라이언트 최초의 접속을 받아들이는 용도로만 쓰고, 실제 클라이언트하고 통신하는 소켓은 별도로 생성한다.
// 왜냐 그렇게 해 줘야만 통신을 하고 나는 또 다른 클라이언트의 접속을 대기할 수 있다.
// 그렇기 때문에 서버 소켓의 용도가 접속 대기용이지 실제 통신용은 아니다
// 통신은 서버도 일반 소켓으로 합니다. 서버 소켓은 클라이언트 연결요청 접수용!!!
// 