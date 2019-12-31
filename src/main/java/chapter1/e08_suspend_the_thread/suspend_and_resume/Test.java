package chapter1.e08_suspend_the_thread.suspend_and_resume;

/**
 * 从输出结果可以看出线程的确被挂起并在5s后恢复了
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();
        System.out.println("thread suspended for 5 secs");
        incrementThread.suspend();
        System.out.println("current time : "+ System.currentTimeMillis() + " and the count is :"+incrementThread.getCount());
        Thread.sleep(5000L);
        System.out.println("current time : "+ System.currentTimeMillis() + " and the count is :"+incrementThread.getCount());
        System.out.println("thread resumed");
        incrementThread.resume();
        Thread.sleep(5000L);
        System.out.println("current time : "+ System.currentTimeMillis() + " and the count is :"+incrementThread.getCount());
    }
}
