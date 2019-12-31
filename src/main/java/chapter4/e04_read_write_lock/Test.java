package chapter4.e04_read_write_lock;

/**
 * ReentrantLock具有完全互斥排他的效果, 同一时间只有一个线程在执行ReentrantLock.lock()方法后面的任务
 * 这样虽然保证了实例变量的线程安全, 但是效率十分低下
 * 为了解决这个问题, jdk提供了一种读写锁ReentrantReadWriteLock
 * ReentrantReadWriteLock有两个锁, 一个是读锁, 也称为共享锁, 一个是写锁, 也称为排它锁
 * 多个读锁之间不互斥
 * 读写锁之间互斥
 * 写写锁之间互斥
 * @author Nacht
 * Created on 2019/12/31
 */
public class Test {
    public static void main(String[] args) {
        ReadWriteService service = new ReadWriteService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.write();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.write();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
