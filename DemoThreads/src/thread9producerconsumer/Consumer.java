package thread9producerconsumer;

import java.util.concurrent.TimeUnit;

class Consumer extends Thread {
	Store store; // объект склада, с которого покупатель будет брать товар
	int product = 0; // текущее количество товаров со склада

	Consumer(Store store) {
		this.store = store;
	}

	public void run() {
		try {
			while (product < 5) {
				product = product + store.get();
				System.out.println("Потребитель купил " + product + " товар(ов)");
				TimeUnit.MILLISECONDS.sleep(800);
			}
		} catch (InterruptedException e) {
			System.out.println("поток потребителя прерван");
		}
	}
}
