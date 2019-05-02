package by.training.helloworld.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Andrey Holenkov.
 * Simple class
 *
 */

public final class Runner {

	/**
	 * Private constructor for Runner.
	 */

	private Runner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main method.
	 *
	 * @param args
	 * - argument, entered from console
	 */

	public static void main(final String[] args) {
		final Logger rootLogger = LogManager.getRootLogger();
		rootLogger.info("Hello");
		
		for (int i = 1; i<10; ++i) {
			rootLogger.info("i = " + i);
		}
	//	System.out.println("Hello");
		
	}
}
