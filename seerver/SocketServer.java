import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SocketServer {
	
	public static void main(String[] args) throws IOException {
		int port=8888;
		
		ServerSocket socket = new ServerSocket(port);
		System.out.println("접속대기중");
		
		while(true) {
			Socket sock = socket.accept();
			
			System.out.println("사용자가 접속했습니다.");
			System.out.println("Client : "+sock.getInetAddress());
			
			OutputStream out = sock.getOutputStream();
			DataOutputStream dous = new DataOutputStream(out);
			
			dous.writeUTF("환영합니다.");
			dous.flush();
			dous.close();

		}
	}
	
}
