package chapter1.e05_decrement_and_sout;

/**
 * System.out.println()方法内部是同步的,但是当它与i--或--i一起使用的时候, 实质上--i的i-1操作发生于打印操作之前, i--的i-1操作发生在打印之后
 * 所以依然会发生线程同步问题, 使用时应注意这一点
 * System.out.println()内部同步逻辑
 * public void println(String x) {
 *         synchronized (this) {
 *             print(x);
 *             newLine();
 *         }
 *     }
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        DecrementThread decrementThread = new DecrementThread();
        Thread thread1 = new Thread(decrementThread,"thread-1");
        Thread thread2 = new Thread(decrementThread,"thread-2");
        Thread thread3 = new Thread(decrementThread,"thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
