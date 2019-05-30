package by.training.threads.matrixwriter;

import java.util.concurrent.TimeUnit;

import by.training.threads.matrix.Matrix;

public class MatrixWriter extends Thread {
	int number;

	public MatrixWriter(int number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		Matrix matrix = Matrix.getMatrix();
		try {
			while (!isInterrupted()) {
				int delay = (int) (Math.random() * 500);
				TimeUnit.MILLISECONDS.sleep(delay);
				matrix.writeData(number);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
