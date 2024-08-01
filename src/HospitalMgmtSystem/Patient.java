// this is a driver class

package HospitalMgmtSystem; // ESS PACKAGE KE ANDAR 3 CLS BANAYE GEH

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    	private Connection connect;
    	private Scanner scanner;   // user seh i/p leh geh
    	// Creating CTOR--> 
    	public Patient(Connection connect,  Scanner scanner)
    	{
    		// jaha pr bhi Patient cls ka obj. baneh ga waha seh connect , scanner ke value ess CTOR meh aaye ge
    		this.connect=connect;
    		this.scanner=scanner;
    	}	
    	public void addPatient() 
    	{
			System.out.print("Enter Patient name");
			String name =scanner.next();
			System.out.print("Enter Patient age");
		//   age is of "int" type
			int age =scanner.nextInt();
			System.out.print("Enter patient gender");
			String gender =scanner.next();
			
			// try-catch block b/c we are going to connect with DB ....Connection i/f ka use krte hue connect kr rhe hai 
			// tbh ek excepn. aata hai jisse kahte SQLException
			try
			{
				// ek query banaye -->
				String query= "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
				//creating prepared stmt
				PreparedStatement prepStmt=connect.prepareStatement(query);
				// giving values to "? ? ?"
				prepStmt.setString(1,name);
				prepStmt.setInt(2,age);
				prepStmt.setString(3,gender);
				
				// Type "int" ka variable
				int affectedRows = prepStmt.executeUpdate();  // query var ko phle prepStmt meh daala frr prepStmt ko yha execute kiya
			if(affectedRows>0)
			{
				System.out.println("patient data added successfully");
			}
			else
			{
				System.out.println("Failed to add Patient");
			}
			
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			}
    	
    	public void viewPatients() 
    	{
			String query = "SELECT * FROM patients";
			try 
			{
				//     24:50
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}
			
		}
}
