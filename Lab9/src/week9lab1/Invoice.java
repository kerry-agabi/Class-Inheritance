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

public class Invoice {
	
	

	private JFrame frame;
	private JTextField jtxtQuantity;
	private JTable table;
	private JTextField jtxtDescription;
	private JTextField jtxtprice;
	private JTextField jtxtpayment;
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customers";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	private JTextField jtxtOrderID;
	public void updateTable() {
		connection = Invoice.ConnectDB();
		
		if (connection!=null) {
			
		
			String sql = "Select Quantity, Description, price, payment";
	
	
	try {
		
		connection = DriverManager.getConnection(

				DATABASE_URL, "root", "" );

		
		pst = connection.prepareStatement(sql);
		rs = pst.executeQuery();
		Object[] columnData = new Object[4];
		
		while(rs.next()) {
			
			 columnData[0] = rs.getString("Quantity");
			 columnData[1] = rs.getString("Description");
			 columnData[2] = rs.getString("price");
			 columnData[3] = rs.getString("payment");
			 
			 
			 model.addRow(columnData);
		}
			}
	
		catch(Exception e)
	{
				JOptionPane.showMessageDialog(null, e);
	}
		}
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice window = new Invoice();
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
	public Invoice() {
		initialize();
		
		connection = Invoice.ConnectDB();
		
		Object col[] = {"Quantity", "Description", "price", "payment"};
		
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
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setBounds(57, 141, 113, 35);
		frame.getContentPane().add(lblQuantity);
		
		jtxtQuantity = new JTextField();
		jtxtQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtQuantity.setBounds(253, 141, 204, 35);
		frame.getContentPane().add(jtxtQuantity);
		jtxtQuantity.setColumns(10);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String sql = "INSERT INTO Invoice (Quantity, Description, price, payment) VALUES (?,?,?,?)";
				
				
					pst = connection.prepareStatement(sql);
					
					pst. setString (1, jtxtQuantity.getText()) ;

					pst. setString (2, jtxtDescription.getText()) ;

					pst. setString (3, jtxtprice.getText()) ;
					
					pst. setString (4, jtxtpayment.getText()) ;
					
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, "Invoice Record has successfully been Inserted");
					
				}
				
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model .addRow(new Object[] {
						
						
					
					jtxtOrderID.getText(),	
					jtxtQuantity.getText(),

					jtxtDescription.getText(),

					jtxtprice.getText(),
					
					jtxtpayment.getText(),
					
				
						
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
		btnInsert.setBounds(28, 543, 129, 35);
		frame.getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(633, 11, 493, 401);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Order ID:", "Quantity", "Description", "Price", "Payment"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(252);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		scrollPane.setViewportView(table);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescription.setBounds(57, 201, 113, 35);
		frame.getContentPane().add(lblDescription);
		
		jtxtDescription = new JTextField();
		jtxtDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtDescription.setColumns(10);
		jtxtDescription.setBounds(253, 201, 204, 35);
		frame.getContentPane().add(jtxtDescription);
		
		JLabel lblPhoneNumber = new JLabel("Price:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNumber.setBounds(57, 264, 113, 35);
		frame.getContentPane().add(lblPhoneNumber);
		
		jtxtprice = new JTextField();
		jtxtprice.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtprice.setColumns(10);
		jtxtprice.setBounds(253, 264, 204, 35);
		frame.getContentPane().add(jtxtprice);
		
		JLabel lblAddress = new JLabel("Payment:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(57, 329, 113, 35);
		frame.getContentPane().add(lblAddress);
		
		jtxtpayment = new JTextField();
		jtxtpayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtpayment.setColumns(10);
		jtxtpayment.setBounds(253, 329, 204, 35);
		frame.getContentPane().add(jtxtpayment);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtQuantity.setText(null);
				jtxtDescription.setText(null);
				jtxtprice.setText(null);
				jtxtpayment.setText(null);
				
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(28, 606, 129, 35);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Invoice Database",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(228, 606, 129, 35);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("                INVOICE");
		lblNewLabel_1.setBounds(207, 0, 235, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					
					
					
				String sql = "Update invoice set OrderID= '"+jtxtOrderID.getText()+"',Quantity ='"+ jtxtQuantity.getText()+"' ,Description='"+jtxtDescription.getText()+"', price='"+jtxtprice.getText()+"',  payment='"+jtxtpayment.getText()+"'   ";
				
				
					pst = connection.prepareStatement(sql);
					
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, " Invoice has successfully been updated");
					
				}
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(228, 543, 129, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try 
				{
					
					
					
				String sql = "Delete from invoice where OrderID='"+jtxtOrderID.getText()+"'  ";
				
				
					pst = connection.prepareStatement(sql);
					
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, " Invoice Order has successfully been Deleted From The system");
					
				}
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(410, 543, 129, 35);
		frame.getContentPane().add(btnDelete);
		
		jtxtOrderID = new JTextField();
		jtxtOrderID.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtOrderID.setColumns(10);
		jtxtOrderID.setBounds(253, 79, 204, 35);
		frame.getContentPane().add(jtxtOrderID);
		
		JLabel lblOrderid = new JLabel("Order ID:");
		lblOrderid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrderid.setBounds(57, 79, 113, 35);
		frame.getContentPane().add(lblOrderid);
	}
}
