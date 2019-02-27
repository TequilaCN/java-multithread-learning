package chapter2.e05_reentrancy_of_lock_in_inherit;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Father {
    synchronized public void methodInFather(){
        System.out.println("method in father was called by thread: "+ Thread.currentThread().getName());
    }
}
