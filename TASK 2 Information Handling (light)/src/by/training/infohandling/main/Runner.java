package by.training.infohandling.main;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.comparator.ParagraphBySentenceComparator;
import by.training.infohandling.comparator.WordsByLengthComparator;
import by.training.infohandling.exception.NullResultException;
import by.training.infohandling.filereader.TextFileReader;
import by.training.infohandling.model.Component;
import by.training.infohandling.model.Letter;
import by.training.infohandling.model.TextComposite;
import by.training.infohandling.parser.LetterParser;
import by.training.infohandling.parser.ParagraphParser;
import by.training.infohandling.parser.Parser;
import by.training.infohandling.parser.SentenceParcer;
import by.training.infohandling.parser.TokenParser;
import by.training.infohandling.parser.WordParser;
import by.training.infohandling.task.Sorter;
import by.training.infohandling.task.TextReader;

public class Runner {
	public static void main(String[] args) {
		Logger rootLogger = LogManager.getRootLogger();
		final String fileName = ".\\data\\task2text.txt";
		TextFileReader textFileReader = new TextFileReader();
		String text = null;
		try {
			text = textFileReader.readText(fileName);
		} catch (NullResultException e) {
			e.printStackTrace();
		}
		rootLogger.info(text);
		Component textComposite = new TextComposite();
		
		
		
		Parser paragraphParser = new ParagraphParser();
		paragraphParser.parseText(text, textComposite);
		TextReader textReader = new TextReader();
		textReader.readText(textComposite);
		
		Sorter sorter = new Sorter();
		
		ParagraphBySentenceComparator comparatorPBS = new ParagraphBySentenceComparator();
		sorter.sort(textComposite, comparatorPBS);
		textReader.readText(textComposite);
		
		WordsByLengthComparator comparatorWBL = new WordsByLengthComparator();
		sorter.sort(textComposite, comparatorWBL);
		textReader.readText(textComposite);
		
		
		
	}
}
