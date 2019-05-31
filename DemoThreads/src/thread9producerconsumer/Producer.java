package thread9producerconsumer;

import java.util.concurrent.TimeUnit;

class Producer extends Thread {
	Store store; // ������ ������, ���� ������ �����
	int product = 5; // ���������� �������, ������� ���� ��������

	Producer(Store store) {
		this.store = store;
	}

	public void run() {
		try {
			while (product > 0) {
				product = product - store.put();
				System.out.println("������������� �������� ���������� " + product + " �����(��)");
				TimeUnit.MILLISECONDS.sleep(400);
			}
		} catch (InterruptedException e) {
			System.out.println("����� ������������� �������");
		}
	}
}
