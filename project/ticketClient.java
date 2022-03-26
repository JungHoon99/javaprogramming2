package ticketMoa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ticketClient extends Thread{
	
	private final Socket socket;
	private String receiveString;
	private String str;
	
	public ticketClient() throws IOException{
		socket = new Socket("127.0.0.1",8888);
		System.out.println("서버와 접속되었습니다.");
	  }
	
	public void select(String get) {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
			sendWriter.writeUTF(get);
			sendWriter.flush();
			receiveString = tmpbuf.readUTF();
			
			if (receiveString == null) {
		          System.out.println("상대방 연결이 종료되었습니다.");
		    } else {
		          System.out.println("상대방 : " + receiveString);
		    }
			
		    }catch (IOException e){
		      e.printStackTrace();
		    }
	}
}
