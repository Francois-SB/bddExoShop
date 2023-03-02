package fr.ldnr.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {
	
	private Properties prop = readPropertiersFile("files/config.properties");
	
		
	
	private String dbUrl = prop.getProperty("db.url");
	private String login = prop.getProperty("db.login");
	private String password = prop.getProperty("db.password");
	private String driverClass = prop.getProperty("db.driver.class");
	
	
	
//    System.out.println("login: "+ prop.getProperty("login"));
//    System.out.println("password: "+ prop.getProperty("password"));
	
/**
 * constr creating object with file data
 * 
 */
	public CreateConfigFile() {
		Properties prop = readPropertiersFile("files/config.properties");
		this.dbUrl = prop.getProperty("db.url");
		this.login = prop.getProperty("db.login");
		this.password = prop.getProperty("db.password");
		this.driverClass = prop.getProperty("db.driver.class");
	}

//	public CreateConfigFile getConfigFile() {
//		this.dbUrl = prop.getProperty("db.url");
//		this.login = prop.getProperty("db.login");
//		this.password = prop.getProperty("db.password");
//		this.driverClass = prop.getProperty("db.driver.class");
//	}
	
	
	public Properties readPropertiersFile(String fileName) {
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
	    	  try {
	         fis.close();
	    	  }catch(IOException ioe){
	    	  ioe.printStackTrace();
	    	  }
	      }
	      return prop;
	   }


	public static void main(String[] args){

		CreateConfigFile cf = new CreateConfigFile();
		cf.toString();
	
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

	@Override
	public String toString() {
		return "CreateConfigFile [dbUrl=" + dbUrl + ", login=" + login + ", password=" + password + ", driverClass="
				+ driverClass + "]";
	}
	
	}

