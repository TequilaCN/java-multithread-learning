package chapter1.e04_variable_share_safe;

/**
 * SafeThread中对run方法加了同步关键字, 多个线程进行代码执行这一块代码的时候变为同步执行, 线程安全
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        SafeThread safeThread = new SafeThread();
        Thread thread1 = new Thread(safeThread,"thread-1");
        Thread thread2 = new Thread(safeThread,"thread-2");
        Thread thread3 = new Thread(safeThread,"thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
