package uiClass;

import dbOperations.Users_dbops;
import dbOperations.Customers_dbops;
import models.Customers;
import models.Users;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
public class Login_frame extends JFrame{
	private JTextField txtUsernameField,txtUsernameField2,txtUsernameField3,txtUsernameField4;
	private JPasswordField txtJPasswordField,txtJPasswordField2;
	private JButton btnLogin,btnLogin2,btnLogin3;
	public Login_frame() {
		setTitle("Santxa Transports Management");
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		 ImageIcon bgIcon = new ImageIcon(getClass().getResource("/resources/background_img.jpg"));
	     JLabel background = new JLabel(bgIcon);
	     background.setLayout(new GridBagLayout());
	     setContentPane(background);

    	JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(20, 20, 20, 20);
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    JLabel headline = new JLabel("ADMIN Login");
	    headline.setFont(new Font("Poppins",Font.BOLD,20));
		headline.setForeground(Color.CYAN);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(headline,gbc);
		JLabel labelUsername = new JLabel("User Name ");
		labelUsername.setFont(new Font("Poppins",Font.BOLD,16));
		labelUsername.setForeground(Color.WHITE);
		gbc.gridx = 0; gbc.gridy = 1;
	    panel.add(labelUsername, gbc);
	    
	    txtUsernameField = new JTextField(20);
	    txtUsernameField.setForeground(Color.WHITE);
	    txtUsernameField.setOpaque(false);
	    txtUsernameField.setPreferredSize(new Dimension(200,30));
	    gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtUsernameField, gbc);

		
		JLabel labelPassword = new JLabel("Password ");
		labelPassword.setFont(new Font("Poppins",Font.BOLD,16));
		labelPassword.setForeground(Color.white);
		gbc.gridx = 0; gbc.gridy = 2;
        panel.add(labelPassword, gbc);
		txtJPasswordField = new JPasswordField();
		txtJPasswordField.setForeground(Color.WHITE);
		txtJPasswordField.setOpaque(false);
		txtJPasswordField.setPreferredSize(new Dimension(200,30));
		gbc.gridx = 1; gbc.gridy = 2;
        panel.add(txtJPasswordField, gbc);
		
		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(200,30));
		btnLogin.setForeground(Color.CYAN);
		btnLogin.setBackground(Color.DARK_GRAY);
		gbc.gridx = 1; gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(new JLabel());
        panel.add(btnLogin, gbc);
        
        JLabel headline2 = new JLabel("Customer Login / Register");
        headline2.setFont(new Font("Poppins",Font.BOLD,25));
		headline2.setForeground(Color.CYAN);
		gbc.gridx = 4; gbc.gridy = 0;
	    panel.add(headline2, gbc);
        
		JLabel labelUsername2 = new JLabel("Name");
		labelUsername2.setFont(new Font("Poppins",Font.BOLD,16));
		labelUsername2.setForeground(Color.WHITE);
		gbc.gridx = 3; gbc.gridy = 1;
	    panel.add(labelUsername2, gbc);
	    
	    txtUsernameField2 = new JTextField(20);
	    txtUsernameField2.setForeground(Color.WHITE);
	    txtUsernameField2.setOpaque(false);
	    txtUsernameField2.setPreferredSize(new Dimension(200,30));
	    gbc.gridx = 4; gbc.gridy = 1;
        panel.add(txtUsernameField2, gbc);

		
		JLabel labelPassword2 = new JLabel("Email");
		labelPassword2.setFont(new Font("Poppins",Font.BOLD,16));
		labelPassword2.setForeground(Color.white);
		gbc.gridx = 3; gbc.gridy = 2;
        panel.add(labelPassword2, gbc);
		txtUsernameField3 = new JTextField();
		txtUsernameField3.setForeground(Color.WHITE);
		txtUsernameField3.setOpaque(false);
		txtUsernameField3.setPreferredSize(new Dimension(200,30));
		gbc.gridx = 4; gbc.gridy = 2;
        panel.add(txtUsernameField3, gbc);
		
        JLabel labelphone = new JLabel("Phone");
		labelphone.setFont(new Font("Poppins",Font.BOLD,16));
		labelphone.setForeground(Color.white);
		gbc.gridx = 3; gbc.gridy = 3;
        panel.add(labelphone, gbc);
		txtUsernameField4 = new JTextField();
		txtUsernameField4.setForeground(Color.WHITE);
		txtUsernameField4.setOpaque(false);
		txtUsernameField4.setPreferredSize(new Dimension(200,30));
		gbc.gridx = 4; gbc.gridy = 3;
        panel.add(txtUsernameField4, gbc);
		btnLogin2 = new JButton("Login / Register");
		btnLogin2.setPreferredSize(new Dimension(200,30));
		btnLogin2.setForeground(Color.CYAN);
		btnLogin2.setBackground(Color.DARK_GRAY);
		gbc.gridx = 4; gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(new JLabel());
        panel.add(btnLogin2, gbc);
		
		
        background.add(panel, gbc);
		moveOn(txtUsernameField, txtJPasswordField);
		moveOn(txtUsernameField2, txtUsernameField3);
		moveOn(txtUsernameField3, txtUsernameField4);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsernameField.getText();
				String password = new String(txtJPasswordField.getPassword());
				
				Users_dbops users_dbops = new Users_dbops();
				Users user = users_dbops.authenticate(username,password);
				if(user!=null) {
					JOptionPane.showMessageDialog(Login_frame.this,"Welcome "+user.getRole()," Login Success ",JOptionPane.INFORMATION_MESSAGE);
					if(user.getRole().equalsIgnoreCase("admin")) {
						new Admin_frame().setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(Login_frame.this,"Inavlid Username or Password !","Login Failed",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name  = txtUsernameField2.getText();
				String email = txtUsernameField3.getText();
				long phone = Long.parseLong(txtUsernameField4.getText());
				
				Customers_dbops customers_dbops = new Customers_dbops();
				Customers customers = customers_dbops.authenticate(email,phone);
				try {
				if(customers!=null) {
					JOptionPane.showMessageDialog(Login_frame.this,"Welcome "+customers.getName()," Login Success ",JOptionPane.INFORMATION_MESSAGE);
					new Booking_frame(name,email,phone,customers.getId()).setVisible(true);
				} 
				else {
					Customers customer = new Customers(name,phone,email);
					Customers_dbops customers_dbops2 = new Customers_dbops();
					customers_dbops2.addCustomers(customer);
					JOptionPane.showMessageDialog(Login_frame.this,"Welcome our New customer "+customer.getName()," Register Success and Book your first Journeyyy!",JOptionPane.INFORMATION_MESSAGE);
					new Booking_frame(name,email,phone,customer.getId()).setVisible(true);
//					
				}
				}
				catch(Exception s) {
					s.printStackTrace();
					JOptionPane.showMessageDialog(Login_frame.this,"Inavlid Entry","Login Failed",JOptionPane.ERROR_MESSAGE);
				} 
					
				
			}
		});
	}
	private void moveOn(JTextField from,JTextField to) {
		from.addActionListener(e ->
			to.requestFocus()
		);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(()->{
			new Login_frame().setVisible(true);
		});

	}

}

