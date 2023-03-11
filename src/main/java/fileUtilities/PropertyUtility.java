package fileUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import genericUtility.ResourcePaths;

public class PropertyUtility {
	
	public String getValue(String key)
	{
		Properties properties = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(ResourcePaths.ENV_PROPERTIES_PATH);
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties.getProperty(key, "Please give correct key");
	}
}
