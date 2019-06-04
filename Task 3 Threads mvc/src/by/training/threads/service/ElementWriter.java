package by.training.threads.service;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.exception.NullResultException;
import by.training.threads.matrix.Matrix;


/**
 * Thread write its data on matrix.
 *
 */
public class ElementWriter extends Thread {
	/** Value, that thread should write to matrix. */
	private int number;
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	int[][] index;
	ReentrantLock[][] lockers;

	/**
	 * Constructor.
	 * @param number value.
	 */
	public ElementWriter(int number, int[][] index, ReentrantLock[][] lockers) {
		super();
		this.number = number;
		this.index = index;
		this.lockers = lockers;
	}
	

	@Override
	public void run() {
		
		
		Matrix matrix = Matrix.getMatrix();
		for (int[] pair : index) {
			int i = pair[0];
			int j = pair[1];
			
			if (!lockers[i][j].isLocked()) {
				lockers[i][j].lock();
				LOGGER.info(Thread.currentThread().getName() + " begin work");
				try {
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {
					LOGGER.error(e);
					Thread.currentThread().interrupt();
				}
				try {
					matrix.putElement(i, i, number);
				} catch (NullResultException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LOGGER.info(Thread.currentThread().getName() + " end work. Element " + i + " has written.");
			}
			
		
		}
		
		LOGGER.info(Thread.currentThread().getName() + " finish. ");
	}

	
	
}
