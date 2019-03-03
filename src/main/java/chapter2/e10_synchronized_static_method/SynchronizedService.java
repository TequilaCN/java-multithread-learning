package chapter2.e10_synchronized_static_method;

/**
 * @Author Nacht
 * Created on 01/03/2019
 */
public class SynchronizedService {
    synchronized public static void methodA(){
        System.out.println("static synchronized method was called by thread:"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static synchronized method was called end by thread:"+Thread.currentThread().getName());
    }
    synchronized public void methodB(){
        System.out.println("unstatic synchronized method was called by thread:"+Thread.currentThread().getName());
        System.out.println("unstatic synchronized method was called end by thread:"+Thread.currentThread().getName());
    }
}
