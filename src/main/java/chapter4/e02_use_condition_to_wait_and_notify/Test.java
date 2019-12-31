package chapter4.e02_use_condition_to_wait_and_notify;

/**
 * synchronized结合wait和notify方法可以实现线程的等待/通知机制
 * 同样, ReentrantLock类结合Condition类的await和signal方法也可以实现等待/通知
 * 并且由于一个lock实例可以创建多个Condition实例, 这种方式可以实现选择性的通知
 * 避免了wait/notify中让虚拟机选择唤醒哪个线程所带来的不确定性
 * @author Nacht
 * Created on 2019/12/4
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ConditionService service = new ConditionService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
               service.await();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
               service.signal();
            }
        };
        thread1.start();
        Thread.sleep(3000L);
        thread2.start();
    }
}
