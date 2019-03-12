package chapter3.e06_the_randomness_of_notify;

/**
 * @Author Nacht
 * Created on 08/03/2019
 */
public class WaitService {
    private Object lock = new Object();

    public void waitMethod(){
        synchronized (lock){
            try {
                System.out.println("Thread:"+Thread.currentThread().getName()+" , start waiting");
                lock.wait();
                System.out.println("Thread:"+Thread.currentThread().getName()+" , end waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod(){
        synchronized (lock){
                System.out.println("The notify thread is going to notify a random thread , you mother fucker.");
                lock.notify();
        }
    }
}
