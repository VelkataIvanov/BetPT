package com.sbtech.automationTestsBetPT.AutomationTestsBetPT;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FmTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmTest window = new FmTest();
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
	public FmTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("The Button");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				// Create a variable for the connection string.
				String connectionUrl = "jdbc:sqlserver:10.10.8.52:1433" +
					"databaseName=TestDB;user=sa;password=Sql!@#$%;";

				// Declare the JDBC objects.
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				
		        	try {
		        		// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "Insert into TestTableDB_vi([FirstName],[LastName],[Age],[Phone],[Email]) values ('Veliko','Ivanov','34','+359888241948','veliko.i@sbtech.com');";
		            		stmt = con.createStatement();
		            		rs = stmt.executeQuery(SQL);
		            
		            		// Iterate through the data in the result set and display it.
		            		while (rs.next()) {
		            			System.out.println(rs.getString(4) + " " + rs.getString(6));
		            		}
		        	}
		        
				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	

}
