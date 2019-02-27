package chapter2.e02_synchronized_example;

/**
 * 关键字synchronized取到的锁都是对象锁
 * - 如果synchronized作用于非静态方法, 效果相当于在方法中的synchronized(this){}代码块
 * - 如果synchronized作用于静态方法, 效果相当于在方法中的synchronized(xxx.class){}代码块
 * 一个线程获得对象锁之后, 其他以该对象作为锁的代码块都将被锁定, 无法被其他线程访问, 但是非同步代码不会受到影响, 其他线程依然可以访问
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) {
        final SynchronizedObject object = new SynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.synchronizedMethodA();
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
                    object.asynchronizedMethodB();
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
