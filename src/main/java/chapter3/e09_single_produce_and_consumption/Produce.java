package chapter3.e09_single_produce_and_consumption;

/**
 * @Author Nacht
 * Created on 11/03/2019
 */
public class Produce {
     private Object lock ;
     public void setLock(Object lock){
         this.lock = lock ;
     }
     public void produce() throws InterruptedException {
         while(true) {
             synchronized (lock) {
                 if (!"".equals(ValueObject.value)) {
                     lock.wait();
                 }
                 ValueObject.value = System.currentTimeMillis()+"_"+System.nanoTime();
                 System.out.println("produce:"+ValueObject.value);
                 Thread.sleep(1000L);
                 lock.notify();
             }
         }
     }
}
