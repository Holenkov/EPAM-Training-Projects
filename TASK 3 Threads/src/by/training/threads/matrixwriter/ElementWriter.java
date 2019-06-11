package by.training.threads.matrixwriter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.matrix.Matrix;

/**
 * Thread write its data on matrix.
 *
 */
public class ElementWriter extends Thread {
	/** Value, that thread should write to matrix. */
	private int number;
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Constructor.
	 * @param number value.
	 */
	public ElementWriter(final int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		Matrix matrix = Matrix.getMatrix();
		while (!isInterrupted()) {			
				matrix.putElement(number);
		}
	}
}
