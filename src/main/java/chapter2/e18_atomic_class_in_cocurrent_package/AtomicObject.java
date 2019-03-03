package chapter2.e18_atomic_class_in_cocurrent_package;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Nacht
 * Created on 03/03/2019
 */
public class AtomicObject {
    private AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger getCount() {
        return count;
    }

    public void increCount(){
        for(int i = 0 ; i < 50 ; i++) {
            System.out.println("current count:" + count.incrementAndGet() + " , operated by thread:" + Thread.currentThread().getName());
        }
    }
}
