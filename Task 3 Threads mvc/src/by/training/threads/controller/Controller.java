package by.training.threads.controller;


import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;
import by.training.threads.service.ArrayCreator;
import by.training.threads.service.DataReader;
import by.training.threads.service.MatrixService;

public class Controller {
	public int[] readData (final String fileName, int m) throws NullResultException {
			DataReader dataReader = new DataReader();
			int[] data = dataReader.read(fileName);
			return ArrayCreator.createArray(data, m);
		}
	
	public int[][] readData (final String fileName, int m, int n) throws NullResultException {
		DataReader dataReader = new DataReader();
		int[] data = dataReader.read(fileName);
		return ArrayCreator.createMatrix(data, m);
	}
	
	public Matrix createCommonMatrix (int[][] source) throws NullResultException {
		MatrixService matrixService = new MatrixService();
		matrixService.initializeMatrix(source.length);
		matrixService.fillMatrix(source);
		return Matrix.getMatrix();
	}
	
	public int[][] viewCommonMatrix () throws NullResultException {
		MatrixService matrixService = new MatrixService();
		return matrixService.viewMatrix();
	}
	
	public void writeElements (int[] threadsData) throws NullResultException {
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

