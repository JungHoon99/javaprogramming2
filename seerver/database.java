import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	Statement st;
	public database() throws SQLException {
		String user = "root";
		String password = "kmk20216*";
		String url = "jdbc:mysql://localhost:3306/ticketmoa";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		st = conn.createStatement();
		System.out.println(conn.toString());
	}
	
	public void select() throws SQLException {
		String str = "Select * from user";
		ResultSet query = st.executeQuery(str+";");
		
		while(query.next()) {
			System.out.println(query.getString(2));
		}
	}
}
