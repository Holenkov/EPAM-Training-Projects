package thread16blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class RunBlocking {
	public static void main(String[] args) {
		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		new Thread() {
			public void run() {
				for (int i = 1; i < 7; i++) {
					try {
						queue.put("Java" + i); // добавление 3-х
						System.out.println("Element " + i + " added");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			public void run() {
				for (int i = 1; i < 5; i++) {
					try {
						TimeUnit.MILLISECONDS.sleep(1000); // извлечение одного
						System.out.println("Element " + queue.take() + " took");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}