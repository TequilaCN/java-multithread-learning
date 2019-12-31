package chapter4.e03_fair_and_unfair_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nacht
 * Created on 2019/12/4
 */
public class LockService {
    private boolean isFair = true;
    private ReentrantLock lock = new ReentrantLock(isFair);
    public void print(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " is printing");
        lock.unlock();
    }
}
