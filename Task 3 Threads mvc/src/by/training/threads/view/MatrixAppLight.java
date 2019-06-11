package by.training.threads.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.controller.Controller;
import by.training.threads.service.ArrayCreator;
import by.training.threads.service.NullResultException;

/** Console App. */
public class MatrixAppLight {
	/** Controller. */
	private static Controller controller = new Controller();
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
	/** Field to store threads data. */
	private int[] threadsData;
	/** Field to store matrix data. */
	private int[][] matrixData;

	/**
	 * Constructor.
	 */

	/**
	 * Main method.
	 */
	public void runMatrixApp() {
				try {
					String fileName = MATRIX_DATA;
					int dimension = 10;
					matrixData = controller.readData(fileName, dimension, dimension);
					matrixData = ArrayCreator.initializeDiagonal(matrixData);
					controller.createCommonMatrix(matrixData);
				
					int[][] matrix;
					matrix = controller.viewCommonMatrix();
					dimension = matrix.length;
						for (int i = 0; i < dimension; i++) {
							for (int j = 0; j < dimension; j++) {
								System.out.print(matrix[i][j] + "\t");
							}
							System.out.println();
						}
					fileName = THREADS_DATA;
					dimension = 4;
					threadsData = controller.readData(fileName, 1, dimension)[0];
					controller.writeDiagonal(threadsData);
					matrix = controller.viewCommonMatrix();
					dimension = matrix.length;
						for (int i = 0; i < dimension; i++) {
							for (int j = 0; j < dimension; j++) {
								System.out.print(matrix[i][j] + "\t");
							}
							System.out.println();
						}
				} catch (NullResultException e) {
					LOGGER.info(e.getMessage(), e);
				}
	}

}
