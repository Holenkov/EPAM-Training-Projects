package thread8stringbuffer;

import java.util.concurrent.TimeUnit;

public class BufferThread {
	static int counter = 0;
	// static StringBuffer s = new StringBuffer();
	static StringBuilder s = new StringBuilder();

	// �������� �� StringBuilder
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
				} // ����� synchronized-�����
			}
		}.start();
		TimeUnit.MILLISECONDS.sleep(100);
		while (BufferThread.counter++ < 6) {
			System.out.print("< " + counter + " ");
			// � ���� ����� ����� main ����� ����� ������������ ����������
			// ������� s
			s.append("B");
			System.out.println(s);
		}
	}
}
