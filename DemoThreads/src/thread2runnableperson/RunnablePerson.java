package thread2runnableperson;

public class RunnablePerson extends Person implements Runnable {

	public RunnablePerson(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ": Hello World.");
		}
	}

	public static void main(String[] args) {
		System.out.println("Main start");
		Thread currentThread = Thread.currentThread();
		currentThread.setName("Main thread");
		System.out.println(currentThread);
		RunnablePerson runnablePerson1 = new RunnablePerson("Andrey");
		Thread thread1 = new Thread(runnablePerson1);
		RunnablePerson runnablePerson2 = new RunnablePerson("Holenkov");
		Thread thread2 = new Thread(runnablePerson2);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			// thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread1);
		System.out.println(thread2);
		System.out.println("Main finish");
	}

}
