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
	public Component getChild(int index) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (letter == null) {
			if (other.letter != null)
				return false;
		} else if (!letter.equals(other.letter))
			return false;
		return true;
	}


	
	
	
	
	
	

}
