package by.training.threads.matrix;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singletone class, contains matrix data with methods for work with matrix.
 */
public class Matrix {
	/** Matrix with data.*/
	private int[][] matrix;
	/** Index of diagonal element to change. */
	private int currentIndex;
	/** Locker. */
	private ReentrantLock locker;
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
	 * public void initializeMatrix(int m)
	 * Method initializes matrix.
	 * @param m - square matrix dimensions MxM.
	 */
	public void initializeMatrix(final int m) {
		matrix = new int[m][m];
		currentIndex = 0;
		locker = new ReentrantLock();
	}

	/**
	 * public void setElement(int i, int j, int element)
	 * Set value of matrix element.
	 * @param i - row index.
	 * @param j - column index.
	 * @param element - value of element to set.
	 */
	public void putElement(final int i, final int j, final int element) {
			matrix[i][j] = element;
	}
	
	public void putElement(final int element) {
		int index = getCurrentIndex();
		if (index < matrix.length) {
			LOGGER.info(Thread.currentThread().getName() + " begin work");
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(600));
			} catch (InterruptedException e) {
				LOGGER.error(e);
				Thread.currentThread().interrupt();
			}
			matrix[index][index] = element;
			LOGGER.info(Thread.currentThread().getName() + " end work. Element " + index + " has written.");
		} else {
			Thread.currentThread().interrupt();
		}
		
	}
	

	/**
	 * public int getElement(int i, int j)
	 * Return value of matrix element.
	 * @param i - row index.
	 * @param j - column index.
	 * @return value of element with indexes [i][j].
	 */
	public int returnElement(final int i, final int j) {
		return matrix[i][j];
	}

	/**
	 * private int giveIndex() Method find element, that can be written, and
	 * returns its index.
	 * 
	 * @return index of element, that can be written.
	 */
	public int getCurrentIndex() {
		locker.lock();
		int index = currentIndex;
		currentIndex++;
		while (currentIndex <= index)
			;
		index = currentIndex - 1;
		locker.unlock();
		return index;
	}

	/**
	 * Setter.
	 * @param currentIndex value.
	 */
	public void setCurrentIndex(final int currentIndex) {
		int index = getCurrentIndex();
		if (index >= matrix.length) {
			this.currentIndex = currentIndex;
		}
	}

	/**
	 * public int getDimension()
	 * Method return matrix dimension.
	 * @return - square matrix dimension.
	 */
	public int returnDimension() {
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
