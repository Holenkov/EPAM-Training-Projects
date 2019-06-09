package by.training.threads.bean;


import by.training.threads.service.NullResultException;

/**
 * Singletone class, contains matrix data with methods for work with matrix.
 */
public final class Matrix {
	/** Matrix with data. */
	private int[][] matrix;

	/**
	 * Private constructor.
	 */
	private Matrix() {

	}

	/**
	 * public static Matrix getMatrix().
	 * Method return instance.
	 *
	 * @return instance of Matrix.
	 */
	public static Matrix getMatrix() {
		return MatrixHolder.MATRIX;
	}

	/**
	 * Inner class for initialize instance.
	 */
	private static class MatrixHolder {
		/** Instance of Matrix. */
		private static final Matrix MATRIX = new Matrix();
	}

	/**
	 * public void initializeMatrix(int m).
	 * Method initializes matrix.
	 * @param m
	 *            - square matrix dimensions MxM.
	 */
	public void initializeMatrix(final int m) {
		matrix = new int[m][m];
	}

	/**
	 * public void setElement(int i, int j, int element).
	 * Set value of matrix element.
	 * @param i
	 *            - row index.
	 * @param j
	 *            - column index.
	 * @param element
	 *            - value of element to set.
	 * @throws NullResultException - exception.
	 */
	public void putElement(final int i, final int j, final int element) throws NullResultException {
		try {
			matrix[i][j] = element;
		} catch (NullPointerException e) {
			throw new NullResultException("Matrix not initialized", e);
		}

	}

	/**
	 * public int getElement(int i, int j).
	 * Return value of matrix element.
	 * @param i
	 *            - row index.
	 * @param j
	 *            - column index.
	 * @return value of element with indexes [i][j].
	 * @throws NullResultException - exception.
	 */
	public int returnElement(final int i, final int j) throws NullResultException {
		int result;
		try {
			result = matrix[i][j];
		} catch (NullPointerException e) {
			throw new NullResultException("Matrix not initialized", e);
		}
		return result;
	}

	/**
	 * public int getDimension().
	 * Method return matrix dimension.
	 * @return - square matrix dimension.
	 * @throws NullResultException - exception.
	 */
	public int returnDimension() throws NullResultException {
		int result;
		try {
			result = matrix.length;
		} catch (NullPointerException e) {
			throw new NullResultException("Matrix not initialized", e);
		}
		return result;
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
