package by.training.infohandling.parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.exception.NullResultException;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.Letter;

public class WordParser extends Parser{
	final private static String TOKEN_REGEX = "";
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	public WordParser() {
		LOGGER.info("New WordParser");
	}
	
	@Override
	public void parseElement(String sourceText, Component component) {
		List<String> letters = new ArrayList<>();
			letters = Arrays.asList(sourceText.split(TOKEN_REGEX));
			
		for (String string : letters) {
			Component letter = new Letter();
			component.add(letter);
			((Letter)letter).setLetter(string);
		}
	}

	

}
