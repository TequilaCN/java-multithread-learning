package chapter2.e15_when_the_attribute_of_lock_changes;

/**
 * @Author Nacht
 * Created on 02/03/2019
 */
public class LockChangeService {
    private SelfLock lock1 = new SelfLock();
    private SelfLock lock2 = new SelfLock();
    public void function(){
        synchronized (lock1){
            System.out.println("function was called by thread:"+Thread.currentThread().getName());
            lock1.setName("666");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("function was called end by thread:"+Thread.currentThread().getName());
        }
    }
}
