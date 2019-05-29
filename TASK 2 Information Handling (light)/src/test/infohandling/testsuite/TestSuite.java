package test.infohandling.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.infohandling.parser.ParagraphParserTest;
import test.infohandling.parser.SentenceParcerTest;
import test.infohandling.parser.TextParserTest;
import test.infohandling.sorter.ParagraphBySentenceSorterTest;
import test.infohandling.sorter.SentenceBySymbolSorterTest;
import test.infohandling.sorter.WordsByLengthSorterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParagraphParserTest.class, 
	SentenceParcerTest.class, 
	TextParserTest.class,
	ParagraphBySentenceSorterTest.class, 
	SentenceBySymbolSorterTest.class, 
	WordsByLengthSorterTest.class
       })

public class TestSuite {

}