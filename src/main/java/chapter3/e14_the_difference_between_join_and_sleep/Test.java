package chapter3.e14_the_difference_between_join_and_sleep;

/**
 * join方法会释放调用join方法的线程对象的对象锁
 * 比如在B线程中执行了A线程的实例a.join()那么B线程不会持有A线程的实例a的对象锁, 其他线程可以执行实例a的其他同步方法
 * @Author Nacht
 * Created on 14/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        BeJoinThread beJoinThread = new BeJoinThread();
        beJoinThread.setJoinThread(joinThread);
        beJoinThread.start();
        Thread.sleep(5000L);
        joinThread.syncMethodInJoinThread();
    }
}
