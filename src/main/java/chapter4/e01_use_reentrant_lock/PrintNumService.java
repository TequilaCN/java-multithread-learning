package chapter4.e01_use_reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nacht
 * Created on 2019/12/3
 */
public class PrintNumService {
    private static ReentrantLock lock = new ReentrantLock();
    public static void printNum(){
        lock.lock();
        for(int i = 0 ; i < 5 ; i++){
            System.out.println("Current Thread : " + Thread.currentThread().getName() + "=====>" + i);
        }
        lock.unlock();
    }
}
