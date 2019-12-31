package chapter1.e07_stop_the_thread.interrupt_during_sleep;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class SleepThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Thread running ...");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println("Thread: "+currentThread().getName()+" has been interrupted during sleep, which will throw an interrupted exception.");
            System.out.println("Thread.interrupted:"+Thread.interrupted());
            e.printStackTrace();
        }
    }
}
