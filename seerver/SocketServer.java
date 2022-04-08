package sever;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;


//서버와 클라이언트가 페키지가 동일하지 않으면 통신이 되게 하는법
public class SocketServer  {
	
	public static void main(String[] args) throws IOException, SQLException {
		int port=8888;
		database db=new database();
		ServerSocket socket = new ServerSocket(port);
		System.out.println("접속대기중");
		
		while(true) {
			Socket sock = socket.accept();
			
			System.out.println("사용자가 접속했습니다.");
			System.out.println("Client : "+sock.getInetAddress());
			ReceiveThread receiveThread = new ReceiveThread(sock, db);
		    receiveThread.start();
		}
		
	}
	
}

class ReceiveThread extends Thread {

	  private final Socket socket;
	  private Object receiveMessage;
	  private String getData;
	  private byte[] Buffer = new byte[1024];
	  database db;

	  public ReceiveThread(Socket socket, database db) {
	    this.socket = socket;
	    this.db = db;
	  }

	  @Override
	  public void run() {
	    try {
	      while (true) {
	    	  ObjectInputStream tmpbuf = new ObjectInputStream(socket.getInputStream());
		      ObjectOutputStream sendWriter = new ObjectOutputStream(socket.getOutputStream());
	    	  Buffer = (byte[]) tmpbuf.readObject();
	    	  getData = toObject(Buffer, String.class);
	    	  
	        if (getData == null) {
	          System.out.println("상대방 연결이 종료되었습니다.");
	        } else {
	          System.out.println("상대방 : " + getData);
	          getData = db.count(getData);
	          System.out.println(getData);
	        }
			sendWriter.writeObject(getData);
			sendWriter.flush();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public static <T> T toObject (byte[] bytes, Class<T> type)
	  {
	      Object obj = null;
	      try {
	          ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
	          ObjectInputStream ois = new ObjectInputStream (bis);
	          obj = ois.readObject();
	      }
	      catch (IOException ex) {
	          //TODO: Handle the exception
	      }
	      catch (ClassNotFoundException ex) {
	          //TODO: Handle the exception
	      }
	      return type.cast(obj);
	  }
}
