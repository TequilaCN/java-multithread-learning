package chapter2.e06_lock_release_after_exception;

/**
 * 线程在发生异常时会释放获得的锁
 * 实验中Thread-1先获得object的对象锁, 但是在increCount()中循环执行到一半的时候抛出了一个异常(手动抛出)
 * 抛出异常之后, Thread-1获得的对象锁被释放, Thread-2获得对象锁, 继续执行increCount()方法
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Test {
    public static void main(String[] args) {
        final IncrementObject object = new IncrementObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.increCount();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.increCount();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
