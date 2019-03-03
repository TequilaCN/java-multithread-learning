package chapter2.e10_synchronized_static_method;

/**
 * synchronized加到静态方法和非静态方法的区别:
 * 静态方法是对类的同步方法进行同步, 一个线程获得锁之后, 类的所有对象调用该类所有的同步static方法时都会被锁定
 * 非静态方法是对该对象的同步方法进行同步, 不同对象之间的这个对象锁不会相互影响
 * 实验中service定义了一个同步静态方法methodA和非静态方法methodB
 * 实验结果显示这个方法的锁是不同的锁, methodA是类锁, methodB是对象锁, 两者互不干扰
 * thread-1获取类锁的同时, thread-2可以获取对象锁,两者异步执行
 * @Author Nacht
 * Created on 01/03/2019
 */
public class Test {
    public static void main(String[] args) {
        final SynchronizedService service = new SynchronizedService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.methodA();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.methodB();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
