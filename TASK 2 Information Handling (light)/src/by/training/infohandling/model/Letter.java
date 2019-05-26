package by.training.infohandling.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Final class in Component hierarchy implements Component.
 * Contains field, that store one letter.
 */

public class Letter implements Component {
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** Private field, contains one letter. */
	private String letter;

	@Override
	public void add(final Component component) {
		LOGGER.info("No operations");
	}

	@Override
	public void remove(final Component component) {
		LOGGER.info("No operations");
	}

	@Override
	public Component getChild(int index) {
		LOGGER.info("No operations");
		return null;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
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

	@Override
	public void setChild(int index, Component component) {
		LOGGER.info("No operations");
		
	}

	@Override
	public int returnSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	
	
	

}
