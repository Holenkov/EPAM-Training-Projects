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
import by.training.infohandling.sorter.comparator.WordsByLengthComparator;

	@RunWith(Parameterized.class)
	public class WordsByLengthSorterTest {
		private String sourceText;
		private String expected;


		public WordsByLengthSorterTest(String sourceText, String expected) {
			super();
			this.sourceText = sourceText;
			this.expected = expected;
		}

		@Parameters
		public static List<Object[]> paramsForTest() throws NullResultException {
			List<Object[]> forTest = new ArrayList<>();
			String sourcePath = ".\\data\\test\\source_text_sort.txt";
			TextFileReader textFileReader = new TextFileReader();
			String sourceText = textFileReader.readText(sourcePath);

			//2
			String expectedPath = ".\\data\\test\\sorted_words_text_sort.txt";
			String expected = textFileReader.readText(expectedPath);
			forTest.add(new Object[]{sourceText, expected});

			return forTest;
		}

		@Test
		public void sort() {

			Component textComposite = new TextComposite();
			Parser parser = ParserInitializer.getParser(new TextParser());
			parser.parseElement(sourceText, textComposite);
			Sorter sorter = new Sorter();
			sorter.sort(textComposite, new WordsByLengthComparator());
			TextCollector textCollector = new TextCollector();
			String actual = textCollector.collectText(textComposite);

			assertEquals(expected, actual);
		}



	}
