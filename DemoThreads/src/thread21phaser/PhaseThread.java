package thread21phaser;

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable {

	Phaser phaser;
	String name;

	PhaseThread(Phaser p, String n) {

		this.phaser = p;
		this.name = n;
		phaser.register();
	}

	public void run() {

		System.out.println(name + " ��������� ���� " + phaser.getPhase());
		phaser.arriveAndAwaitAdvance(); // ��������, ��� ������ ���� ����������

		System.out.println(name + " ��������� ���� " + phaser.getPhase());
		phaser.arriveAndAwaitAdvance(); // ��������, ��� ������ ���� ����������

		System.out.println(name + " ��������� ���� " + phaser.getPhase());
		phaser.arriveAndDeregister(); // �������� � ���������� ��� � ������� � ����������� �������
	}
}
