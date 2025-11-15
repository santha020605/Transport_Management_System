package uiClass;

import dbOperations.Booking_dbops;
import dbOperations.Vehicles_dbops;
import models.Vehicles;
import models.Bookings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;
public class Booking_frame extends JFrame{
	
	private String name;
	private String email;
	private long phone;
	private int id;
	
	private JComboBox<String> comboVehicles;
	private JTextField  txtTotal,txtId,txtName,txtPhone,txtMail,txtSeats,txtFrom,txtTo;
    private JButton btnBook, btnShow;
    private List<Vehicles> vList;
    
    public Booking_frame(String name,String email,long phone,int id) {
    	setTitle("Customer Bookings ");
    	setSize(700,400);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/resources/background_img.jpg"));
	    JLabel background = new JLabel(bgIcon);
	    setContentPane(background);
        
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        
        JLabel title = new JLabel("Welcome "+name+" Book Your Vehicle Now!!",SwingConstants.CENTER);
        title.setFont(new Font("Poppins",Font.BOLD,40));
        title.setForeground(Color.CYAN);
        title.setBounds(20,30,1300,30);
        background.add(title);
        
        JLabel labelId = new JLabel("Customer ID: ");
        labelId.setFont(new Font("Poppins",Font.BOLD,28));
        labelId.setForeground(Color.white);
        labelId.setBounds(90, 120, 300, 25);
        background.add(labelId);
        
        txtId = new JTextField();
        txtId.setEnabled(false);
        txtId.setText(String.valueOf(id));
        txtId.setFont(new Font("Poppins",Font.BOLD,15));
        txtId.setOpaque(false);
        txtId.setBounds(290,120,300,25);
        background.add(txtId);
        
        JLabel labelName = new JLabel("Customer : ");
        labelName.setFont(new Font("Poppins",Font.BOLD,28));
        labelName.setForeground(Color.white);
        labelName.setBounds(680, 120, 300, 25);
        background.add(labelName);
        
        txtName = new JTextField();
        txtName.setEnabled(false);
        txtName.setText(name);
        txtName.setFont(new Font("Poppins",Font.BOLD,15));
        txtName.setOpaque(false);
        txtName.setBounds(880,120,300,25);
        background.add(txtName);
        
        
        
        JLabel labelPhone = new JLabel("Phone : ");
        labelPhone.setFont(new Font("Poppins",Font.BOLD,28));
        labelPhone.setForeground(Color.WHITE);
        labelPhone.setBounds(680,210,300,25);
        background.add(labelPhone);
        
        txtPhone = new JTextField();
        txtPhone.setEnabled(false);
        txtPhone.setFont(new Font("Poppins",Font.BOLD,15));
        txtPhone.setText(String.valueOf(phone));
        txtPhone.setOpaque(false);
        txtPhone.setBounds(880,210,300,25);
        background.add(txtPhone);
        
        JLabel labelEmail = new JLabel("Mail : ");
        labelEmail.setFont(new Font("Poppins",Font.BOLD,28));
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setBounds(90,210,300,25);
        background.add(labelEmail);
        
        txtMail = new JTextField();
        txtMail.setEnabled(false);
        txtMail.setFont(new Font("Poppins",Font.BOLD,15));
        txtMail.setText(email);
        txtMail.setOpaque(false);
        txtMail.setBounds(290,210,300,25);
        background.add(txtMail);
        
        JLabel labelSelect = new JLabel("Select Vehicle : ");
        labelSelect.setFont(new Font("Poppins",Font.BOLD,28));
        labelSelect.setForeground(Color.WHITE);
        labelSelect.setBounds(390,290,300,25);
        background.add(labelSelect);
        
        comboVehicles = new JComboBox<String>();
        comboVehicles.setBackground(Color.DARK_GRAY);
        comboVehicles.setForeground(Color.CYAN);
        comboVehicles.addItem(email);
        comboVehicles.setBounds(620,290,300,30);
        background.add(comboVehicles);
        
        
        txtFrom = new JTextField();
        txtFrom.setEnabled(false);
        txtFrom.setFont(new Font("Poppins",Font.BOLD,15));
        txtFrom.setHorizontalAlignment(JTextField.CENTER);
//        txtFrom.setOpaque(false);
        txtFrom.setBackground(Color.DARK_GRAY);
        txtFrom.setForeground(Color.WHITE);
        txtFrom.setBounds(350,340,300,25);
        background.add(txtFrom);
        
        JLabel arrowJLabel = new JLabel("<-- TO -->");
        arrowJLabel.setBounds(655, 345, 200, 15);
        arrowJLabel.setFont(new Font("Poppins",Font.BOLD,15));
        arrowJLabel.setForeground(Color.WHITE);
        background.add(arrowJLabel);
        
        txtTo = new JTextField();
        txtTo.setEnabled(false);
        txtTo.setHorizontalAlignment(JTextField.CENTER);
        txtTo.setForeground(Color.CYAN);
        txtTo.setBackground(Color.DARK_GRAY);
        txtTo.setFont(new Font("Poppins",Font.BOLD,15));
//        txtTo.setOpaque(false);
        txtTo.setBounds(725,340,300,25);
        background.add(txtTo);
        
        JLabel labelSeats = new JLabel("Seats : ");
        labelSeats.setFont(new Font("Poppins",Font.BOLD,28));
        labelSeats.setForeground(Color.WHITE);
        labelSeats.setBounds(90,420,300,25);
        background.add(labelSeats);
        
        txtSeats = new JTextField();
        txtSeats.setOpaque(false);
        txtSeats.setBounds(290,420,300,25);
        background.add(txtSeats);
        
        JLabel labelPrice = new JLabel("Price : ");
        labelPrice.setFont(new Font("Poppins",Font.BOLD,28));
        labelPrice.setForeground(Color.WHITE);
        labelPrice.setBounds(680,420,300,25);
        background.add(labelPrice);
        
        txtTotal = new JTextField();
        txtTotal.setEnabled(false);
        txtTotal.setOpaque(false);
        txtTotal.setBounds(880,420,300,25);
        background.add(txtTotal);
        
        btnBook = new JButton("Book now");
		btnBook.setPreferredSize(new Dimension(150,50));
		btnBook.setForeground(Color.CYAN);
		btnBook.setBounds(350,590,200,45);
		btnBook.setBackground(Color.DARK_GRAY);
		background.add(btnBook);
		
		btnShow = new JButton("View My bookings");
		btnShow.setPreferredSize(new Dimension(150,50));
		btnShow.setForeground(Color.CYAN);
		btnShow.setBounds(760,590,200,45);
		btnShow.setBackground(Color.DARK_GRAY);
		background.add(btnShow);
		
		loadVehicles();
		
		comboVehicles.addActionListener(e ->{
			String selected = (String) comboVehicles.getSelectedItem();
			for(Vehicles v : vList) {
				if(v.getVehicleType().equals(selected)) {
					txtTotal.setText(String.valueOf(v.getPrice()));
					txtSeats.setText("1");
					txtFrom.setText(v.getFrom());
					txtTo.setText(v.getTo());
					break;
				}
			}
		});
		btnBook.addActionListener(e ->bookVehicle());
		btnShow.addActionListener(e -> new ViewBookingFrame(id).setVisible(true));
    }
    
    private void loadVehicles() {
    	Vehicles_dbops vehicles_dbops= new Vehicles_dbops();
    	vList = vehicles_dbops.getAll();
    	
    	comboVehicles.removeAllItems();
    	if(vList.isEmpty()) {
    		comboVehicles.addItem("No available Vehicles");
    		comboVehicles.setEnabled(false);
    		btnBook.setEnabled(false);
    	}
    	else {
    		for(Vehicles v : vList) {
    			if(v.getAvailability()) {
    				comboVehicles.addItem(v.getVehicleType());
    			}
    			
    		}
    	}
    }
    private void bookVehicle() {
    	if(comboVehicles.getSelectedItem()==null || txtTotal.getText().isEmpty()){
    		JOptionPane.showMessageDialog(this, "please select the vehicle");
    		return;
    	}
    		Bookings booking = new Bookings();
        	booking.setCustomerId(id);
        	booking.setVehicle_type(comboVehicles.getSelectedItem().toString());
        	booking.setCustomer_name(name);
        	booking.setSeats(Integer.parseInt(txtSeats.getText().trim()));
        	booking.setBookingDate(new Date());
        	booking.setFare(Double.parseDouble(txtTotal.getText())*(Integer.parseInt(txtSeats.getText().trim())));
        	booking.setStatus("Booked");
        	
        	Booking_dbops booking_dbops = new Booking_dbops();
        	boolean success = booking_dbops.createBooking(booking);
        	if(success) {
        		JOptionPane.showMessageDialog(this, "Booking Successfull !");
        		Vehicles_dbops vehicles_dbops = new Vehicles_dbops();
            	vehicles_dbops.updateVehicleAvailability(comboVehicles.getSelectedItem().toString(),booking.getStatus());
            	
        		
        	}
        	else {
        		JOptionPane.showMessageDialog(this, "Booking Unsuccessful please check details !");
        	}
    	
    	
   }
  
}
