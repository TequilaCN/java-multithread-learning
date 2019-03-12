package chapter3.e04_wait_and_notify;

/**
 * 线程执行wait方法之后会处于等待状态, 并释放其持有的对象锁
 * 另一个线程调用对象锁的notify方法之后, 不会马上释放对象锁, 而是在执行完synchronized代码块之后释放对象锁,并随机通知一个处于wait状态的线程, 使它重新获取对象锁
 * 需要注意的是, 获得对象锁的wait状态线程执行完后, 由于没有执行对象锁的notify或notifyAll方法, 其他处于wait状态的线程会继续等待下去, 直到对象锁的notify方法再次被调用
 * @Author Nacht
 * Created on 06/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (lock){
                    System.out.println("thread-1 before wait");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread-1 after wait");
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (lock){
                    System.out.println("thread-2 before notify");
                    lock.notifyAll();
                    System.out.println("thread-2 after notify");
                }
            }
        };
        thread1.start();
        Thread.sleep(50L);
        thread2.start();
    }
}
