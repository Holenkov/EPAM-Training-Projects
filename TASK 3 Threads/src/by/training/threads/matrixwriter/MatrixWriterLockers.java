package by.training.threads.matrixwriter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.matrix.Matrix;
import by.training.threads.matrix.MatrixLockers;

/**
 * Thread write its data on matrix.
 *
 */
public class MatrixWriterLockers extends Thread {
	/** Value, that thread should write to matrix. */
	private int number;
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Constructor.
	 * @param number value.
	 */
	public MatrixWriterLockers(final int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		MatrixLockers matrix = MatrixLockers.getMatrix();
		for (int i = 0; i < matrix.returnDimension(); i++) {
			matrix.putElement(i, i, number);
		}
			
	}
	
}
