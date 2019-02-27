package chapter2.e07_asynchronized_in_overwrite;

/**
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Father {
    synchronized public void overwriteMe() throws InterruptedException {
        System.out.println("function overwriteMe in Father executed by thread:"+Thread.currentThread().getName());
        Thread.sleep(1000L);
        System.out.println("function overwriteMe in Father executed end by thread:"+Thread.currentThread().getName());
    }
}
