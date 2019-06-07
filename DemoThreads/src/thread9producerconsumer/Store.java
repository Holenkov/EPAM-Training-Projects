package thread9producerconsumer;

import java.util.concurrent.TimeUnit;

class Store {
	int counter = 0; // счетчик товаров
	final int N = 5; // максимально допустимое число

	synchronized int put() {
		if (counter < N) {
			counter++;
			System.out.println("склад имеет " + counter + " товар(ов)");
			return 1;
		}
		return 0;//
	}

	synchronized int get() {
		if (counter > 0) {
			counter--;
			System.out.println("склад имеет " + counter + " товар(ов)");
			return 1;//
		}
		return 0;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getN() {
		return N;
	}

}
