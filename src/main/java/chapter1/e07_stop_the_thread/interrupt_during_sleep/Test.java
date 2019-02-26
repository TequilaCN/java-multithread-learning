package chapter1.e07_stop_the_thread.interrupt_during_sleep;

/**
 * 线程在sleep状态下Interrupt和线程Interrupt之后执行sleep都会抛出java.lang.InterruptedException异常
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        Thread.sleep(5000L);
        sleepThread.interrupt();
    }
}
