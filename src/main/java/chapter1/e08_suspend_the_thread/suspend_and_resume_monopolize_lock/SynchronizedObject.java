package chapter1.e08_suspend_the_thread.suspend_and_resume_monopolize_lock;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class SynchronizedObject {
    synchronized void printString(){
        System.out.println("Thread: "+Thread.currentThread().getName()+" begin to call printString() method");
        if(Thread.currentThread().getName().equals("a")){
            Thread.currentThread().suspend();
        }
    }
}
