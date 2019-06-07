package thread5threadtodisable;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

	private boolean isActive;

	void disable() {
		isActive = false;
	}

	ThreadToDisable() {
		isActive = true;
	}

	public void run() {

		System.out.printf("����� %s ����� ������... \n", Thread.currentThread().getName());
		int counter = 1; // ������� ������
		while (isActive) {
			System.out.println("���� " + counter++);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("����� �������");
			}
		}
		System.out.printf("����� %s �������� ������... \n", Thread.currentThread().getName());
	}
}
