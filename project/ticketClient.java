package ticketMoa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public String select(String get) {
		try {
			ObjectOutputStream sendWriter = new ObjectOutputStream(socket.getOutputStream());
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
		return receiveString;
	}
	
	public String loginChecking(String message) {
		try {
			byte[] bytes=toByteArray(message);
			ObjectOutputStream sendWriter = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream tmpbuf = new ObjectInputStream(socket.getInputStream());
			sendWriter.writeObject(bytes);
			sendWriter.flush();
			receiveString = (String) tmpbuf.readObject();
			if (receiveString == null) {
		          System.out.println("상대방 연결이 종료되었습니다.");
		    } else {
		          System.out.println("상대방 : " + receiveString);
		    }
			
		    }catch (IOException e){
		      e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return receiveString;
	}
	
	public static byte[] toByteArray (String obj)
	{
	    byte[] bytes = null;
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        oos.writeObject(obj);
	        oos.flush();
	        oos.close();
	        baos.close();
	        bytes = baos.toByteArray();
	    }
	    catch (IOException ex) {
	        //TODO: Handle the exception
	    }
	    return bytes;
	}
}
