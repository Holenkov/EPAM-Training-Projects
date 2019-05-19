package by.training.infohandling.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.SentenceComposite;
import by.training.infohandling.model.WordComposite;

public class WordParser extends Parser{

	final private static String WORD_REGEX = "[.]{3}|[.?!:,;]";
	final private static Pattern pattern = Pattern.compile(WORD_REGEX);
	private Logger rootLogger = LogManager.getRootLogger();
	
	public WordParser() {
		rootLogger.info("New WordParser");
	}
	
	@Override
	public void parseText(String sourceText, Component component) {
		Matcher matcher = pattern.matcher(sourceText);
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
			parser.parseText(string, wordComposite);			
		}
	}

	

}
