package thread12producerconsumerreentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {
	private int product = 0;
	ReentrantLock locker;
	Condition condition;

	Store() {
		locker = new ReentrantLock(); // ������� ����������
		condition = locker.newCondition(); // �������� �������, ��������� �
											// �����������
	}

	public void get() {

		locker.lock();
		try {
			// ���� ��� ��������� ������� �� ������, �������
			while (product < 1) {
				condition.await();
			}

			product--;
			System.out.println("���������� ����� 1 �����");
			System.out.println("������� �� ������: " + product);

			// �������������
			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			locker.unlock();
		}
	}

	public void put() {

		locker.lock();
		try {
			// ���� �� ������ 3 ������, ���� ������������ �����
			while (product >= 3)
				condition.await();

			product++;
			System.out.println("������������� ������� 1 �����");
			System.out.println("������� �� ������: " + product);
			// �������������
			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			locker.unlock();
		}
	}
}
