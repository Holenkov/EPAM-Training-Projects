package thread9producerconsumer;

import java.util.concurrent.TimeUnit;

class Producer extends Thread {
	Store store; // объект склада, куда кладем товар
	int product = 5; // количество товаров, которые надо добавить

	Producer(Store store) {
		this.store = store;
	}

	public void run() {
		try {
			while (product > 0) {
				product = product - store.put();
				System.out.println("производителю осталось произвести " + product + " товар(ов)");
				TimeUnit.MILLISECONDS.sleep(400);
			}
		} catch (InterruptedException e) {
			System.out.println("поток производителя прерван");
		}
	}
}
