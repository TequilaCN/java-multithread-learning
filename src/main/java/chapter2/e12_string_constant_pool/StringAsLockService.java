package chapter2.e12_string_constant_pool;

/**
 * @Author Nacht
 * Created on 01/03/2019
 */
public class StringAsLockService {
    public void methodA(String s){
        synchronized (s){
            while(true){
                System.out.println("methodA is calling by thread:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
