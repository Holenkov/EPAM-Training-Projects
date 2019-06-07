package thread1helloworld;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {

		MyThread thread = new MyThread();
		thread.start();
	}
}
