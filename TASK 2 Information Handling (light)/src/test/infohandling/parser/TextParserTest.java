package test.infohandling.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import by.training.infohandling.exception.NullResultException;
import by.training.infohandling.filereader.TextFileReader;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.TextComposite;
import by.training.infohandling.parser.Parser;
import by.training.infohandling.parser.ParserInitializer;
import by.training.infohandling.parser.TextParser;

@RunWith(Parameterized.class)
public class TextParserTest {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private String sourceText;
	private List<String> expected;

	public TextParserTest(String sourceText, List<String> expected) {
		super();
		this.sourceText = sourceText;
		this.expected = expected;
	}

	@Parameters
	public static List<Object[]> paramsForTest() throws NullResultException {
		List<Object[]> forTest = new ArrayList<>();

		String parent = "text";
		String child = "paragraph";
		String dirPath = ".\\data\\test\\";
		String sourcePath = dirPath + "source_" + parent + "_test.txt";
		List<String> expectedPath = Arrays.asList(dirPath + child + "1_test.txt", dirPath + child + "2_test.txt",
				dirPath + child + "3_test.txt", dirPath + child + "4_test.txt", dirPath + child + "5_test.txt");
		elementParserTest(forTest, sourcePath, expectedPath);

		return forTest;
	}

	private static void elementParserTest(List<Object[]> forTest, String sourcePath, List<String> expectedPath)
			throws NullResultException {
		List<String> expected = new ArrayList<>();
		TextFileReader textFileReader = new TextFileReader();
		String sourceText = textFileReader.readText(sourcePath);
		String text;
		for (String path : expectedPath) {
			text = textFileReader.readText(path);
			text = text.substring(0, text.length() - 2);
			expected.add(text);
		}
		forTest.add(new Object[] {sourceText, expected});
	}

	@Test
	public void parse() {
		Component textComposite = new TextComposite();
		List<String> actual = null;
		Parser parser = ParserInitializer.getParser(new TextParser());
		actual = parser.parseElement(sourceText, textComposite);

		assertEquals(expected, actual);
	}

}
