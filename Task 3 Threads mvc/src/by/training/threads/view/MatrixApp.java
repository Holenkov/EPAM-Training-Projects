package by.training.threads.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.controller.Controller;
import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;
import by.training.threads.service.ArrayCreator;
import by.training.threads.service.DataReader;
import by.training.threads.service.MatrixService;

public class MatrixApp {
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
	private int[] threadsData;
	private int[][] matrixData;

	/**
	 * Constructor.
	 */
	

	/**
	 * Main method.
	 * @param args
	 *            String args from console.
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
					controller.writeElements(threadsData);
				} catch (NullResultException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	
	
	void menuCreateMatrix() {
		String fileName;
		Scanner scanner;
		int menu = -1;
		do {
			LOGGER.info("1: Read data from file   2: Read data (don't work)  3: Create and initialize Matrix  4: View matrix   0: Exit");
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
					System.out.println("Read data first");
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
	
	void menuReadThreadsData() {
		String fileName;
		Scanner scanner;
		int menu = -1;
		do {
			LOGGER.info("1: Read data from file   2: Read data (don't work)  3: View threads data   0: Exit");
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
					threadsData = controller.readData(fileName, dimension);
					LOGGER.info("Data readed successfully");
				} catch (NullResultException e) {
					LOGGER.info(e.getMessage());
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
					System.out.println("Read data first");
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
	
	
	
	/*	DataReader fileReader = new DataReader();
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
				matrix.putElement(i, j, matrixData[i][j]);
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
				Thread.currentThread().interrupt();
			}
		}
		LOGGER.info(matrix);
	}
*/
}
