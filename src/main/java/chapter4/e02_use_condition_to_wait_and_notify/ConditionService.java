package chapter4.e02_use_condition_to_wait_and_notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nacht
 * Created on 2019/12/4
 */
public class ConditionService {
    private ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void await(){
        try {
            lock.lock();
            System.out.println("service begin await");
            condition.await();
            System.out.println("service end await");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void signal(){
        try {
            lock.lock();
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
