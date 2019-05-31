package thread5threadinterrupt;

import java.util.concurrent.TimeUnit;

public class ThreadToInterrupt implements Runnable {

	public void run(){
         
        System.out.printf("����� %s ����� ������... \n", Thread.currentThread().getName());
        int counter=1; // ������� ������
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("���� " + counter++);
              try{
                TimeUnit.MILLISECONDS.sleep(200);
            }
            catch(InterruptedException e){
            	Thread.currentThread().interrupt();
                System.out.println("����� �������");
            }
        }
        System.out.printf("����� %s �������� ������... \n", Thread.currentThread().getName());
    }
}
