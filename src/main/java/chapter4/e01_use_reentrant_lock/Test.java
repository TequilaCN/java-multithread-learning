package chapter4.e01_use_reentrant_lock;

/**
 * 在java多线程中可以使用synchronized关键字来实现同步, 也能通过ReentrantLock类来实现同步
 * ReentrantLock类的功能比synchronized更多, 使用上也更加灵活
 * @author Nacht
 * Created on 2019/12/3
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                PrintNumService.printNum();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                PrintNumService.printNum();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
