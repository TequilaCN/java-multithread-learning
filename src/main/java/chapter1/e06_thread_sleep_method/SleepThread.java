package chapter1.e06_thread_sleep_method;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class SleepThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName()+" start sleep, current time:"+System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end sleep, current time:"+System.currentTimeMillis());
    }
}
