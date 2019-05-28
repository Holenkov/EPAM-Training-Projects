package test.infohandling.sorter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import by.training.infohandling.sorter.Sorter;
import by.training.infohandling.sorter.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.sorter.comparator.SentenñeBySymbolCompatator;
import by.training.infohandling.sorter.comparator.WordsByLengthComparator;

@RunWith(Parameterized.class)
public class SorterTest {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private final static List<String> elements = Arrays.asList("text", "paragraph", "sentence", "token");
	private String sourceText;
	private String expected;
	private Comparator<Component> comparator;
	private static Parser parser = ParserInitializer.initializeChain();
	
	
	public SorterTest(String sourceText, String expected, Comparator<Component> comparator) {
		super();
		this.sourceText = sourceText;
		this.expected = expected;
		this.comparator = comparator;
	}

	@Parameters
	public static List<Object[]> paramsForTest() throws NullResultException {
		List<Object[]> forTest = new ArrayList<>();
		String sourcePath = ".\\data\\test\\source_text_sort.txt";
		TextFileReader textFileReader = new TextFileReader();
		String sourceText = textFileReader.readText(sourcePath);
		
		//1
		String expectedPath = ".\\data\\test\\sorted_paragraphs_text_sort.txt";
		String expected = textFileReader.readText(expectedPath);
		Comparator<Component> comparator = new ParagraphBySentenceComparator();
		forTest.add(new Object[]{sourceText, expected, comparator});
		
		//2
		expectedPath = ".\\data\\test\\sorted_words_text_sort.txt";
		expected = textFileReader.readText(expectedPath);
		comparator = new WordsByLengthComparator();
		forTest.add(new Object[]{sourceText, expected, comparator});
				
		//3
		expectedPath = ".\\data\\test\\sorted_sentences_text_sort.txt";
		expected = textFileReader.readText(expectedPath);
		comparator = new SentenñeBySymbolCompatator('a');
		forTest.add(new Object[]{sourceText, expected, comparator});
		
		return forTest;
	}
	
	@Test
	public void parse(){
				
		Component textComposite = new TextComposite();
		parser.parseElement(sourceText, textComposite);
		Sorter sorter = new Sorter();
		if(comparator instanceof ParagraphBySentenceComparator) {
			sorter.sort(textComposite, (ParagraphBySentenceComparator)comparator);
		}
		if(comparator instanceof WordsByLengthComparator) {
			sorter.sort(textComposite, (WordsByLengthComparator)comparator);
		}
		if(comparator instanceof SentenñeBySymbolCompatator) {
			sorter.sort(textComposite, (SentenñeBySymbolCompatator)comparator);
		}
				
		TextCollector textCollector = new TextCollector();
		String actual = textCollector.collectText(textComposite);
				
		assertEquals(expected, actual);
	}	
	
	

}
