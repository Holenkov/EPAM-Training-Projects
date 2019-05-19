package by.training.infohandling.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Letter extends TextComposite {
	private final Logger rootLogger = LogManager.getRootLogger();
	private String letter;
	
	@Override
	public void add(Component component) {
		rootLogger.info("No operations");		
	}
	
	@Override
	public void remove(Component component) {
		rootLogger.info("No operations");
	}
	
	@Override
	public Object getChild(int index) {
		rootLogger.info("No operations");
		return null;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Logger getRootLogger() {
		return rootLogger;
	}

	@Override
	public String toString() {
		return letter + "";
	}
	
	
	
	
	

}
