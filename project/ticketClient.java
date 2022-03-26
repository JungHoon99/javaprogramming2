package ticketMoa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ticketClient extends Thread{
	
	private final Socket socket;
	String str;
	
	public ticketClient() throws IOException{
		socket = new Socket("127.0.0.1",8888);
		System.out.println("서버와 접속되었습니다.");
	  }
	
	public void select(String get) {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			sendWriter.writeUTF(get);
			sendWriter.flush();
		    }catch (IOException e){
		      e.printStackTrace();
		    }
	}
}
