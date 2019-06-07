package thread8stringbuffer;

import java.util.concurrent.TimeUnit;

public class BufferThread {
	static int counter = 0;
	// static StringBuffer s = new StringBuffer();
	static StringBuilder s = new StringBuilder();

	// заменить на StringBuilder
	public static void main(String args[]) throws InterruptedException {
		new Thread() {
			public void run() {
				synchronized (s) {
					while (BufferThread.counter++ < 3) {
						s.append("A");
						System.out.print("> " + counter + " ");
						System.out.println(s);
						try {
							TimeUnit.MILLISECONDS.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} // конец synchronized-блока
			}
		}.start();
		TimeUnit.MILLISECONDS.sleep(100);
		while (BufferThread.counter++ < 6) {
			System.out.print("< " + counter + " ");
			// в этом месте поток main будет ждать освобождения блокировки
			// объекта s
			s.append("B");
			System.out.println(s);
		}
	}
}
