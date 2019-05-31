package thread5threadinterrupt;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToInterrupt {
	public static void main(String[] args) {
        
	    System.out.println("Главный поток начал работу...");
	    ThreadToInterrupt myThread = new ThreadToInterrupt();
	    Thread myT = new Thread(myThread, "name of ThreadToDisable");
	    myT.start();
	    
	    try {
			TimeUnit.MILLISECONDS.sleep(1100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	             
	    	myT.interrupt();
	 
	    System.out.println("Главный поток завершил работу...");
	}
}
