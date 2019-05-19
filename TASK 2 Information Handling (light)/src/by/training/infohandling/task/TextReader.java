package by.training.infohandling.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;

public class TextReader {
	private final Logger rootLogger = LogManager.getRootLogger();
	
	public void readText(Component component) {
		
		
		rootLogger.info(component);
		
		
	}

}
