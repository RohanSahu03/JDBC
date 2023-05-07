
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class LoadAndRegister {

	public static void main(String[] args) {
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("driver is loaded and registered ");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
