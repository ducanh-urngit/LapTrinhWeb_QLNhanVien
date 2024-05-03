package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection GetConnection()
	{
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/CongTy";    
		    String username = "root";
		    String password = "ducanh@1234";
		    
		    c = DriverManager.getConnection(jdbcUrl, username, password);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void CloseConnection(Connection conn) {
		try {
			if(conn != null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
