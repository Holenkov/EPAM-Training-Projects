package by.training.threads.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.bean.Matrix;

/**
 * Thread write its data on matrix.
 */
public class ElementWriter extends Thread {
	/** Value, that thread should write to matrix. */
	private int number;
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** Indexes of elements to write. */
	private int[] index;
	/** Lockers of elements to write. */
	private ReentrantLock[] lockers;
	/** Locker. */
	private ReentrantLock commonLocker;
	/**
	 * Constructor.
	 *
	 * @param number
	 *            - value to write.
	 * @param index
	 *            - Indexes of elements to write.
	 * @param lockers
	 *            - Lockers of elements to write.
	 */
	public ElementWriter(final int number, final int[] index,
			final ReentrantLock[] lockers, final ReentrantLock commonLocker) {
		super();
		this.number = number;
		this.index = index;
		this.lockers = lockers;
		this.commonLocker = commonLocker;
	}

	@Override
	/**
	 * public void run()
	 */
	public void run() {
		final int RANDOM_DELAY = 1000;
		Matrix matrix = Matrix.getMatrix();
		commonLocker.lock();
		for (int i : index) {

			if (!lockers[i].isLocked()) {
				lockers[i].lock();
				if (commonLocker.isLocked()) {
					commonLocker.unlock();
				}
				LOGGER.info(Thread.currentThread().getName() + " begin work");
				try {
					TimeUnit.MILLISECONDS.sleep((long) (new Random().nextInt(RANDOM_DELAY) + RANDOM_DELAY));
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
					Thread.currentThread().interrupt();
				}
				try {
					matrix.putElement(i, i, number);
				} catch (NullResultException e) {
					LOGGER.error(e.getMessage(), e);
				}
				LOGGER.info(Thread.currentThread().getName() + " end work. Element " + i + " has written.");
			}
		}
		LOGGER.info(Thread.currentThread().getName() + " finish. ");
	}
}
