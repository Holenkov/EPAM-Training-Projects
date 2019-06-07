package thread21phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {
	public static void main(String[] args) {

		Phaser phaser = new Phaser(1);
		new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
		new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

		// ���� ���������� ���� 0
		int phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("���� " + phase + " ���������");
		// ���� ���������� ���� 1
		phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("���� " + phase + " ���������");

		// ���� ���������� ���� 2
		phase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("���� " + phase + " ���������");

		phaser.arriveAndDeregister();
	}
}
