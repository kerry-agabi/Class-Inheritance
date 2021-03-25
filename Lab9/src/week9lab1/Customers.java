package GUI;

import java.awt.EventQueue;
import java . sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java . sql .Connection;

import java . sql .DriverManager;

import java . sql .PreparedStatement;

import java . sql .SQLException;

public class Customers {
	
	

	private JFrame frame;
	private JTextField jtxtFirstname;
	private JTable table;
	private JTextField jtxtLastname;
	private JTextField jtxtPhoneNumber;
	private JTextField jtxtAddress;
	private JTextField jtxtEircode;
	private JTextField jtxtGender;
	private JTextField jtxtEmailAddress;
	
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customers";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	private JTextField jtxtCustomerID;
	
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers window = new Customers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customers() {
		initialize();
		
		connection = Customers.ConnectDB();
		
		Object col[] = {"CustomerID", "FirstName", "LastName", "PhoneNumber", "Address", "Eircode", "Gender", "EmailAddress"};
		
		model.setColumnIdentifiers(col);
		
		
		
		
		
		
	}

	private static Connection ConnectDB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstname.setBounds(57, 128, 113, 35);
		frame.getContentPane().add(lblFirstname);
		
		jtxtFirstname = new JTextField();
		jtxtFirstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtFirstname.setBounds(253, 128, 204, 35);
		frame.getContentPane().add(jtxtFirstname);
		jtxtFirstname.setColumns(10);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String sql = "INSERT INTO customer (FirstName, LastName, PhoneNumber, Address, Eircode, Gender, EmailAddress) VALUES (?,?,?,?,?,?,?)";
				
				
					pst = connection.prepareStatement(sql);
					
					pst. setString (1, jtxtFirstname.getText()) ;

					pst. setString (2, jtxtLastname.getText()) ;

					pst. setString (3, jtxtPhoneNumber.getText()) ;
					
					pst. setString (4, jtxtAddress.getText()) ;
					
					pst. setString (5, jtxtEircode.getText()) ;
					
					pst. setString (6, jtxtGender.getText()) ;
					
					pst. setString (7, jtxtEmailAddress.getText()) ;
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, "Record has successfully been Inserted");
					
				}
				
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model .addRow(new Object[] {
						
						
					
				    jtxtCustomerID.getText(),
				
					jtxtFirstname.getText(),

					jtxtLastname.getText(),

					jtxtPhoneNumber.getText(),
					
					jtxtAddress.getText(),
					
					jtxtEircode.getText(),
					
					jtxtGender.getText(),
					
					jtxtEmailAddress.getText(),
						
				});
				
				if(table.getSelectedRow()== -1) {
					if (table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "New Customer Has been Added" , "Customer Database",
						JOptionPane.OK_OPTION);
					}
				}
			}
			
			
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBounds(41, 655, 129, 35);
		frame.getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(514, 11, 935, 472);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Firstname", "Lastname", "Phone Number", "Address", "Eircode", "Gender", "Email Address"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(191);
		table.getColumnModel().getColumn(4).setPreferredWidth(221);
		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastname.setBounds(57, 187, 113, 35);
		frame.getContentPane().add(lblLastname);
		
		jtxtLastname = new JTextField();
		jtxtLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtLastname.setColumns(10);
		jtxtLastname.setBounds(253, 187, 204, 35);
		frame.getContentPane().add(jtxtLastname);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNumber.setBounds(57, 248, 113, 35);
		frame.getContentPane().add(lblPhoneNumber);
		
		jtxtPhoneNumber = new JTextField();
		jtxtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtPhoneNumber.setColumns(10);
		jtxtPhoneNumber.setBounds(253, 248, 204, 35);
		frame.getContentPane().add(jtxtPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(57, 307, 113, 35);
		frame.getContentPane().add(lblAddress);
		
		jtxtAddress = new JTextField();
		jtxtAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtAddress.setColumns(10);
		jtxtAddress.setBounds(253, 307, 204, 35);
		frame.getContentPane().add(jtxtAddress);
		
		JLabel lblEircode = new JLabel("Eircode:");
		lblEircode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEircode.setBounds(57, 369, 113, 35);
		frame.getContentPane().add(lblEircode);
		
		jtxtEircode = new JTextField();
		jtxtEircode.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtEircode.setColumns(10);
		jtxtEircode.setBounds(253, 369, 204, 35);
		frame.getContentPane().add(jtxtEircode);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(57, 431, 113, 35);
		frame.getContentPane().add(lblGender);
		
		jtxtGender = new JTextField();
		jtxtGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtGender.setColumns(10);
		jtxtGender.setBounds(253, 431, 204, 35);
		frame.getContentPane().add(jtxtGender);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtFirstname.setText(null);
				jtxtLastname.setText(null);
				jtxtPhoneNumber.setText(null);
				jtxtAddress.setText(null);
				jtxtEircode.setText(null);
				jtxtGender.setText(null);
				jtxtEmailAddress.setText(null);
				jtxtCustomerID.setText(null);
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(207, 715, 129, 35);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Customer's Database",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(380, 715, 129, 35);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("                     CUSTOMER");
		lblNewLabel_1.setBounds(207, 0, 235, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					
					
					
				String sql = "Update customer set CustomerID= '"+jtxtCustomerID.getText()+"',FirstName ='"+ jtxtFirstname.getText()+"' ,LastName='"+jtxtLastname.getText()+"', Address='"+jtxtAddress.getText()+"',  PhoneNumber='"+jtxtPhoneNumber.getText()+"',EmailAddress='"+jtxtEmailAddress.getText()+"'where CustomerID='"+jtxtCustomerID.getText()+"'   ";
				
				
					pst = connection.prepareStatement(sql);
					
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, " Customer's Record has successfully been updated");
					
				}
				
				
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(207, 655, 129, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					
					
					
				String sql = "Delete from customer where CustomerID='"+jtxtCustomerID.getText()+"'  ";
				
				
					pst = connection.prepareStatement(sql);
					
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, " Customer's Record has successfully been Deleted From The system");
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(380, 655, 129, 35);
		frame.getContentPane().add(btnDelete);
		
		jtxtEmailAddress = new JTextField();
		jtxtEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtEmailAddress.setColumns(10);
		jtxtEmailAddress.setBounds(253, 490, 204, 35);
		frame.getContentPane().add(jtxtEmailAddress);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAddress.setBounds(57, 490, 113, 35);
		frame.getContentPane().add(lblEmailAddress);
		
		jtxtCustomerID = new JTextField();
		jtxtCustomerID.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtCustomerID.setColumns(10);
		jtxtCustomerID.setBounds(253, 57, 204, 35);
		frame.getContentPane().add(jtxtCustomerID);
		
		JLabel lblCustomerID = new JLabel("CustomerID:");
		lblCustomerID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustomerID.setBounds(57, 57, 113, 35);
		frame.getContentPane().add(lblCustomerID);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				try {
					
					String sql = "Select * from product";
					DefaultTableModel model = new 	DefaultTableModel ();
					ResultSet rs = pst.executeQuery();
					  table.setModel(model);
				}	
				
					catch (Exception ev) {
						
						ev.printStackTrace();
					}
				
				
				
				
			}
			

			 
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisplay.setBounds(41, 715, 129, 35);
		frame.getContentPane().add(btnDisplay);
	}
}
