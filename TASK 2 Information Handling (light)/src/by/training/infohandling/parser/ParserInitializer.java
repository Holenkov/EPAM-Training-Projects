package by.training.infohandling.parser;

/**
 * Public class with method initializeChain().
 */
public class ParserInitializer {

	/**
	 * Static method, that initialize chain of parsers and return first Parser in the chain TextParser.
	 * @return first Parser in the chain of Parsers.
	 */
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
