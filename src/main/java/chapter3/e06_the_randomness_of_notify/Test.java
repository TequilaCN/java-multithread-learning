package chapter3.e06_the_randomness_of_notify;

/**
 * notify()方法只能随机唤醒一个线程, 具体唤醒哪个线程是不确定的
 * 实验中起了三个线程让他们处于等待状态, 然后让一个唤醒线程去唤醒他们
 * 但是实验结果显示每次都是唤醒的第一个开始等待的线程thread1, 我真是草了
 * 去看了一下java的api, The choice is arbitrary and occurs at the discretion of the implementation.
 * 根据我蹩脚的英文, 应该是唤醒哪个线程是不确定的, 具体情况由虚拟机实现决定
 * 所以说,记得notify唤醒线程的随机性就ok了
 * @Author Nacht
 * Created on 08/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitService waitService = new WaitService();
        Thread waitThread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                waitService.waitMethod();
            }
        };
        Thread waitThread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                waitService.waitMethod();
            }
        };
        Thread waitThread3 = new Thread(){
            @Override
            public void run() {
                super.run();
                waitService.waitMethod();
            }
        };
        Thread notifyThread = new Thread(){
            @Override
            public void run() {
                super.run();
                waitService.notifyMethod();
            }
        };
        waitThread1.setName("WaitThread-1");
        waitThread2.setName("WaitThread-2");
        waitThread3.setName("WaitThread-3");
        waitThread3.setPriority(10);
        waitThread1.start();
        waitThread2.start();
        waitThread3.start();
        Thread.sleep(2000L);
        notifyThread.start();
    }
}
