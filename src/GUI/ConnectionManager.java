package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static String serverName = "jdbc:mysql://stusql.dcs.shef.ac.uk/team018";
	private static String username = "team018";
	private static String pwd = "7854a03f";
	private static Connection connection;
	private static String urlString;
	
	public static Connection getConnection() throws SQLException {
		try {
			connection = DriverManager.getConnection(serverName, username, pwd);
			System.out.println("Conn made");
		}catch(SQLException ex) {
			System.out.println("failed to make conn");
			ex.printStackTrace();
		}finally {
//			connection.close();
			System.out.println("conn closed");
		}
		return connection;
	}
	
	
}