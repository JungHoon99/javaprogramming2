import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;


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
	  private String receiveString;
	  private String getData;
	  database db;

	  public ReceiveThread(Socket socket, database db) {
	    this.socket = socket;
	    this.db = db;
	  }

	  @Override
	  public void run() {
	    try {
	      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
	      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
	      while (true) {
	        receiveString = tmpbuf.readUTF();
	        if (receiveString == null) {
	          System.out.println("상대방 연결이 종료되었습니다.");
	        } else {
	          System.out.println("상대방 : " + receiveString);
	          getData = db.count(receiveString);
	          System.out.println(getData);
	          
	        }
			sendWriter.writeUTF(getData);
			sendWriter.flush();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	  }
}


/*
public class SocketServer {
	 public static void main(String[] args) throws IOException {
		    int port = 8888;
		    ServerSocket socketServer = new ServerSocket(port);
		    System.out.println("서버가 시작되었습니다.");
		    Socket sock = socketServer.accept();
		    System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
		    while(true) {
		      Socket sock = socketServer.accept();
		      System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
		      ReceiveThread receiveThread = new ReceiveThread(sock);
		      receiveThread.start();
		      SendThread sendThread = new SendThread(sock);
		      sendThread.start();
		    }
		  }
}

class SendThread extends Thread{

	  private final Socket socket;
	  private Scanner scanner = new Scanner(System.in);

	  public SendThread(Socket socket){
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
	    try {
	      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
	      String sendString;
	      while(true){
	        sendString = scanner.nextLine();
	        sendWriter.writeUTF(sendString);
	        sendWriter.flush();
	      }
	    }catch (IOException e){
	      e.printStackTrace();
	    }
	  }
	}
*/
