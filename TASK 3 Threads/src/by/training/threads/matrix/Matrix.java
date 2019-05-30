package by.training.threads.matrix;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singletone class, contains matrix data with methods for work with matrix.
 */
public class Matrix {
	/** Matrix with data.*/
	private int[][] matrix;
	/** Matrix with information about possibility of elements to change. */
	private boolean[][] connections;
	/** Another field */
	private int currentIndex;
	/** Locker. */
	ReentrantLock locker = new ReentrantLock();
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Private constructor.
	 */
	private Matrix() {
	}

	/**
	 * Method return instance.
	 * @return instance of Matrix.
	 */
	public static Matrix getMatrix() {
		return MatrixHolder.MATRIX;
	}

	/**
	 * Inner class for initialize instance.
	 */
	private static class MatrixHolder {
		/** Instance of Matrix.*/
		private static final Matrix MATRIX = new Matrix();
	}

	/**
	 * Method initializes matrix.
	 * @param int m - square matrix dimensions MxM.
	 */
	public void initializeMatrix(int m) {
		matrix = new int[m][m];
		connections = new boolean[m][m];
		currentIndex = 0;
	}

	/**
	 * Set value of matrix element.
	 * @param int i - row index.
	 * @param int j - column index.
	 * @param int element - value of element to set.
	 */
	public void setElement(int i, int j, int element) {
		matrix[i][j] = element;
	}
	
	/**
	
	
	/**
	 * Return value of matrix element.
	 * @param i - row index.
	 * @param j - column index.
	 * @return value of element with indexes [i][j].
	 */
	public int getElement(int i, int j) {
		return matrix[i][j];
	}

	
	/**
	 * Method writes data to one of the diagonal elements.
	 * @param int element - value, needed to write.
	 */
	public void writeData(int element) {
		int index = giveIndex();
		if (index < matrix.length) {
			LOGGER.info("Thread begin work" + Thread.currentThread().getName());
			int delay = (int) (Math.random() * 500);
			try {
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch (InterruptedException e) {
				LOGGER.error(e);
				Thread.currentThread().interrupt();
			}
			setElement(index, index, element);
			LOGGER.info("Thread end work" + Thread.currentThread().getName());
		} else {
			Thread.currentThread().interrupt();
		}
	
	}
	
	/**
	 * Method find element, that can be written, and returns its index.
	 * @return int index of element, that can be written.
	 */
	private int giveIndex() {
		locker.lock();
		int index = currentIndex;
		currentIndex++;
		while (currentIndex <= index);
		locker.unlock();
		return index;
	}
	
	
	/**
	 * Method find element, that can be written, and returns its index.
	 * @return int index of element, that can be written.
	 *//*
	private int giveIndex() {
		locker.lock();
		int index = matrix.length();
		for (int i = 0; i < connections.length; i++) {
			if (!connections[i][i]) {
				index = i;
				connections[i][i] = true;
				break;
			}
		}
		if (index == matrix.length()) {
			locker.unlock();
		} else {
			while (!connections[index][index]);
			locker.unlock();
		}
		return index;
	}*/
	
	/**
	 * Method return matrix dimension. 
	 * @return int m - square matrix dimension.
	 */
	public int getDimension() {
		return matrix.length;
	}

	
	@Override
	/**
	 * Override method.
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\r\n");
		for (int[] row : matrix) {
			for (int i : row) {
				stringBuilder.append(i + "\t");
			}
			stringBuilder.append("\r\n");
		}
		return stringBuilder.toString();
	}

}
