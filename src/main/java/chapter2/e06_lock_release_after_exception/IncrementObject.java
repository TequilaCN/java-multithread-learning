package chapter2.e06_lock_release_after_exception;

/**
 * @Author Nacht
 * Created on 28/02/2019
 */
public class IncrementObject {
    private int count = 0 ;
    synchronized public void increCount(){
        System.out.println("method has been called by thread:"+ Thread.currentThread().getName());
        for(int i = 0 ; i < 10 ; i++){
            count++;
            System.out.println("count:"+count + " operated by thread:"+ Thread.currentThread().getName());
            if(count == 5){ //
                throw new RuntimeException("this exception was throwed to release lock");
            }
        }
    }
}
