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

	public class Product {
		
		

		private JFrame frame;
		private JTextField jtxtProductName;
		private JTable table;
		private JTextField jtxtUnitPrice;
		private JTextField jtxtStock;
		private JTextField jtxtStatus;
		private JTextField jtxtProductID;
		
		final String DATABASE_URL = "jdbc:mysql://localhost/customers";
		
		
		
		Connection connection = null;
		
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		DefaultTableModel model = new 	DefaultTableModel ();

		/**
		 * Launch the application.
		 */
		int i=0;
	
		public void updateTable() {
			connection = Product.ConnectDB();
			
			if (connection!=null) {
				
			
				String sql = "Select ProductName, UnitPrice, Stock,";
		
		
		try {
			
			connection = DriverManager.getConnection(

					DATABASE_URL, "root", "" );

			
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			Object[] columnData = new Object[6];
			
			while(rs.next()) {
				
				 columnData[0] = rs.getString("ProductName");
				 columnData[1] = rs.getString("UnitPrice");
				 columnData[2] = rs.getString("Stock");
				 columnData[3] = rs.getString("Status");
			
				 
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
						Product window = new Product();
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
		public Product() {
			initialize();
			
			connection = Product.ConnectDB();
			
			Object col[] = {"ProductID", "ProductName", "UnitPrice", "Stock", "Status"};
			
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
			
			JLabel lblProductName = new JLabel("Product Name:");
			lblProductName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblProductName.setBounds(57, 155, 113, 35);
			frame.getContentPane().add(lblProductName);
			
			jtxtProductName = new JTextField();
			jtxtProductName.setFont(new Font("Tahoma", Font.BOLD, 11));
			jtxtProductName.setBounds(253, 155, 204, 35);
			frame.getContentPane().add(jtxtProductName);
			jtxtProductName.setColumns(10);
			
			JButton btnInsert = new JButton("INSERT");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try 
					{
						
						connection = DriverManager.getConnection(

								DATABASE_URL, "root", "" );
						
					String sql = "INSERT INTO product (ProductName, UnitPrice, Stock, Status) VALUES (?,?,?,?)";
					
					
						pst = connection.prepareStatement(sql);
						
						pst. setString (1, jtxtProductName.getText()) ;

						pst. setString (2, jtxtUnitPrice.getText()) ;

						pst. setString (3, jtxtStock.getText()) ;
						
						pst. setString (4, jtxtStatus.getText()) ;
						
						
						
						pst.execute();
						
						rs.close();
						pst.close();
						
						i = pst.executeUpdate();

					}
					catch(Exception ev)
					{
						JOptionPane.showMessageDialog(null, "New Product has successfully been Inserted");
						
					}
					
					
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model .addRow(new Object[] {
							
							
						
						jtxtProductID.getText(),	
						jtxtProductName.getText(),

						jtxtUnitPrice.getText(),

						jtxtStock.getText(),
						
						jtxtStatus.getText(),
						
						
					});
					
					if(table.getSelectedRow()== -1) {
						if (table.getRowCount()==0) {
							JOptionPane.showMessageDialog(null, "New Product Has been Added" , "Product Database",
							JOptionPane.OK_OPTION);
						}
					}
				}
				
				
				
			});
			btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnInsert.setBounds(41, 523, 129, 35);
			frame.getContentPane().add(btnInsert);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(633, 11, 493, 401);
			frame.getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ProductID", "Product Name", "Unit Price", "Stock", "Status"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(115);
			table.getColumnModel().getColumn(1).setPreferredWidth(142);
			table.getColumnModel().getColumn(2).setPreferredWidth(105);
			table.getColumnModel().getColumn(3).setPreferredWidth(58);
			table.getColumnModel().getColumn(4).setPreferredWidth(114);
			scrollPane.setViewportView(table);
			
			JLabel lblUnitPrice = new JLabel("Unit Price:");
			lblUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUnitPrice.setBounds(57, 214, 113, 35);
			frame.getContentPane().add(lblUnitPrice);
			
			jtxtUnitPrice = new JTextField();
			jtxtUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
			jtxtUnitPrice.setColumns(10);
			jtxtUnitPrice.setBounds(253, 214, 204, 35);
			frame.getContentPane().add(jtxtUnitPrice);
			
			JLabel lblStock = new JLabel("Stock:");
			lblStock.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblStock.setBounds(57, 273, 113, 35);
			frame.getContentPane().add(lblStock);
			
			jtxtStock = new JTextField();
			jtxtStock.setFont(new Font("Tahoma", Font.BOLD, 11));
			jtxtStock.setColumns(10);
			jtxtStock.setBounds(253, 273, 204, 35);
			frame.getContentPane().add(jtxtStock);
			
			JLabel lblStatus = new JLabel("Status:");
			lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblStatus.setBounds(57, 327, 113, 35);
			frame.getContentPane().add(lblStatus);
			
			jtxtStatus = new JTextField();
			jtxtStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
			jtxtStatus.setColumns(10);
			jtxtStatus.setBounds(253, 327, 204, 35);
			frame.getContentPane().add(jtxtStatus);
			
			JButton btnReset = new JButton("RESET");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					jtxtProductName.setText(null);
					jtxtUnitPrice.setText(null);
					jtxtStock.setText(null);
					jtxtStatus.setText(null);
				
				}
			});
			btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnReset.setBounds(207, 585, 129, 35);
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
			btnExit.setBounds(373, 585, 129, 35);
			frame.getContentPane().add(btnExit);
			
			JLabel lblNewLabel_1 = new JLabel("                    PRODUCT");
			lblNewLabel_1.setBounds(207, 0, 235, 25);
			frame.getContentPane().add(lblNewLabel_1);
			
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try 
					{
						
						
						
					String sql = "Update product set ProductID= '"+jtxtProductID.getText()+"',ProductName ='"+ jtxtProductName.getText()+"' ,UnitPrice='"+jtxtUnitPrice.getText()+"', Stock='"+jtxtStock.getText()+"',  Status='"+jtxtStatus.getText()+"'   ";
					
					
						pst = connection.prepareStatement(sql);
						
						
						pst.execute();
						
						rs.close();
						pst.close();
						
						i = pst.executeUpdate();

					}
					catch(Exception ev)
					{
						JOptionPane.showMessageDialog(null, " Product record has successfully been updated");
						
					}
					
					
					
					
				}
			});
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnUpdate.setBounds(207, 523, 129, 35);
			frame.getContentPane().add(btnUpdate);
			
			JButton btnDelete = new JButton("DELETE");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try 
					{
						
						
						
					String sql = "Delete from product where ProductID='"+jtxtProductID.getText()+"'  ";
					
					
						pst = connection.prepareStatement(sql);
						
						
						pst.execute();
						
						rs.close();
						pst.close();
						
						i = pst.executeUpdate();

					}
					catch(Exception ev)
					{
						JOptionPane.showMessageDialog(null, " Product has successfully been Deleted From The system");
						
					}
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnDelete.setBounds(373, 523, 129, 35);
			frame.getContentPane().add(btnDelete);
			
			jtxtProductID = new JTextField();
			jtxtProductID.setFont(new Font("Tahoma", Font.BOLD, 11));
			jtxtProductID.setColumns(10);
			jtxtProductID.setBounds(253, 84, 204, 35);
			frame.getContentPane().add(jtxtProductID);
			
			JLabel lblProductID = new JLabel("Product ID:");
			lblProductID.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblProductID.setBounds(57, 84, 113, 35);
			frame.getContentPane().add(lblProductID);
		}
	}



