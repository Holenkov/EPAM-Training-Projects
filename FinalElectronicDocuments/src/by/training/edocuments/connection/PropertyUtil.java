package by.training.edocuments.connection;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PropertyUtil {
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	private static PropertyUtil settings;
	private static Properties properties;
	
	private PropertyUtil() {
		 properties = new Properties();
	        try {
	            properties.load(PropertyUtil.class.getClassLoader().getResourceAsStream("app.properties"));	
	        } catch (Exception e) {
	           LOGGER.info("Something wrong");
	        }
	}
	
	public synchronized static PropertyUtil getSettings(){
		if(settings == null){
			settings = new PropertyUtil();
		}
		return settings;
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	
	public Properties getProperties(){
		return properties;
	}

}
