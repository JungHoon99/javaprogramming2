package ticketMoa;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ticketClient extends Thread{
	
	private final Socket socket;
	String str;
	
	public ticketClient() throws IOException{
		socket = new Socket("127.0.0.1",8888);
		System.out.println("서버와 접속되었습니다.");
		InputStream ins = socket.getInputStream();
		DataInputStream dins = new DataInputStream(ins);
		
		str = dins.readUTF();
	  }
	public String getString() {
		return str;
	}
}
