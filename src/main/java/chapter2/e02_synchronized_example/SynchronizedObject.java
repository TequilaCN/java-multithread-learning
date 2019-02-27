package chapter2.e02_synchronized_example;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class SynchronizedObject {
     public void synchronizedMethodA() throws InterruptedException {
         synchronized (this) {
             System.out.println("Thread:" + Thread.currentThread().getName() + " begin to call synchronizedMethodA");
             Thread.sleep(5000L);
             System.out.println("Thread:" + Thread.currentThread().getName() + " end to call synchronizedMethodA");
         }
    }
    public void asynchronizedMethodB() throws InterruptedException {
        System.out.println("Thread:"+Thread.currentThread().getName()+" begin to call asynchronizedMethodB");
        Thread.sleep(1000L);
        System.out.println("Thread:"+Thread.currentThread().getName()+" end to call asynchronizedMethodB");
    }
}
