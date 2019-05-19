package by.training.infohandling.main;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		
		
		Parser letterParser = new LetterParser();
		Parser wordParser = new WordParser();
		Parser tokenParser = new TokenParser();
		Parser sentenceParser = new SentenceParcer();
		Parser paragraphParser = new ParagraphParser();
		
		paragraphParser.setNextParcer(sentenceParser);
		sentenceParser.setNextParcer(tokenParser);
		tokenParser.setNextParcer(wordParser);
		wordParser.setNextParcer(letterParser);
		
		paragraphParser.parseText(text, textComposite);
		TextReader textReader = new TextReader();
		textReader.readText(textComposite);
		
		
	}
}
