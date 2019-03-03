package chapter2.e13_dead_lock;

/**
 * 死锁:等一个不会释放的锁,一个无法得到的人
 * 实验中thread-1获得了lock1,等待lock2;thread-2获得了lock2,等待lock1,造成线程死锁
 * 用jstack查看该进程的堆栈信息可以看到检测出了一个死锁
 * Found one Java-level deadlock:
 * =============================
 * "Thread-2":
 *   waiting to lock monitor 0x00007fcc198240a8 (object 0x000000076abdcee8, a java.lang.Object),
 *   which is held by "Thread-1"
 * "Thread-1":
 *   waiting to lock monitor 0x00007fcc19821768 (object 0x000000076abdcef8, a java.lang.Object),
 *   which is held by "Thread-2"
 * @Author Nacht
 * Created on 01/03/2019
 */
public class Test {
    public static void main(String[] args) {
        final DeadLockService service = new DeadLockService();
        service.setName("fuck1");
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.setName("fuck1");
                service.fuck();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.setName("fuck2");
                service.fuck();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
