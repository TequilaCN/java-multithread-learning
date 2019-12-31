package chapter1.test;

/**
 * @author Nacht
 * Created on 2019/11/13
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(3000L);
        testThread.suspend();
        System.out.println("haha");
    }
}
