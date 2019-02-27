package chapter2.e04_reentrancy_of_lock;

/**
 * 可重入锁:如果一个线程获得了一个对象锁, 那么它可以再次请求同一个对象锁的时候可以获得这个锁, 如果没有可重入锁的话就会造成死锁
 * 实验中thread-1先执行method1获得了对象锁, 此时method2和method3都处于锁定状态, 线程thread-2无法获得对象锁
 * 由于thread-1已经获得了这个对象锁, 它在执行method1的过程中调用method2的时候可以获得同一个对象锁, 故成功调用method2,method3同理
 * 而thread-2必须等待thread-1获得的对象锁释放之后才能执行method2
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final ReentrancyObject object = new ReentrancyObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
