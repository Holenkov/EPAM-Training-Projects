package by.training.threads.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;
import by.training.threads.matrixwriter.MatrixWriter;
import by.training.threads.reader.ArrayCreator;
import by.training.threads.reader.FileReader;

/**
 * Main class.
 */
public class Runner {
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
	 * Main method.
	 * 
	 * @param args
	 *            String args from console.
	 */
	public static void main(String[] args) {
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
		
		Matrix matrix = Matrix.getMatrix();
		matrix.initializeMatrix(MATRIX_DIMENSIONS);

		for (int i = 0; i < MATRIX_DIMENSIONS; i++) {
			for (int j = 0; j < MATRIX_DIMENSIONS; j++) {
				matrix.setElement(i, j, matrixData[i][j]);
			}
		}
		for (int i = 0; i < MATRIX_DIMENSIONS; i++) {
			for (int j = 0; j < MATRIX_DIMENSIONS; j++) {
				matrix.setElement(i, j, matrixData[i][j]);
			}
		}
		LOGGER.info(matrix);

		List<MatrixWriter> matrixWriter = new ArrayList<>();
		for (int i = 0; i < THREADS_NUMBER; i++) {
			matrixWriter.add(new MatrixWriter(threadsData[i]));
		}
		for (MatrixWriter mWriter : matrixWriter) {
			mWriter.start();
		}
		for (MatrixWriter mWriter : matrixWriter) {
			try {
				mWriter.join();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		LOGGER.info(matrix);
	}

}
