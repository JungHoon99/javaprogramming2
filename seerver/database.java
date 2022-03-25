import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	public database() {
		String user = "root";
		String password = "kmk20216*";
		String url = "jdbc:mysql://localhost:3306";
		try(
			Connection conn = DriverManager.getConnection(url, user, password);
		) {
			System.out.println(conn.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
