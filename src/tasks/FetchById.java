package tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to delete : ");
		int id=sc.nextInt();

		
		Connection con=null;
		PreparedStatement pst = null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/test";
		user="root";
		password="";
		String qry="select * from person where id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			pst=con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Data deleted...");
		}
		catch(ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
					}
				catch(SQLException e) 
					{
					e.printStackTrace();
					}
			}	
			if(pst!=null)
			{
				try {
					pst.close();
					}
				catch(SQLException e) 
					{
					e.printStackTrace();
					}
			}

	}

	}}
