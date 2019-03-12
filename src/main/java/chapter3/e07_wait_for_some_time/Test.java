package chapter3.e07_wait_for_some_time;

/**
 * wait方法可以传入一个时间参数, 该参数指定的wait方法的最大等待时间,如果超过了这个时间线程还没有被通知唤醒, 那么该线程会自动唤醒继续执行
 * @Author Nacht
 * Created on 08/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        synchronized (lock){
            lock.wait();
        }
        System.out.println("wait for 5 seconds, fuck you !");
    }
}
