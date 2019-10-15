package com.Konakart.KonakartAutomationTesting.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * The class loads the data of the property file and returns the value
 * associated with the kye in the property file.
 * 
 * @author arjun.santra
 *
 */

public class ReadPropertiesFile {
	static Properties property;
	static File file;
	static FileReader reader;

	/**
	 * This method load property file.
	 * 
	 * @param filePath
	 * @return the properties of the property file
	 * 
	 */

	public static Properties loadProperty(String pathName) {
		property = new Properties();
		file = new File(pathName);
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return property;

	}

}
