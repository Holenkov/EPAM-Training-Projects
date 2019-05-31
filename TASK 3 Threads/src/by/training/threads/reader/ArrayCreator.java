package by.training.threads.reader;

/**
 * Class contains static methods createArray and createMatrix. Simply util
 * class.
 */
public class ArrayCreator {

	/**
	 * Constructor.
	 */
	private ArrayCreator() {
	}

	/**
	 * public static int[] createArray(int[] array, int arrayDimension)
	 * Static method create array of given dimension.
	 * @param array
	 *            - array with values.
	 * @param arrayDimension
	 *            - dimension of array to create.
	 * @return - array of given dimension.
	 */
	public static int[] createArray(final int[] array, final int arrayDimension) {
		int[] newArray = new int[arrayDimension];
		for (int i = 0; i < arrayDimension; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	/**
	 * public static int[][] createMatrix(int[] array, int matrixDimension)
	 * Static method create square matrix of given dimension.
	 * @param array
	 *            - array with values.
	 * @param matrixDimension
	 *            - dimension of array to create.
	 * @return - square matrix of given dimension with zero diagonal elements.
	 */
	public static int[][] createMatrix(final int[] array, final int matrixDimension) {
		int[][] matrix = new int[matrixDimension][matrixDimension];
		for (int i = 0; i < matrixDimension; i++) {
			for (int j = 0; j < matrixDimension; j++) {
				if (i == j) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = array[j + i * matrixDimension];
				}
			}
		}
		return matrix;
	}
}
