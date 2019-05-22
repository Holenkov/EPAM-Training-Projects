package by.training.infohandling.parser;

public class ParserInitializer {
		
	public static Parser initializeChain() {
		Parser textParser = new TextParser();
		Parser paragraphParser = new ParagraphParcer();
		Parser sentenceParser = new SentenceParser();
		Parser tokenParser = new TokenParser();
		Parser wordParser = new WordParser();
				
		textParser.setNextParcer(paragraphParser);
		paragraphParser.setNextParcer(sentenceParser);
		sentenceParser.setNextParcer(tokenParser);
		tokenParser.setNextParcer(wordParser);
		return textParser;
	}

}
