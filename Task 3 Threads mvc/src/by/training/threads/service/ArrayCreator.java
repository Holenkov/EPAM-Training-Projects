package by.training.threads.service;

/**
 * Class contains static methods createArray and createMatrix. Simply util
 * class.
 */
public final class ArrayCreator {

	/**
	 * Constructor.
	 */
	private ArrayCreator() {
	}

	/**
	 * public static int[][] createMatrix(final int[] array, final int
	 * mDimension, final int nDimension)
	 * Static method create matrix of given dimension.
	 *
	 * @param array
	 *            - array with values.
	 * @param mDimension
	 *            - m dimension of array to create.
	 * @param nDimension
	 *            - n dimension of array to create.
	 * @return - matrix of given dimension with zero diagonal elements.
	 */
	public static int[][] createMatrix(final int[] array, final int mDimension, final int nDimension) {
		int[][] matrix = new int[mDimension][nDimension];
		for (int i = 0; i < mDimension; i++) {
			for (int j = 0; j < nDimension; j++) {
				matrix[i][j] = array[j + i * mDimension];
			}
		}
		return matrix;
	}

	/**
	 * public static int[][] initializeDiagonal(final int[][] matrix)
	 * Initialize diagonal elements of matrix with zero numbers.
	 * @param matrix to initialize.
	 * @return matrix with zero diagonal elements.
	 */
	public static int[][] initializeDiagonal(final int[][] matrix) {
		int mDimension = matrix.length;
		int nDimension = matrix[0].length;
		for (int i = 0; i < mDimension; i++) {
			for (int j = 0; j < nDimension; j++) {
				if (i == j) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

}
