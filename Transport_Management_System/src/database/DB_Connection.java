package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	private static final String url = "jdbc:mysql://localhost:3306/transportDb";
	private static final String user = "root";
	private static final String password = "8270320054";
	
	public static Connection getConnection() {
		try {
		   return DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
