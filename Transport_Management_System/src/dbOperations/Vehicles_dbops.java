package dbOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DB_Connection;
import models.Vehicles;

public class Vehicles_dbops {
	public void addVehicle(Vehicles v) {
		String sql = "INSERT INTO vehicles(type,price,available,from_,to_) VALUES(?,?,?,?,?)";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)){
			pStatement.setString(1, v.getVehicleType());
			pStatement.setDouble(2, v.getPrice());
			pStatement.setBoolean(3, v.getAvailability());
			pStatement.setString(4, v.getFrom());
			pStatement.setString(5, v.getTo());
			pStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Vehicles> getAll(){
		List<Vehicles> list = new ArrayList<Vehicles>();
		String sql = "SELECT * FROM vehicles";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet rSet = pStatement.executeQuery()){
			while(rSet.next()) {
				Vehicles v = new Vehicles();
				v.setId(rSet.getInt("id"));
				v.setVehicleType(rSet.getString("type"));
				v.setFrom(rSet.getString("from_"));
				v.setTo(rSet.getString("to_"));
				v.setPrice(rSet.getDouble("price"));
				v.setAvailability(rSet.getBoolean("available"));
				list.add(v);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateVehicle(Vehicles v) {
		String sql = "UPDATE vehicles SET type = ? , price = ?, available = ?,from_ = ?,to_ = ?, WHERE id = ?";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)){
			pStatement.setString(1, v.getVehicleType());
			pStatement.setDouble(2, v.getPrice());
			pStatement.setBoolean(3, v.getAvailability());
			pStatement.setString(4, v.getFrom());
			pStatement.setString(5, v.getTo());
			pStatement.setInt(4, v.getId());
			pStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteVehicle(int id) {
		String sql = "DELETE FROM vehicles WHERE id = ?";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sql)){
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateVehicleAvailability(String vehicle_type,String status) {
		boolean success;
		if(status.equals("Booked")) {
			success = false;
		}
		else {
			success = true;
		}
		String sql = "UPDATE vehicles SET available = ? WHERE type = ?";
		try(Connection connection = DB_Connection.getConnection();
				PreparedStatement psStatement = connection.prepareStatement(sql)){
			psStatement.setBoolean(1, success);
			psStatement.setString(2, vehicle_type);
			psStatement.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

