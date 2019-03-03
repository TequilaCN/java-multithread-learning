package chapter2.e14_when_the_lock_changes;

/**
 * 在将任何数据类型作为同步锁的时候,只需判断多个线程是否同时持有一个锁对象
 * 如果持有相同的锁对象,那么这些线程的执行就是同步的,否则就是异步的
 * 该实验中,在ChangeLockService的function函数中对String类型的lock做了修改
 * thread1.start();
 * Thread.sleep(50L);//这句会决定thread1和thread2调用function时是同步执行还是异步执行
 * thread2.start();
 * 这段代码中,如果没有中间的Thread.sleep(50L);那么两个线程同时启动,它们竞争的都是修改前的锁
 * 但是如果sleep一小段时间,lock被修改后指向另一个字符串常量,thread-2启动后和thread-1竞争的不再是同一把锁
 * 此时两个线程调用function方法变为异步执行
 * @Author Nacht
 * Created on 02/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final ChangeLockService service = new ChangeLockService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.function();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.function();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        Thread.sleep(50L);//这句会决定thread1和thread2调用function时是同步执行还是异步执行
        thread2.start();
    }
}
