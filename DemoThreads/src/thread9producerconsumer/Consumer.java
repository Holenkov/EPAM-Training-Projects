package thread9producerconsumer;

import java.util.concurrent.TimeUnit;

class Consumer extends Thread {
	Store store; // ������ ������, � �������� ���������� ����� ����� �����
	int product = 0; // ������� ���������� ������� �� ������

	Consumer(Store store) {
		this.store = store;
	}

	public void run() {
		try {
			while (product < 5) {
				product = product + store.get();
				System.out.println("����������� ����� " + product + " �����(��)");
				TimeUnit.MILLISECONDS.sleep(800);
			}
		} catch (InterruptedException e) {
			System.out.println("����� ����������� �������");
		}
	}
}
