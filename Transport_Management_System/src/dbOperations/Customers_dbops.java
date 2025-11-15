package dbOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DB_Connection;
import models.Customers;

public class Customers_dbops {
	public Customers addCustomers(Customers c) {
		String sql = "INSERT INTO customers(name,email,phone) VALUES (? ,? ,?)";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
			pStatement.setString(1, c.getName());
			pStatement.setLong(3, c.getPhone());
			pStatement.setString(2, c.getEmail());
			pStatement.executeUpdate();
			
			ResultSet rSet = pStatement.getGeneratedKeys();
			if(rSet.next()) {
				c.setID(rSet.getInt(1));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	  public Customers authenticate(String email,long phone) {
   	   Customers customer = null;
   	   String sql = "SELECT * FROM customers WHERE email = ? AND phone = ?";
   	   try(Connection connection = DB_Connection.getConnection();
   			   PreparedStatement pst = connection.prepareStatement(sql)){
   		   pst.setString(1, email);
   		   pst.setLong(2, phone);
   		   ResultSet rSet = pst.executeQuery();
   		   if(rSet.next()) {
   			   customer = new Customers();
   			   customer.setID(rSet.getInt("id"));
   			   customer.setName(rSet.getString("name"));
   			   customer.setEmail(rSet.getString("email"));
   			   customer.setPhone(rSet.getLong("phone"));
   		   }
   	   }
   	   catch (Exception e) {
			e.printStackTrace();
		}
   	   return customer;
      }

}
