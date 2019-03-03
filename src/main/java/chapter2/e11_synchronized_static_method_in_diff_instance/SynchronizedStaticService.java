package chapter2.e11_synchronized_static_method_in_diff_instance;

/**
 * @Author Nacht
 * Created on 01/03/2019
 */
public class SynchronizedStaticService {
    synchronized public static void methodA(){
        System.out.println("static synchronized methodA was called by thread:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static synchronized methodA was called end by thread:"+Thread.currentThread().getName());
    }
    synchronized public static void methodB(){
        System.out.println("static synchronized methodB was called by thread:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static synchronized methodB was called end by thread:"+Thread.currentThread().getName());
    }
}
