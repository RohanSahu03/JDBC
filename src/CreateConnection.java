import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			System.out.println("connection established");
			
			st=con.createStatement();
			System.out.println("statement created");
			
		}catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(st!=null) {
					try {
						st.close();
						System.out.println("statement closed");
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}


	}

}
