package dbOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import database.DB_Connection;
import models.Bookings;

public class Booking_dbops {
	public Boolean createBooking(Bookings b) {
		String sql = "INSERT INTO booking(customer_id,vehicle,fare,customer_name,status,seats,booking_date) VALUES(?,?,?,?,?,?,?)";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)){
			pStatement.setInt(1, b.getCustomerId());
			pStatement.setString(2, b.getVehicle_type());
			pStatement.setDouble(3, b.getFare());
			pStatement.setString(4, b.getCustomer_name());
			pStatement.setString(5, b.getStatus());
			pStatement.setInt(6, b.getSeats());
			pStatement.setDate(7, new java.sql.Date (b.getBookingDate().getTime()));
			pStatement.executeUpdate();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Bookings> getCustomerBookings(int customer_id){
		String sql = "SELECT * FROM booking WHERE customer_id = ?";
		List<Bookings> list = new ArrayList<Bookings>();
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement psStatement = connection.prepareStatement(sql)){
			psStatement.setInt(1, customer_id);
			ResultSet rs = psStatement.executeQuery();
			while(rs.next()) {
				Bookings b = new Bookings();
				b.setId(rs.getInt("id"));
				b.setVehicle_type(rs.getString("vehicle"));
				b.setSeats(rs.getInt("seats"));
				b.setFare(rs.getDouble("fare"));
				b.setBookingDate(rs.getDate("booking_date"));
				b.setStatus(rs.getString("status"));
				list.add(b);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Bookings> getAllBookings(){
		String sql = "SELECT * FROM booking inner join CUSTOMERS on customers.id = booking.customer_id";
		List<Bookings> list = new ArrayList<Bookings>();
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement psStatement = connection.prepareStatement(sql)){
			ResultSet rs = psStatement.executeQuery();
			while(rs.next()) {
				Bookings b = new Bookings();
				b.setId(rs.getInt("id"));
				b.setCustomer_name(rs.getString("customer_name"));
				b.setVehicle_type(rs.getString("vehicle"));
				b.setSeats(rs.getInt("seats"));
				b.setFare(rs.getDouble("fare"));
				b.setBookingDate(rs.getDate("booking_date"));
				b.setStatus(rs.getString("status"));
				list.add(b);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean cancelBooking(int id) {
		String sql = "UPDATE booking SET status = 'Cancelled' WHERE id = ?";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement psStatement = connection.prepareStatement(sql)){
			psStatement.setInt(1 ,id);
			return psStatement.executeUpdate() > 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
