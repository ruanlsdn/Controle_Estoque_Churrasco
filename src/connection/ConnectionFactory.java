package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/dbchurrasco";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		}catch(Exception error) {
			throw new RuntimeException("Erro na conexão!" + error);
		}
	}
}
