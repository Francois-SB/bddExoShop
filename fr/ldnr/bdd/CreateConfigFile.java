package fr.ldnr.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {

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
}

