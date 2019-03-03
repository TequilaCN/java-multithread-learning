package chapter2.e15_when_the_attribute_of_lock_changes;

/**
 * 只要对象不变, 即使对象的属性改变, 多个线程争夺的仍然视为同一个对象锁, 运行结果同步
 * 实验中在thread-1获得锁之后, 将lock对象的属性做修改, 并将主线程sleep一小段时间后再启动thread-2
 * 此时thread-2同步的锁为修改后的lock, 但是同步块的代码依然被同步执行了, 说明即使对象属性被修改了依然视为同一个对象锁
 * @Author Nacht
 * Created on 02/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final LockChangeService service = new LockChangeService();
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
        Thread.sleep(50L);
        thread2.start();
    }
}
