package thread5threadinterrupt;

import java.util.concurrent.TimeUnit;

public class ThreadToInterrupt implements Runnable {

	public void run(){
         
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Цикл " + counter++);
              try{
                TimeUnit.MILLISECONDS.sleep(200);
            }
            catch(InterruptedException e){
            	Thread.currentThread().interrupt();
                System.out.println("Поток прерван");
            }
        }
        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }
}
