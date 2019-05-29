package by.training.infohandling.parser;


import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.TokenComposite;

/**
 * Public class extends of Parser with override method parseElement.
 */
public class SentenceParser extends Parser {
	/** Regex for split sentence on tokens */
	private static final String TOKEN_REGEX = " ";
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	/**
	 * Constructor.
	 */
	public SentenceParser() {
		LOGGER.info("New SentenceParser");
	}

	/**
	 * Override method from Parser class, that parse Sentences on Tokens.
	 * @return List with Tokens.
	 */
	@Override
	public List<String> parseElement(final String sourceText, final Component component) {
		List<String> tokens = Arrays.asList(sourceText.trim().split(TOKEN_REGEX));

		for (String string : tokens) {
			Component tokenComposite = new TokenComposite();
			component.add(tokenComposite);
			Parser parser = getNextParcer();
			parser.parseElement(string, tokenComposite);
		}
		return tokens;
	}

}
