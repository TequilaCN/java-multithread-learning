package chapter2.e11_synchronized_static_method_in_diff_instance;

/**
 * synchronized static method的作用和synchronized(xxx.class)的作用是一样的
 * 这个操作会锁定对应的类, 这个类锁的范围是类的所有静态同步方法, 所有该类的实例在调用该类的静态同步方法时都必须先获得该类锁
 * 实验中SynchronizedStaticService里面有两个方法静态同步方法methodA和methodB, 创建该类的两个实例service1和service2
 * 通过两个不同的线程分别进行以下调用service1.methodA, service2.methodB, 实验结果显示这两个过程是同步进行的
 * 只要一个线程获得了类锁, 所有对该类的静态同步方法的调用都会被阻塞, 直到获得这个锁(synchronized(class){}语句块同理)
 * @Author Nacht
 * Created on 01/03/2019
 */
public class Test {
    public static void main(String[] args) {
        final SynchronizedStaticService service1 = new SynchronizedStaticService();
        final SynchronizedStaticService service2 = new SynchronizedStaticService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service1.methodA();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service2.methodB();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
