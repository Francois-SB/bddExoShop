package fr.ldnr.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author SupervielleF
 * 
 * Load driver & connect to db 
 */


public class BddConnection {
	CreateConfigFile cf = new CreateConfigFile();
	Properties prop = cf.readPropertiersFile("src/files/config.properties");	
	
	private String dbUrl = prop.getProperty("db.url");
	private String login = prop.getProperty("db.login");
	private String password = prop.getProperty("db.password");
	static private String driverClass = "db.driver.class";
	//un seul objet pouvant appeller getConnection à la fois. Donc only 1 co possible en simultanée.
	private static BddConnection instance = null;
	
	private BddConnection() {
		
	}
	
	/**
	 * @return BddConnection object
	 * if no BddConnection object exists, create one
	 */
public static BddConnection getInstance() {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("dc ok");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
		if (instance==null){
			instance = new BddConnection();
			System.out.println("created ok");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return instance;
	
}
/**
 * 
 * @return Connection to dataBase 
 * 
 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl,login,password);
			System.out.println("connection ok ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
//	public static void main(String[] args){
//		Connection connection = BddConnection.getInstance().getConnection();
//		System.out.println(connection);
//	}
}
