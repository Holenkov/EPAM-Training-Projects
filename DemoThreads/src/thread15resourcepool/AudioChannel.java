package thread15resourcepool;

import java.util.concurrent.TimeUnit;

public class AudioChannel {
	private int ñhannellId;

	public AudioChannel(int id) {
		super();
		this.ñhannellId = id;
	}

	public int getÑhannellId() {
		return ñhannellId;
	}

	public void setÑhannellId(int id) {
		this.ñhannellId = id;
	}

	public void using() {
		try { // èñïîëüçîâàíèå êàíàëà
			TimeUnit.MILLISECONDS.sleep(new java.util.Random().nextInt(500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}