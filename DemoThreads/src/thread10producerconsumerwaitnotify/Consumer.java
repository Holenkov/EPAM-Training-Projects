package thread10producerconsumerwaitnotify;

import java.util.concurrent.TimeUnit;

class Consumer extends Thread {// implements Runnable {

	Store store;

	Consumer(Store store) {
		this.store = store;
	}

	public void run() {
		for (int i = 1; i < 6; i++) {
			store.get();
		}
	}
}
