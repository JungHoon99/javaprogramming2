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
	
	public String count(String id) throws SQLException {
		String returnNum;
		String str = "Select count(*) from user where userid='"+id;
		ResultSet query = null;
		try {
			query = st.executeQuery(str+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(query.next()) {
			returnNum = query.getString(1);
		}
		
		return query.getString(1);
	}
}
