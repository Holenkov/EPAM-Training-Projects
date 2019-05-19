package by.training.infohandling.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.model.Component;
import by.training.infohandling.model.ParagraphComposite;
import by.training.infohandling.model.SentenceComposite;

public class SentenceParcer extends Parser{

	final private static String SENTENCE_REGEX = "([.]{3}|[.?!])\\s*";
	final private static Pattern pattern = Pattern.compile(SENTENCE_REGEX);
	private Logger rootLogger = LogManager.getRootLogger();
	

	@Override
	public void parseText(String sourceText, Component component) {
		Matcher matcher = pattern.matcher(sourceText);
		List<String> sentences = new ArrayList<>();
		int index = 0;
		while (matcher.find()) {
			sentences.add(sourceText.substring(index, matcher.start()) + matcher.group());
			index = matcher.end();
		}
		
		String separator = System.lineSeparator();
		for (String string : sentences) {
			String newString = string.replaceAll(separator, "");
			/*rootLogger.info(newString);
			rootLogger.info("--------------------");*/
			
			Component sentenceComposite = new SentenceComposite();
			component.add(sentenceComposite);
			Parser parser = getNextParcer();
			parser.parseText(newString, sentenceComposite);			
		}
	}

	

}
