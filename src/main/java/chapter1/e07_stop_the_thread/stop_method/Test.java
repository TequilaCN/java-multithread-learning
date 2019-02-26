package chapter1.e07_stop_the_thread.stop_method;

/**
 * 使用stop()方法强制终止线程有两个弊端
 * 1.一些请理性的工作将无法被执行
 * 2.stop会使线程释放当前持有的锁, 导致数据不一致
 * 但是需要注意的是, 即使线程被强制终止, 在finally块中的语句同样会被执行
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        StopThread stopThread = new StopThread();
        stopThread.setPerson(person);
        stopThread.start();
        Thread.sleep(500L);
        stopThread.stop();//此处在set name和set fuckName两个操作中间强制终止线程,会导致线程释放锁, 造成数据不一致
        System.out.println("name:"+stopThread.getPerson().getName()+",fuck name :"+stopThread.getPerson().getFuckName());
    }
}
