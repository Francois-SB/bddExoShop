package fr.ldnr.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {
	try {
	private Properties prop = readPropertiersFile("files/config.properties");
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
	private String dbUrl = prop.getProperty("db.url");
	private String login = prop.getProperty("db.login");
	private String password = prop.getProperty("db.password");
	private String driverClass = prop.getProperty("db.driver.class");
	
	
	
//    System.out.println("login: "+ prop.getProperty("login"));
//    System.out.println("password: "+ prop.getProperty("password"));
	
	public Properties readPropertiersFile(String fileName) throws IOException{
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }



	public String getDbUrl() {
		return dbUrl;
	}



	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDriverClass() {
		return driverClass;
	}



	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	}

