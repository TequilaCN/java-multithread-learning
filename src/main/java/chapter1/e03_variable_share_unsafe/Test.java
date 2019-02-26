package chapter1.e03_variable_share_unsafe;

/**
 * 多个线程对同一个变量进行操作时, 出现非线程安全问题, 变量并非依次递减, 而是出现了重复的情况
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        UnsafeThread unsafeThread = new UnsafeThread();
        Thread thread1 = new Thread(unsafeThread,"thread-1");
        Thread thread2 = new Thread(unsafeThread,"thread-2");
        Thread thread3 = new Thread(unsafeThread,"thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
