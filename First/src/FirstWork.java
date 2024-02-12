import java.sql.*;
public class FirstWork {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String uname = "root";
		String pass = "Charitra2536";
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		
	}

}
