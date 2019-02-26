package chapter1.e11_daemon_thread;

/**
 * 守护线程是一种特殊的线程, 当进程中没有非守护线程的时候, 守护线程会自动销毁, 不会继续执行下去
 * 任何一个守护线程都是JVM中所有非守护线程的守护线程, 只要JVM中还有一个非守护线程在运行, 守护线程就不会销毁
 * 需要注意的是守护进程里面的finally语句块可能不会被执行
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        Thread.sleep(5000L);
        System.out.println("main thread end, and the daemon thread will not run anymore");
    }
}
