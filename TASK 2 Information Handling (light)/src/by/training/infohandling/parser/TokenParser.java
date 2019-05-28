package by.training.infohandling.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.WordComposite;

public class TokenParser extends Parser{
	/** Regex for split token on words */
	private static final String WORD_REGEX = "[.]{3}|[.?!:,;]";
	/** Pattern compiled from Regex. */
	private static final Pattern PATTERN = Pattern.compile(WORD_REGEX);
	/**  Logger.*/
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Default constructor.
	 */
	public TokenParser() {
		LOGGER.info("New TokenParser");
	}

	/**
	 * Override method from Parser class, that parse Tokens on Words.
	 @return {@code List<String>} contains word and punctuation.
	 */
	@Override
	public List<String> parseElement(String sourceText, Component component) {
		Matcher matcher = PATTERN.matcher(sourceText);
		List<String> words = new ArrayList<>();
		if (matcher.find()) {
			words.add(sourceText.substring(0, matcher.start()));
			words.add(matcher.group());
		} else {
			words.add(sourceText);
		}

		for (String string : words) {
			Component wordComposite = new WordComposite();
			component.add(wordComposite);
			Parser parser = getNextParcer();
			parser.parseElement(string, wordComposite);
		}
		return words;
	}



}
