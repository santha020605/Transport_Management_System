package uiClass;


import dbOperations.Vehicles_dbops;
import models.Vehicles;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Admin_frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtType,txtFrom,txtTo,txtPrice,txtAvailability;
	
	public Admin_frame() {
		setTitle("ADMIN CORNER");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/background_img.jpg"));
		JLabel background = new JLabel(imageIcon);
		background.setLayout(new GridBagLayout());
		background.setPreferredSize(new Dimension(600,400));
		setContentPane(background);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(1100,650));
		panel.setOpaque(false);
		model = new DefaultTableModel(new String[] {"ID","TYPE","PRICE","AVAILABILITY","From","To"},0);
		table = new JTable(model);
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(Object.class);
		renderer.setOpaque(false);
		table.setRowHeight(25);
		table.setForeground(Color.white);
		table.setFont(new Font("Poppins",Font.BOLD,16));
		table.setOpaque(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(700,350));
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		panel.add(scrollPane,BorderLayout.CENTER);
		
		JPanel panelForm = new JPanel(new GridLayout(8,10,10,10));
		txtType = new JTextField();
		txtType.setForeground(Color.white);
		txtType.setOpaque(false);
		txtPrice = new JTextField();
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setOpaque(false);
		txtAvailability = new JTextField();
		txtAvailability.setOpaque(false);
		txtAvailability.setForeground(Color.white);
		txtFrom = new JTextField();
		txtFrom.setForeground(Color.white);
		txtFrom.setOpaque(false);
		txtTo = new JTextField();
		txtTo.setForeground(Color.white);
		txtTo.setOpaque(false);
		panelForm.setOpaque(false);
		
		JLabel typeJLabel = new JLabel("Type");
		typeJLabel.setFont(new Font("Poppins",Font.BOLD,16));
		typeJLabel.setForeground(Color.WHITE);
		panelForm.add(typeJLabel);
		panelForm.add(txtType);
		
		JLabel priceJLabel = new JLabel("Price");
		priceJLabel.setFont(new Font("Poppins",Font.BOLD,16));
		priceJLabel.setForeground(Color.WHITE);
		panelForm.add(priceJLabel);
		panelForm.add(txtPrice);
		
		
		JLabel avaJLabel = new JLabel("Availability");
		avaJLabel.setFont(new Font("Poppins",Font.BOLD,16));
		avaJLabel.setForeground(Color.WHITE);
		panelForm.add(avaJLabel);
		panelForm.add(txtAvailability);
		
		JLabel fromJLabel = new JLabel("From");
		fromJLabel.setFont(new Font("Poppins",Font.BOLD,16));
		fromJLabel.setForeground(Color.WHITE);
		panelForm.add(fromJLabel);
		
		JLabel toJLabel = new JLabel("To");
		toJLabel.setFont(new Font("Poppins",Font.BOLD,16));
		toJLabel.setForeground(Color.WHITE);
		panelForm.add(toJLabel);
		
		
		panelForm.add(txtFrom);
		panelForm.add(txtTo);
		
		JButton addButton = new JButton("ADD VEHICLE");
		addButton.setForeground(Color.WHITE);
		addButton.setBackground(Color.DARK_GRAY);
		JButton deButton = new JButton("DELETE VEHICLE");
		deButton.setForeground(Color.WHITE);
		deButton.setBackground(Color.DARK_GRAY);
		JButton updateButton = new JButton("UPDATE VEHICLE");
		updateButton.setForeground(Color.WHITE);
		updateButton.setBackground(Color.DARK_GRAY);
		
		JButton BookingsButton = new JButton("SHOW BOOKINGS");
		BookingsButton.setForeground(Color.WHITE);
		BookingsButton.setBackground(Color.DARK_GRAY);
		
		panelForm.add(addButton);
		panelForm.add(deButton);
		panelForm.add(updateButton);
		panelForm.add(BookingsButton);
		panel.add(panelForm,BorderLayout.SOUTH);
		background.add(panel);
		moveOn(txtType, txtPrice);
		moveOn(txtPrice, txtAvailability);
		
		loadVehicles();
		
		addButton.addActionListener(e ->{
			try {
				String type = txtType.getText();
				String from = txtFrom.getText();
				String to = txtTo.getText();
				double price = Double.parseDouble(txtPrice.getText());
				Boolean availability = Boolean.parseBoolean(txtAvailability.getText());
				
				Vehicles vehicle = new Vehicles();
				vehicle.setVehicleType(type);
				vehicle.setPrice(price);
				vehicle.setFrom(from);
				vehicle.setTo(to);
				vehicle.setAvailability(availability);
				
				Vehicles_dbops vehicles_dbops = new Vehicles_dbops();
				vehicles_dbops.addVehicle(vehicle);
				loadVehicles();
			    JOptionPane.showMessageDialog(this, "New vehicle added successfully!");
			}
			catch (Exception t) {
				JOptionPane.showMessageDialog(this, "Invalid input ,please check values.");
			}
		});
		deButton.addActionListener(e ->{
			int selectRow = table.getSelectedRow();
			if(selectRow>=0) {
				int vehicleId = (int) model.getValueAt(selectRow, 0);
				Vehicles_dbops vehicles_dbops = new Vehicles_dbops();
				vehicles_dbops.deleteVehicle(vehicleId);
				loadVehicles();
				
				JOptionPane.showMessageDialog(this, "Vehicle was deleted !");
			}
			else {
				JOptionPane.showMessageDialog(this, "Please select the vehicle.");	
			}
		});
		updateButton.addActionListener(e ->{
			String type = txtType.getText();
			String from = txtFrom.getText();
			String to = txtTo.getText();
			Double price = Double.parseDouble(txtPrice.getText());
			Boolean availability = Boolean.parseBoolean(txtAvailability.getText());
			
			int selectRow = table.getSelectedRow();
			if(selectRow==1) {
				int vehicleId = (int) model.getValueAt(selectRow, 0);
				Vehicles_dbops vehicles_dbops = new Vehicles_dbops();
				Vehicles vehicle = new Vehicles();
				vehicle.setAvailability(availability);
				vehicle.setId(vehicleId);
				vehicle.setPrice(price);
				vehicle.setFrom(from);
				vehicle.setTo(to);
				vehicle.setVehicleType(type);
				vehicles_dbops.updateVehicle(vehicle);
				loadVehicles();
				JOptionPane.showMessageDialog(this, "Vehicle was Updated !");
			}
			else {
				JOptionPane.showMessageDialog(this, "Please select the vehicle.");	
			}
			
		});
		BookingsButton.addActionListener(e-> new ViewBookingFrame().setVisible(true));
	}
	private void loadVehicles() {
		model.setRowCount(0);
		Vehicles_dbops daoVehicles_dbops = new Vehicles_dbops();
		List<Vehicles> list = daoVehicles_dbops.getAll();
		
		for(Vehicles v:list) {
			model.addRow(new Object[] {v.getId(),v.getVehicleType(),v.getPrice(),v.getAvailability(),v.getFrom(),v.getTo()});
		}
	}
	private void moveOn(JTextField from,JTextField to) {
		from.addActionListener(e ->
			to.requestFocus()
		);
	}

}

