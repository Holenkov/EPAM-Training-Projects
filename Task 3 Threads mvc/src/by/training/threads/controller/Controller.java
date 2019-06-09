package by.training.threads.controller;

import by.training.threads.bean.Matrix;
import by.training.threads.service.ArrayCreator;
import by.training.threads.service.DataReader;
import by.training.threads.service.MatrixService;
import by.training.threads.service.NullResultException;

/**
 * Controller. Methods: readData, createCommonMatrix, viewCommonMatrix,
 * writeElements.
 */
public class Controller {
	/**
	 * public int[][] readData(final String fileName, int m, int n) throws NullResultException
	 * Method reads data from file to square matrix.
	 * @param fileName - file path and name.
	 * @param m - m matrix dimension.
	 * @param n - n matrix dimension.
	 * @return - square matrix dimension m x m;
	 * @throws NullResultException - exception.
	 */
	public int[][] readData(final String fileName,
			final int m, final int n) throws NullResultException {
		DataReader dataReader = new DataReader();
		int[] data = dataReader.read(fileName);
		return ArrayCreator.createMatrix(data, m, n);
	}

	/**
	 * public Matrix createCommonMatrix(int[][] source) throws NullResultException
	 * Creates Singletone common resource, that store matrix.
	 * @param source - matrix to store as common resource.
	 * @return - common resource.
	 * @throws NullResultException - exception.
	 */
	public Matrix createCommonMatrix(final int[][] source) throws NullResultException {
		MatrixService matrixService = new MatrixService();
		matrixService.initializeMatrix(source.length);
		matrixService.fillMatrix(source);
		return Matrix.getMatrix();
	}

	/**
	 * public int[][] viewCommonMatrix() throws NullResultException
	 * View matrix from common resource.
	 * @return - matrix from common resource.
	 * @throws NullResultException - exception.
	 */
	public int[][] viewCommonMatrix() throws NullResultException {
		MatrixService matrixService = new MatrixService();
		return matrixService.viewMatrix();
	}


	/**
	 * public void writeDioganal(int[] threadsData) throws NullResultException
	 * Writes data from array to diagonal elements of common
	 * resource matrix.
	 * @param threadsData - data to write.
	 * @throws NullResultException - exception.
	 */
	public void writeDioganal(final int[] threadsData) throws NullResultException {
		MatrixService matrixService = new MatrixService();
		int size = matrixService.returnDimension();
		int[][] index = new int[size][2];
		for (int i = 0; i < size; i++) {
			index[i][0] = i;
			index[i][1] = i;
		}
		matrixService.writeElementsThreads(threadsData, index);
	}

}
