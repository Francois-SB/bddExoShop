package fr.ldnr.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BddConnection {
	Connection connection;
	CreateConfigFile cf = new CreateConfigFile();
/**
 * 
 * @return Connection to dataBase 
 * from the CreateConfigFile Object
 */
	public Connection getConnection() {
		try {
			Class.forName(cf.getDbUrl());
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
