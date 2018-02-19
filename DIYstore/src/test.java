import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public test() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "shippuudena");
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	public void getData() {
		try {
			String query = "select * from persons";
			result = statement.executeQuery(query);
			while(result.next()) {
				String name = result.getString("name");
				String age = result.getString("age");
				System.out.println("Name: "+name+" age: "+age);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

