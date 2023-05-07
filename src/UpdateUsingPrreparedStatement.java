import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateUsingPrreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter existing id : ");
		int id=sc.nextInt();
		System.out.println("enter name,age,password and phone to update : ");
		String name=sc.next();
		int age=sc.nextInt();
		String pass=sc.next();
		long phone=sc.nextLong();
		
		Connection con=null;
		PreparedStatement pst = null;
		String url,user,password;
		url="jdbc:mysql://localhost:3306/test";
		user="root";
		password="";
		String qry="update person set name=?,age=?,password=?,phone=? where id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			pst=con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, pass);
			pst.setLong(4,phone);
			pst.setInt(5, id);
			pst.executeUpdate();
			System.out.println("Data updated...");
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
		

	}

}
