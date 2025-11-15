package database;
import java.sql.Connection;

public class demo {

	public static void main(String[] args) {
		
		Connection con = DB_Connection.getConnection();
		if(con!=null) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}

}
