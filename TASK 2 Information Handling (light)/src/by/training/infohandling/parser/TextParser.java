package by.training.infohandling.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.ParagraphComposite;

public class TextParser extends Parser{
	final private static String PARAGRAPH_REGEX = "([.]{3}|[.?!])" + System.lineSeparator()  + "\\s*";
	final private static Pattern PATTERN = Pattern.compile(PARAGRAPH_REGEX);
	private static final Logger LOGGER = LogManager.getRootLogger();
	

	public TextParser() {		
		LOGGER.info("New TextParser");
	}
	
	@Override
	public void parseElement(String sourceText, Component component) {
		Matcher matcher = PATTERN.matcher(sourceText);
		List<String> paragraphs = new ArrayList<>();
		int index = 0;
		while (matcher.find()) {
			paragraphs.add(sourceText.substring(index, matcher.start()) + matcher.group());
			index = matcher.end();
		}
		
		for (String string : paragraphs) {
			Component paragraphComposite = new ParagraphComposite();
			component.add(paragraphComposite);
			Parser parser = getNextParcer();
			parser.parseElement(string, paragraphComposite);			
		}
	}

	

}
