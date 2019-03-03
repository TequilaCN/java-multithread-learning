package chapter2.e18_atomic_class_in_cocurrent_package;

/**
 * 使用原子类可以保证线程操作的安全性
 * 实验中两个线程对同一个实例中的count进行自增操作
 * 如果使用的是int, 由于count++并非原子操作, 运行结果可能出现线程安全问题
 * 如果使用AtomicInteger, incrementAndGet()可以保证操作的原子性, 所以运行结果不会出现线程安全问题
 * @Author Nacht
 * Created on 03/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        AtomicObject object = new AtomicObject();
//        NonAtomicObject object = new NonAtomicObject();
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
        Thread.sleep(1000L);
        System.out.println("count:"+object.getCount());
    }
}
