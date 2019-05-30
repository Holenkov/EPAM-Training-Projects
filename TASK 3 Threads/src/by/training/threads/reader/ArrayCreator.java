package by.training.threads.reader;

public class ArrayCreator {
	
	private ArrayCreator() {
	}

	public static int[] createArray(int[] array, int arrayDimension){
		int[] newArray = new int[arrayDimension];
		for (int i = 0; i < arrayDimension; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	public static int[][] createMatrix(int[] array, int matrixDimension){
		int[][] matrix = new int[matrixDimension][matrixDimension];
		for (int i = 0; i < matrixDimension; i++) {
			for (int j = 0; j < matrixDimension; j++) {
				if (i == j) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = array[j + i*matrixDimension];
				}
			}
		}
		return matrix;
	}
}
