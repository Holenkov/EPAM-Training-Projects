package thread5threadtodisable;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToDisable {
	public static void main(String[] args) {

		System.out.println("Главный поток начал работу...");
		ThreadToDisable myThread = new ThreadToDisable();
		Thread myT = new Thread(myThread, "name of ThreadToDisable");
		myT.start();

		try {
			TimeUnit.MILLISECONDS.sleep(1100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		myThread.disable();

		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Главный поток завершил работу...");
	}
}
