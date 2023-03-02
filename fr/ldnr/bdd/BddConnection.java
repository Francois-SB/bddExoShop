package fr.ldnr.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author SupervielleF
 * The class BDD connection return a connection from an Object createFileConfig which contains
 * URL, login, password
 */


public class BddConnection {
	private Connection connection;
	private CreateConfigFile cf = new CreateConfigFile();
	
/**
 * 
 * @return Connection to dataBase 
 * from the CreateConfigFile Object
 */
	public Connection getConnection() {
		try {
			Class.forName(cf.getDriverClass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(cf.getDbUrl(),cf.getLogin(),cf.getPassword())){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}


		//ArrayList<Article> articles = new ArrayList<>();

}
