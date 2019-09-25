package com.Dsci.ReadPropertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static String ReadElementObjectRepo(String object) throws IOException,FileNotFoundException {
		
		
		// create object of Properties class.
		Properties prop=new Properties(); 
		
		System.getProperty("user.dir");
		
		//Create object of FileInputStream and give property file location as fileInputStream parameter (which property file is to be read)
		
		FileInputStream ip= new FileInputStream("com.Dsci.insurancedomain/Resources/Object.property");
		// Load the file
		prop.load(ip);

		System.out.println(prop.getProperty(object));
		
       return prop.getProperty(object);
	}

}
