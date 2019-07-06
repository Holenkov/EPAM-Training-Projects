package by.training.edocuments.connection;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AppProperties {
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	private static AppProperties settings;
	private static Properties properties;
	
	private AppProperties() {
		 properties = new Properties();
	        try {
	            properties.load(AppProperties.class.getClassLoader().getResourceAsStream("app.properties"));	
	        } catch (Exception e) {
	           LOGGER.info("Something wrong");
	        }
	}
	
	public synchronized static AppProperties getSettings(){
		if(settings == null){
			settings = new AppProperties();
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
