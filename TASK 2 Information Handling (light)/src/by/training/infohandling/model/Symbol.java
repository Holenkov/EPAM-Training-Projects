package by.training.infohandling.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Final class in Component hierarchy implements Component.
 * Contains field, that store one letter.
 */
public class Symbol implements Component {
	/**Logger.*/
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** Private field, contains one letter. */
	private String letter;

	/**
	 * Public override method, no using for this class.
	 */
	@Override
	public void add(final Component component) {
		LOGGER.info("No operations");
	}

	/**
	 * Public override method, no using for this class.
	 */
	@Override
	public void remove(final Component component) {
		LOGGER.info("No operations");
	}

	/**
	 * Public override method, no using for this class.
	 */
	@Override
	public Component getChild(final int index) {
		LOGGER.info("No operations");
		return null;
	}

	/**
	 * Method return private field, storing one Symbol.
	 * @return String, contains one symbol.
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Method set value of private field.
	 */
	public void setLetter(final String letter) {
		this.letter = letter;
	}

	/**
	 Overrided from superclass method.
	 @return value of class field.
	 */
	@Override
	public String toString() {
		return letter + "";
	}

	/**
	 Overrided from superclass method.
	 @return hashCode;
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		return result;
	}

	/**
	 Overrided from superclass method.
	 @return true or false;
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (letter == null) {
			if (other.letter != null)
				return false;
		} else if (!letter.equals(other.letter))
			return false;
		return true;
	}

	/**
	 * * Public overrided method, no using for this class.
	 */
	@Override
	public void setChild(final int index, final Component component) {
		LOGGER.info("No operations");
	}

	/**
	 Overrided from superclass method.
	 @return always return 0;
	 */
	@Override
	public int returnSize() {
		return 0;
	}


}
