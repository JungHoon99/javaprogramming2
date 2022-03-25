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
	  database db;

	  public ReceiveThread(Socket socket, database db) {
	    this.socket = socket;
	    this.db = db;
	  }

	  @Override
	  public void run() {
	    try {
	      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
	      while (true) {
	        receiveString = tmpbuf.readUTF();
	        if (receiveString == null) {
	          System.out.println("상대방 연결이 종료되었습니다.");
	        } else {
	          System.out.println("상대방 : " + receiveString);
	          db.count(receiveString);
	        }
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}

	  }

}
