package by.training.infohandling.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.collector.TextCollector;
import by.training.infohandling.exception.NullResultException;
import by.training.infohandling.filereader.TextFileReader;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.TextComposite;
import by.training.infohandling.parser.Parser;
import by.training.infohandling.parser.ParserInitializer;
import by.training.infohandling.parser.TextParser;
import by.training.infohandling.sorter.Sorter;
import by.training.infohandling.sorter.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.sorter.comparator.SentenñeBySymbolCompatator;
import by.training.infohandling.sorter.comparator.WordsByLengthComparator;

/**
 * Main class.
 */

public class Runner {
	private static final Logger LOGGER = LogManager.getRootLogger();
	static final String FILE_NAME = ".\\data\\task2text.txt";

	public static void main(String[] args) {
		TextFileReader textFileReader = new TextFileReader();
		String text = null;
		try {
			text = textFileReader.readText(FILE_NAME);
		} catch (NullResultException e) {
			e.printStackTrace();
		}
		LOGGER.info("Source Text");
		LOGGER.info(text);

		Component textComposite = new TextComposite();
		Parser textParser = ParserInitializer.getParser(new TextParser());
		textParser.parseElement(text, textComposite);

		TextCollector textCollector = new TextCollector();
		LOGGER.info("Collected Text");
		LOGGER.info(textCollector.collectText(textComposite));

		Sorter sorter = new Sorter();

		ParagraphBySentenceComparator comparatorPBS = new ParagraphBySentenceComparator();
		sorter.sort(textComposite, comparatorPBS);
		LOGGER.info("Sorted Text - Paragraphs by number of sentences");
		LOGGER.info(textCollector.collectText(textComposite));

		textComposite = new TextComposite();
		textParser.parseElement(text, textComposite);
		LOGGER.info("Collected Text");
		LOGGER.info(textCollector.collectText(textComposite));

		WordsByLengthComparator comparatorWBL = new WordsByLengthComparator();
		sorter.sort(textComposite, comparatorWBL);
		LOGGER.info("Sorted Text - Words by length");
		LOGGER.info(textCollector.collectText(textComposite));

		textComposite = new TextComposite();
		textParser.parseElement(text, textComposite);
		LOGGER.info("Collected Text");
		LOGGER.info(textCollector.collectText(textComposite));

		char keySymbol = 'a';
		SentenñeBySymbolCompatator comparatorSBS = new SentenñeBySymbolCompatator(keySymbol);
		sorter.sort(textComposite, comparatorSBS);
		LOGGER.info("Sorted Text - Sentences by numder of symbol " + keySymbol);
		LOGGER.info(textCollector.collectText(textComposite));

	}
}
