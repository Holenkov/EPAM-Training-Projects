package thread15resourcepool;

import java.util.concurrent.TimeUnit;

public class AudioChannel {
	private int �hannellId;

	public AudioChannel(int id) {
		super();
		this.�hannellId = id;
	}

	public int get�hannellId() {
		return �hannellId;
	}

	public void set�hannellId(int id) {
		this.�hannellId = id;
	}

	public void using() {
		try { // ������������� ������
			TimeUnit.MILLISECONDS.sleep(new java.util.Random().nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}