package dbOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DB_Connection;
import models.Users;

public class Users_dbops {
       public Users authenticate(String username,String password) {
    	   Users user = null;
    	   String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    	   try(Connection connection = DB_Connection.getConnection();
    			   PreparedStatement pst = connection.prepareStatement(sql)){
    		   pst.setString(1, username);
    		   pst.setString(2, password);
    		   ResultSet rSet = pst.executeQuery();
    		   if(rSet.next()) {
    			   user = new Users();
    			   user.setId(rSet.getInt("id"));
    			   user.setName(rSet.getString("username"));
    			   user.setPass(rSet.getString("password"));
    			   user.setRole(rSet.getString("role"));
    		   }
    	   }
    	   catch (Exception e) {
			e.printStackTrace();
		}
    	   return user;
       }
       
       public void addUser(Users u) {
    	   String sql = "INSERT INTO users(username,password,role) VALUES (?,?,?)";
    	   try(Connection connection = DB_Connection.getConnection();
    			   PreparedStatement pStatement = connection.prepareStatement(sql)){
    		   pStatement.setString(1, u.getName());
    		   pStatement.setString(2, u.getPass());
    		   pStatement.setString(3, u.getRole());
    		   pStatement.executeUpdate();
    	   }
    	   catch (Exception e) {
    		   e.printStackTrace();
		}
		
	}
}

