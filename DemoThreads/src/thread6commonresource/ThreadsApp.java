package thread6commonresource;

public class ThreadsApp {

	public static void main(String[] args) {

		CommonResource commonResource = new CommonResource();
		for (int i = 1; i < 6; i++) {
			Thread t = new Thread(new CountThread(commonResource));
			t.setName("����� " + i);
			t.start();
		}
	}
}
