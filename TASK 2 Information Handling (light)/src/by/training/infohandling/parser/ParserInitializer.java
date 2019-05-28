package by.training.infohandling.parser;


/**
 * Public class with method initializeChain().
 */
public class ParserInitializer {
	private static Parser textParser = new TextParser();
	private static Parser paragraphParser = new ParagraphParcer();
	private static Parser sentenceParser = new SentenceParser();
	private static Parser tokenParser = new TokenParser();
	private static Parser wordParser = new WordParser();

	/**
	 * Static block, that initialize chain of parsers.
	 */
	static {
		textParser.setNextParcer(paragraphParser);
		paragraphParser.setNextParcer(sentenceParser);
		sentenceParser.setNextParcer(tokenParser);
		tokenParser.setNextParcer(wordParser);
		
	}
	/**
	 * Overloaded method return Parser of given type.
	 * @param TextParser parser
	 * @return TextParser
	 */
	public static Parser getParser(TextParser parser) {
		return textParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param ParagraphParcer parser
	 * @return ParagraphParcer
	 */
	public static Parser getParser(ParagraphParcer parser) {
		return paragraphParser;
	}
	
	/**
	 * Overloaded method return Parser of given type.
	 * @param SentenceParser parser
	 * @return SentenceParser
	 */
	public static Parser getParser(SentenceParser parser) {
		return sentenceParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param TokenParser parser
	 * @return TokenParser
	 */
	public static Parser getParser(TokenParser parser) {
		return tokenParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param WordParser parser
	 * @return WordParser
	 */
	public static Parser getParser(WordParser parser) {
		return wordParser;
	}

	
	
	

}
