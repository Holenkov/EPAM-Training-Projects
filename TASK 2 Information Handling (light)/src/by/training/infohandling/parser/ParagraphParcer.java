package by.training.infohandling.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.SentenceComposite;

/**
 * Public class extends of Parser with override method parseElement.
 */
public class ParagraphParcer extends Parser{
	/** Regex for split paragraph on sentences */
	final private static String SENTENCE_REGEX = "([.]{3}|[.?!])\\s*";
	final private static Pattern PATTERN = Pattern.compile(SENTENCE_REGEX);
	private static final Logger LOGGER = LogManager.getRootLogger();

	public ParagraphParcer() {
		LOGGER.info("New ParagraphParcer");
	}

	/**
	 * Override method from Parser class, that parse Paragraphs on Sentences.
	 * @return List{@code<String>} contains Sentences.
	 */
	@Override
	public List<String> parseElement(String sourceText, final Component component) {
		String separator = System.lineSeparator();
		sourceText = sourceText.replaceAll(separator, "");
		Matcher matcher = PATTERN.matcher(sourceText);
		List<String> sentences = new ArrayList<>();
		int index = 0;
		while (matcher.find()) {
			sentences.add(sourceText.substring(index, matcher.start()) + matcher.group());
			index = matcher.end();
		}

		for (String string : sentences) {
			//String newString = string.replaceAll(separator, "");
			Component sentenceComposite = new SentenceComposite();
			component.add(sentenceComposite);
			Parser parser = getNextParcer();
			parser.parseElement(string, sentenceComposite);
		}
		return sentences;
	}
}
