package by.training.threads.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;
import by.training.threads.matrix.MatrixLockers;
import by.training.threads.matrixwriter.MatrixWriter;
import by.training.threads.matrixwriter.MatrixWriterLockers;
import by.training.threads.reader.ArrayCreator;
import by.training.threads.reader.FileReader;

/**
 * Main class.
 */
public class RunnerLocker {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** File path and name of file with matrix data. */
	static final String MATRIX_DATA = ".\\data\\task3matrix.txt";
	/** File path and name of file with threads data. */
	static final String THREADS_DATA = ".\\data\\task3threads.txt";
	/** Number of threads. */
	static final int THREADS_NUMBER = 4;
	/** Matrix dimensions. */
	static final int MATRIX_DIMENSIONS = 10;

	/**
	 * Constructor.
	 */
	private RunnerLocker() {
	}

	/**
	 * Main method.
	 * @param args
	 *            String args from console.
	 */
	public static void main(final String[] args) {
		FileReader fileReader = new FileReader();
		int[] arrayThreads = null;
		int[] arrayMatrix = null;

		try {
			arrayThreads = fileReader.read(THREADS_DATA);
			arrayMatrix = fileReader.read(MATRIX_DATA);
		} catch (NullResultException e) {
			LOGGER.error(e.getMessage(), e);
		}

		int[] threadsData = ArrayCreator.createArray(arrayThreads, THREADS_NUMBER);
		int[][] matrixData = ArrayCreator.createMatrix(arrayMatrix, MATRIX_DIMENSIONS);

		MatrixLockers matrix = MatrixLockers.getMatrix();
		matrix.initializeMatrix(matrixData);

		LOGGER.info(matrix);

		List<MatrixWriterLockers> matrixWriterLockers = new ArrayList<>();

		for (int i = 0; i < THREADS_NUMBER; i++) {
			matrixWriterLockers.add(new MatrixWriterLockers(threadsData[i]));
		}

		for (MatrixWriterLockers mWriter : matrixWriterLockers) {
				mWriter.start();
		}

		for (MatrixWriterLockers mWriter : matrixWriterLockers) {
			try {
				mWriter.join();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
				Thread.currentThread().interrupt();
			}
		}
		LOGGER.info(matrix);
	}

}
