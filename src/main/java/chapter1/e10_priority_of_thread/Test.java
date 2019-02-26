package chapter1.e10_priority_of_thread;

/**
 * java可为线程设置优先级,原则上优先级高的线程会获得更多的cpu时间, 实际测试几乎同时执行完成, 估计是因为多核cpu同时执行了两个线程
 * 优先级高的不一定会先执行完, 只是cpu会优先给它分配时间
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) {
        IncrementThread incrementThread1 = new IncrementThread();
        IncrementThread incrementThread2 = new IncrementThread();
        incrementThread1.setName("Thread-1");
        incrementThread2.setName("Thread-2");
        incrementThread1.setPriority(1);
        incrementThread2.setPriority(10);
        incrementThread1.start();
        incrementThread2.start();
    }
}
