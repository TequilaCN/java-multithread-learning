package chapter2.e14_when_the_lock_changes;

/**
 * @Author Nacht
 * Created on 02/03/2019
 */
public class ChangeLockService {
    private String lock = "lock";
    public void function(){
        synchronized (lock){
            System.out.println("function was called by thread:"+Thread.currentThread().getName());
            try {
                lock = "lock_change";
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("function was called end by thread:"+Thread.currentThread().getName());
        }
    }
}
