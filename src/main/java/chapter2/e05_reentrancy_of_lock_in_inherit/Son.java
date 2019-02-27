package chapter2.e05_reentrancy_of_lock_in_inherit;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Son extends Father{
     synchronized public void methodInSon() throws InterruptedException {
        System.out.println("method in son was called by thread: "+ Thread.currentThread().getName());
        methodInFather();
    }
}
