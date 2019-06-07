package thread14diningphilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Philosopher extends Thread {
	Semaphore sem; // �������. �������������� ����� ���������
	// ���-�� ������� ����
	int num = 0;
	// �������� ����� ��������
	int id;

	// � �������� ���������� ������������ �������� ������������� �������� �
	// �������
	Philosopher(Semaphore sem, int id) {
		this.sem = sem;
		this.id = id;
	}

	public void run() {
		try {
			while (num < 3)// ���� ���������� ������� ���� �� ��������� 3
			{
				// ����������� � �������� ���������� �� ����������
				sem.acquire();
				System.out.println("������� " + id + " ������� �� ����");
				// ������� ���
				TimeUnit.MILLISECONDS.sleep(100);
				num++;

				System.out.println("������� " + id + " ������� ��-�� �����");
				sem.release();

				// ������� ������
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("� �������� " + id + " �������� �� ���������");
		}
	}
}
