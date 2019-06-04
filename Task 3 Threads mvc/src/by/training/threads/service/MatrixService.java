package by.training.threads.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;

public class MatrixService {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	private Matrix matrix = Matrix.getMatrix();
	
	public void initializeMatrix(final int m) {
		matrix.initializeMatrix(m);
	}
	
	public void fillMatrix(int[][] source) throws NullResultException {
		int dimension = this.matrix.returnDimension();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrix.putElement(i, j, source[i][j]);
			}
		}
	}

	/**
	 * public void setElement(int i, int j, int element)
	 * Set value of matrix element.
	 * @param i - row index.
	 * @param j - column index.
	 * @param element - value of element to set.
	 * @throws NullResultException 
	 */
	public void putElement(final int i, final int j, final int element) throws NullResultException {
			matrix.putElement(i, j, element);
	}

	/**
	 * public int getElement(int i, int j)
	 * Return value of matrix element.
	 * @param i - row index.
	 * @param j - column index.
	 * @return value of element with indexes [i][j].
	 * @throws NullResultException 
	 */
	public int returnElement(final int i, final int j) throws NullResultException {
		return matrix.returnElement(i, j);
	}
	
	public int[][] viewMatrix() throws NullResultException {
		int dimension = this.matrix.returnDimension();
		int[][] matrix = new int[dimension][dimension]; 
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrix[i][j] = this.matrix.returnElement(i, j);
			}
		}	
		return matrix;
	}
	
	public int returnDimension() throws NullResultException {
		int result;
			result = matrix.returnDimension();
		return result;
	}
	
	public void writeElementsThreads(int[] data, int[][] index) throws NullResultException {
		int size = matrix.returnDimension();
		ReentrantLock[][] lockers = new ReentrantLock[size][size]; 
		for (int[] pair : index) {
			lockers[pair[0]][pair[1]] = new ReentrantLock();			
		}
		
		List<ElementWriter> elementWriter = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			elementWriter.add(new ElementWriter(data[i], index, lockers));
		}
		for (ElementWriter mWriter : elementWriter) {
				mWriter.start();
		}
		for (ElementWriter mWriter : elementWriter) {
			try {
				mWriter.join();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
				Thread.currentThread().interrupt();
			}
		}
		
	}
	
	
	

}
