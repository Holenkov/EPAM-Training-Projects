package thread3priority;

import java.util.concurrent.TimeUnit;

public class PriorThread extends Thread {
	
    public PriorThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            try {
                //Thread.sleep(0); // попробовать sleep(1),sleep(0),sleep(10)
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}


