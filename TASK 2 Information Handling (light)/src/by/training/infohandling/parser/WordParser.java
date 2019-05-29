package by.training.infohandling.parser;


import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.Symbol;

/**
 * Public class extends of Parser with override method parseElement.
 */
public class WordParser extends Parser {
	/** Regex for split word on letters. */
	private static final String TOKEN_REGEX = "";
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Constructor.
	 */
	public WordParser() {
		LOGGER.info("New WordParser");
	}

	/**
	 * Override method from Parser class, that parse Words on Letters.
	 * @return {@code List<String>} of symbols.
	 */
	@Override
	public List<String> parseElement(final String sourceText, final Component component) {
		List<String> letters = Arrays.asList(sourceText.split(TOKEN_REGEX));

		for (String string : letters) {
			Component letter = new Symbol();
			component.add(letter);
			((Symbol) letter).setLetter(string);
		}
		return letters;
	}

}
