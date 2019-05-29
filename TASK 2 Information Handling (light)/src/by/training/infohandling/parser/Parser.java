package by.training.infohandling.parser;


import java.util.List;
import by.training.infohandling.model.Component;

/**
 * Abstract class with methods parseElement(String sourceText, Component component),
 * Parser getNextParcer(), setNextParcer(Parser nextParcer).
 */

public abstract class Parser {
	/** Next Parser in the chain of Parsers.*/
	private Parser nextParcer;

	/**
	 * Method, that parse text on Components.
	 * @param sourceText - String with sourse text.
	 * @param component - Component, that will store collection on parsed Components.
	 * @return List{@code<String>} contains elements of parsed Element.
	 */
	public abstract List<String> parseElement(String sourceText, Component component);

	/**
	 * Getter for object field nextParcer.
	 * @return the next Parser in the chain on Parsers.
	 */
	public Parser getNextParcer() {
		return nextParcer;
	}
	
	/**
	 * Setter for object field nextParcer.
	 * @param nextParcer - Parser, that should be next in the chain of Parsers.
	 */
	public void setNextParcer(final Parser nextParcer) {
		this.nextParcer = nextParcer;
	}

}
