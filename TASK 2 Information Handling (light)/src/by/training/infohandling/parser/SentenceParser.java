package by.training.infohandling.parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.TokenComposite;

public class SentenceParser extends Parser{
	/** Regex for split sentence on tokens */
	final private static String TOKEN_REGEX = " ";
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	public SentenceParser() {
		LOGGER.info("New SentenceParser");
	}
	
	/**
	 * Override method from Parser class, that parse Sentences on Tokens.
	 * @return 
	 */
	@Override
	public List<String> parseElement(String sourceText, Component component) {
		List<String> tokens = new ArrayList<>();
		tokens = Arrays.asList(sourceText.trim().split(TOKEN_REGEX));
		
		for (String string : tokens) {
			Component tokenComposite = new TokenComposite();
			component.add(tokenComposite);
			Parser parser = getNextParcer();
			parser.parseElement(string, tokenComposite);			
		}
		return tokens;
	}

	

}
