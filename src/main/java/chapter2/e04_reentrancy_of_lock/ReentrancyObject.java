package chapter2.e04_reentrancy_of_lock;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class ReentrancyObject {
    synchronized public void method1() throws InterruptedException {
        System.out.println("synchronized method1 has been called by thread:"+Thread.currentThread().getName());
        Thread.sleep(1000L);
        method2();
    }
    synchronized public void method2() throws InterruptedException {
        System.out.println("synchronized method2 has been called by thread:"+Thread.currentThread().getName());
        Thread.sleep(1000L);
        method3();
    }
    synchronized public void method3(){
        System.out.println("synchronized method3 has been called by thread:"+Thread.currentThread().getName());
    }
}
