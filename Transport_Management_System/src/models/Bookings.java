package models;
import java.util.Date;

public class Bookings {
	private int id;
	private int customerId;
	private int vehicleId;
	private String status;
	private String customer_name;
	private String vehicle_type;
	private int seats;
	private double fare;
	private Date bookingDate;
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public Bookings() {
		
	}
	public Bookings(int customerId,int vehicleId,int seats,double fare) {
		this.customerId = customerId;
		this.fare = fare;
		this.seats = seats;
		this.vehicleId = vehicleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setvehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Double getFare() {
		return fare;
	}
	public int getSeats() {
		return seats;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

}

