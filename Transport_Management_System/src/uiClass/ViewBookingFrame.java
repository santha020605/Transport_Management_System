package uiClass;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import dbOperations.Vehicles_dbops;
import models.Vehicles;

import dbOperations.Booking_dbops;
import models.Bookings;

public class ViewBookingFrame extends JFrame{
	
	private JTable table;
	private JButton btnCancel;
	private DefaultTableModel model;
	private int selected = -1;
	private int customer_id ;
	private String vehicle;
	public ViewBookingFrame(int customer_id) {
		this.customer_id = customer_id;
		
		setTitle("My Bookings");
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		model = new DefaultTableModel(new String[] {"ID","VEHICLE","SEATS","PRICE","DATE","STATUS"},0) {
			@Override
			public boolean isCellEditable(int row,int columns) {
				return false;
			}
		};
		table = new JTable(model);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.CYAN);
		table.setFont(new Font("Poppins",Font.BOLD,16));
		JScrollPane sp = new JScrollPane(table);
		sp.setBackground(Color.DARK_GRAY);
		add(sp,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		btnCancel = new JButton("Cancel booking");
		btnCancel.setEnabled(false);
		btnCancel.setForeground(Color.CYAN);
		btnCancel.setBackground(Color.DARK_GRAY);
		panel.add(btnCancel);
		add(panel,BorderLayout.SOUTH);
		loadBookings();
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				if(row != -1) {
					selected = Integer.parseInt(table.getValueAt(row, 0).toString());
					String status = table.getValueAt(row, 5).toString();
					vehicle = table.getValueAt(row, 1).toString();
					btnCancel.setEnabled(status.equalsIgnoreCase("Booked"));
				}
			}
		});
		
		btnCancel.addActionListener(e -> cancelBooking());

		
	}
	
	private void loadBookings(){
		Booking_dbops booking_dbops = new Booking_dbops();
		List<Bookings> list = booking_dbops.getCustomerBookings(customer_id);
		
		model.setRowCount(0);
		for(Bookings b : list) {
			model.addRow(new Object[] {
					b.getId(),
					b.getVehicle_type(),
					b.getSeats(),
					b.getFare(),
					b.getBookingDate(),
					b.getStatus()
			});
		}
		
	}
	private void loadAllBookings(){
		Booking_dbops booking_dbops = new Booking_dbops();
		List<Bookings> list = booking_dbops.getAllBookings();
		
		model.setRowCount(0);
		for(Bookings b : list) {
			model.addRow(new Object[] {
					b.getId(),
					b.getCustomer_name(),
					b.getVehicle_type(),
					b.getSeats(),
					b.getFare(),
					b.getBookingDate(),
					b.getStatus()
			});
		}
		
	}
	
	private void cancelBooking() {
		if(selected == -1) {
			return ;
		}
		
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to cancel Booking");
				if(confirm == JOptionPane.YES_OPTION) {
				  Booking_dbops booking_dbops = new Booking_dbops();
				  if(booking_dbops.cancelBooking(selected)) {
					  JOptionPane.showMessageDialog(this, "Booking cancelled");
					  loadBookings();
					  btnCancel.setEnabled(false);
					  Vehicles_dbops vehicles_dbops = new Vehicles_dbops();
					  vehicles_dbops.updateVehicleAvailability(vehicle,"UnBooked");
				  }
				  else {
					  JOptionPane.showMessageDialog(this, "Failed to cancel booking");
				  }
				}
		
		
	}
	
	public ViewBookingFrame() {
		setTitle("Bookings");
		setSize(600,400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		model = new DefaultTableModel(new String[] {"ID","NAME","VEHICLE","SEATS","PRICE","DATE","STATUS"},0) {
			@Override
			public boolean isCellEditable(int row,int columns) {
				return false;
			}
		};
		table = new JTable(model);
		table.editingCanceled(null);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.CYAN);
		table.setFont(new Font("Poppins",Font.BOLD,16));
		JScrollPane sp = new JScrollPane(table);
		add(sp,BorderLayout.CENTER);
		
		loadAllBookings();
	}

	
}
