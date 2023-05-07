import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st = null;
		String url,user,pass;
		url="jdbc:mysql://localhost:3306/test";
		user="root";
		pass="";
		//String query="create table person(id int not null,name varchar(20),age int not null,password varchar(10),phone bigint(10) not null,primary key(id))";
		String query="insert into person values(16,'ram',45,'ram@45',234511146),(29,'sham',25,'sham@45',27333585)";

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			st=con.createStatement();
		
			int res=st.executeUpdate(query);
			System.out.println("data inserted");
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
			if(st!=null)
			{
				try {
					st.close();
					}
				catch(SQLException e) 
					{
					e.printStackTrace();
					}
			}
		}
	}

}
