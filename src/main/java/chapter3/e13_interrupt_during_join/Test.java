package chapter3.e13_interrupt_during_join;

/**
 * 被join的线程过在执行join线程的过程中被interrupt方法中断, 会抛出一个java.lang.InterruptedException异常
 * 原理:join方法是一个同步方法, 假设在B线程中调用了A线程的join方法, 实质上相当于在B中调用
 * while(a.isAlive){
 *     a.wait(0);
 * }
 * 当A线程的实例a仍在运行中时, B线程会不断调用wait(0)
 * 只有当A线程执行完毕后, B线程才会退出等待
 * 如果B线程在join的过程中被interrupt,实质上相当于在wait过程中被interrupt,会抛出异常(参考e05)
 * @Author Nacht
 * Created on 13/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BeJoinThread beJoinThread = new BeJoinThread();
        beJoinThread.start();
        Thread.sleep(5000L);
        beJoinThread.interrupt();
    }
}
