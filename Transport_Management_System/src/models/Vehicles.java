package models;


public class Vehicles {
	private int id;
	private String vehicleType;
	private String from;
	private String to;
	private double price;
	private boolean available;
	
	public Vehicles() {
		
	}
	public Vehicles(String vehicleType,String from,String to,double price,boolean available) {
		this.vehicleType = vehicleType;
		this.price = price;
		this.from = from;
		this.to = to;
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Boolean getAvailability() {
		return available;
	}
	public void setAvailability(boolean available) {
		this.available = available;
	}

}

