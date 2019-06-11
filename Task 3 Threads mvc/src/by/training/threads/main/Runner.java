package by.training.threads.main;

import by.training.threads.view.MatrixApp;
import by.training.threads.view.MatrixAppLight;

/**
 * Main class.
 */
public class Runner {
	/**
	 * Main method.
	 * @param args - arguments from command line.
	 */
	public static void main(final String[] args) {
	/*	MatrixApp matrixApp = new MatrixApp();
		matrixApp.runMatrixApp();*/
		MatrixAppLight matrixApp = new MatrixAppLight();
		matrixApp.runMatrixApp();
	}
}