package by.training.threads.matrix;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singletone class, contains matrix data with methods for work with matrix.
 */
public class MatrixLockers {
	/** Matrix with data.*/
	private int[][] matrix;
	/** Locker. */
	private ReentrantLock[] locker;
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();

	/**
	 * Private constructor.
	 */
	private MatrixLockers() {
	}

	/**
	 * Method return instance.
	 * @return instance of Matrix.
	 */
	public static MatrixLockers getMatrix() {
		return MatrixHolder.MATRIX;
	}

	/**
	 * Inner class for initialize instance.
	 */
	private static class MatrixHolder {
		/** Instance of Matrix.*/
		private static final MatrixLockers MATRIX = new MatrixLockers();
	}

	/**
	 * public void initializeMatrix(int m)
	 * Method initializes matrix.
	 * @param m - square matrix dimensions MxM.
	 */
	public void initializeMatrix(final int[][] matrix) {
		int m = matrix.length;
		this.matrix = new int[m][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	
		locker = new ReentrantLock[m];
		
		for(int i = 0; i < m; i++) {
			locker[i] = new ReentrantLock();
		}
	}

	/**
	 * public void setElement(int i, int j, int element) Set value of matrix
	 * element.
	 * @param i - row index.
	 * @param j - column index.
	 * @param element - value of element to set.
	 */
	public void putElement(final int i, final int j, final int element) {
		if (!locker[i].isLocked()) {
			locker[i].lock();
			LOGGER.info(Thread.currentThread().getName() + " begin work");
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(600));
			} catch (InterruptedException e) {
				LOGGER.error(e);
				Thread.currentThread().interrupt();
			}
			matrix[i][j] = element;
			LOGGER.info(Thread.currentThread().getName() + " end work. Element " + i + " has written.");
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
