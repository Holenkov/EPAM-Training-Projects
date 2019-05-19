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

public class ParagraphParser extends Parser{
	final private static String PARAGRAPH_REGEX = "([.]{3}|[.?!])" + System.lineSeparator()  + "\\s*";
	final private static Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
	private Logger rootLogger = LogManager.getRootLogger();
	

	@Override
	public void parseText(String sourceText, Component component) {
		Matcher matcher = pattern.matcher(sourceText);
		List<String> paragraphs = new ArrayList<>();
		int index = 0;
		while (matcher.find()) {
			paragraphs.add(sourceText.substring(index, matcher.start()) + matcher.group());
			index = matcher.end();
		}
		
		for (String string : paragraphs) {
			/*rootLogger.info(string);
			rootLogger.info("--------------------");*/
			Component paragraphComposite = new ParagraphComposite();
			component.add(paragraphComposite);
			Parser parser = getNextParcer();
			parser.parseText(string, paragraphComposite);			
		}
	}

	

}
