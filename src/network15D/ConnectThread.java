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
			
			serverSocket.bind(new InetSocketAddress("localhost",5001)); //���ε� : �����Ƕ� �ڵ� �Ҵ� �ϴ� �� ->�̸� ���ľ� ����� ������ ����
			System.out.println("server bind");
			
			Socket cs = serverSocket.accept();	//Ŭ���̾�Ʈ�� ���ö����� ����Ұ̴ϴ�. ���� ��Ĺ���� accept�ؼ� ����ϴ� ����, �� �������� 
			System.out.println("Somebody connected");
			
			//Ŭ���̾�Ʈ ����� �����尡 �ϳ� �ʿ��ϹǷ� �����带 ����� ���ƿͼ� �Ʒ��� ����
			ClientThread client = new ClientThread(cs);
			client.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}	
	
}


//21��° �� ����)
// ���� ������ Ŭ���̾�Ʈ ������ ������ �޾Ƶ��̴� �뵵�θ� ����, ���� Ŭ���̾�Ʈ�ϰ� ����ϴ� ������ ������ �����Ѵ�.
// �ֳ� �׷��� �� ��߸� ����� �ϰ� ���� �� �ٸ� Ŭ���̾�Ʈ�� ������ ����� �� �ִ�.
// �׷��� ������ ���� ������ �뵵�� ���� �������� ���� ��ſ��� �ƴϴ�
// ����� ������ �Ϲ� �������� �մϴ�. ���� ������ Ŭ���̾�Ʈ �����û ������!!!
// 