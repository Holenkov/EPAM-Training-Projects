package test.infohandling.sorter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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

@RunWith(Parameterized.class)
public class ParagraphBySentenceSorterTest {
	/** Source text. */
	private String sourceText;
	/** Expected text after sorting. */
	private String expected;

	/**
	 * Constructor.
	 * 
	 * @param sourceText
	 * @param expected
	 */
	public ParagraphBySentenceSorterTest(String sourceText, String expected) {
		super();
		this.sourceText = sourceText;
		this.expected = expected;
	}

	/**
	 * Parameters for test.
	 * @return array of parameters.
	 */
	@Parameters
	public static List<Object[]> paramsForTest() throws NullResultException {
		List<Object[]> forTest = new ArrayList<>();
		String sourcePath = ".\\data\\test\\source_text_sort.txt";
		TextFileReader textFileReader = new TextFileReader();
		String sourceText = textFileReader.readText(sourcePath);

		// 1
		String expectedPath = ".\\data\\test\\sorted_paragraphs_text_sort.txt";
		String expected = textFileReader.readText(expectedPath);
		forTest.add(new Object[] { sourceText, expected });

		return forTest;
	}

	/** Test. */
	@Test
	public void sort() {

		Component textComposite = new TextComposite();
		Parser parser = ParserInitializer.getParser(new TextParser());
		parser.parseElement(sourceText, textComposite);
		Sorter sorter = new Sorter();
		sorter.sort(textComposite, new ParagraphBySentenceComparator());

		TextCollector textCollector = new TextCollector();
		String actual = textCollector.collectText(textComposite);

		assertEquals(expected, actual);
	}

}
