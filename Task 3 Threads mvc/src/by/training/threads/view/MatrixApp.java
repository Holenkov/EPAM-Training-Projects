package by.training.threads.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.controller.Controller;
import by.training.threads.service.ArrayCreator;
import by.training.threads.service.NullResultException;

/** Console App. */
public class MatrixApp {
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
		Scanner scanner;
		int menu = -1;
		do {
			LOGGER.info("1: Create matrix   2: Read threads data  3: Fill diagonal  0: Exit");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				LOGGER.info("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case -1:
				break;
			case 1:
				menuCreateMatrix();
				break;
			case 2:
				menuReadThreadsData();
				break;
			case 3:
				try {
					controller.writeDioganal(threadsData);
				} catch (NullResultException e) {
					LOGGER.info(e);
				}
				break;
			case 0:
				LOGGER.info("Good bye!!!");
				break;
			default:
				LOGGER.info("Incorrect number.");
				break;
			}
		} while (menu != 0);
		LOGGER.info("");

	}

	/**
	 * Matrix menu.
	 */
	void menuCreateMatrix() {
		String fileName;
		Scanner scanner;
		int menu = -1;
		do {
			LOGGER.info(
					"1: Read data from file   2: Read data (don't work)  3: Create and initialize Matrix  4: View matrix   0: Back");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				LOGGER.info("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case -1:
				break;
			case 1:
				LOGGER.info("Enter filename");
				fileName = scanner.next();
				fileName = MATRIX_DATA;
				LOGGER.info("Enter square matrix dimension");
				int dimension = 0;
				try {
					dimension = scanner.nextInt();
				} catch (InputMismatchException e) {
					LOGGER.info("Incorrect type. Enter integer number");
					menu = -1;
				}

				try {
					matrixData = controller.readData(fileName, dimension, dimension);
					matrixData = ArrayCreator.initializeDiagonal(matrixData);
					LOGGER.info("Data readed successfully");
				} catch (NullResultException e) {
					LOGGER.info(e.getMessage());
				}
				break;
			case 2:
				LOGGER.info("Sorry");
				break;
			case 3:
				if (matrixData != null) {
					try {
						controller.createCommonMatrix(matrixData);
					} catch (NullResultException e) {
						LOGGER.info("Matrix not created");
					}
					LOGGER.info("Matrix created successfully");
				} else {
					LOGGER.info("Read data first");
				}

				break;
			case 4:
				int[][] matrix;
				try {
					matrix = controller.viewCommonMatrix();
					dimension = matrix.length;
					for (int i = 0; i < dimension; i++) {
						for (int j = 0; j < dimension; j++) {
							System.out.print(matrix[i][j] + "\t");
						}
						System.out.println();
					}
				} catch (NullResultException e) {
					LOGGER.info("Matrix not created");
				}
				break;
			case 0:
				break;
			default:
				LOGGER.info("Incorrect number.");
				break;
			}
		} while (menu != 0);
		LOGGER.info("");
	}

	/**
	 * Threads menu.
	 */
	void menuReadThreadsData() {
		String fileName;
		Scanner scanner;
		int menu = -1;
		do {
			LOGGER.info("1: Read data from file   2: Read data (don't work)  3: View threads data   0: Back");
			scanner = new Scanner(System.in);
			try {
				menu = scanner.nextInt();
			} catch (InputMismatchException e) {
				LOGGER.info("Incorrect type. Enter integer number");
				menu = -1;
			}
			switch (menu) {
			case -1:
				break;
			case 1:
				LOGGER.info("Enter filename");
				fileName = scanner.next();
				fileName = THREADS_DATA;
				LOGGER.info("Enter number of threads");
				int dimension = 0;
				try {
					dimension = scanner.nextInt();
				} catch (InputMismatchException e) {
					LOGGER.info("Incorrect type. Enter integer number");
					menu = -1;
				}

				try {
					threadsData = controller.readData(fileName, 1, dimension)[0];
					LOGGER.info("Data readed successfully");
				} catch (NullResultException e) {
					LOGGER.info(e);
				}
				break;
			case 2:
				LOGGER.info("Sorry");
				break;
			case 3:
				if (threadsData != null) {
					for (int data : threadsData) {
						System.out.print(data + "\t");
					}
					System.out.println();
				} else {
					LOGGER.info("Read data first");
				}

				break;
			case 0:
				break;
			default:
				LOGGER.info("Incorrect number.");
				break;
			}
		} while (menu != 0);
		LOGGER.info("");
	}

}
