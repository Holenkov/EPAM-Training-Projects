package by.training.infohandling.parser;


/**
 * Public class with method initializeChain().
 */
public class ParserInitializer {
	/** Parser in the chain. */
	private static Parser textParser = new TextParser();
	/** Parser in the chain. */
	private static Parser paragraphParser = new ParagraphParcer();
	/** Parser in the chain. */
	private static Parser sentenceParser = new SentenceParser();
	/** Parser in the chain. */
	private static Parser tokenParser = new TokenParser();
	/** Parser in the chain. */
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
	 * @param parser - type of parser, needed to return.
	 * @return TextParser
	 */
	public static Parser getParser(final TextParser parser) {
		return textParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param parser - type of parser, needed to return.
	 * @return ParagraphParcer
	 */
	public static Parser getParser(final ParagraphParcer parser) {
		return paragraphParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param parser - type of parser, needed to return.
	 * @return SentenceParser
	 */
	public static Parser getParser(final SentenceParser parser) {
		return sentenceParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param parser - type of parser, needed to return.
	 * @return TokenParser
	 */
	public static Parser getParser(final TokenParser parser) {
		return tokenParser;
	}

	/**
	 * Overloaded method return Parser of given type.
	 * @param parser - type of parser, needed to return.
	 * @return WordParser
	 */
	public static Parser getParser(final WordParser parser) {
		return wordParser;
	}
}
