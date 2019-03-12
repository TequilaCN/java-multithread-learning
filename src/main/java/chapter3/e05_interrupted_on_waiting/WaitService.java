package chapter3.e05_interrupted_on_waiting;

/**
 * @Author Nacht
 * Created on 08/03/2019
 */
public class WaitService {
    private Object lock = new Object();
    public void waitMethod(){
        try {
            synchronized (lock) {
                System.out.println("begin waiting...");
                lock.wait();
                System.out.println("end waiting...");
            }
        }catch (Exception e){
            System.out.println("the method throwed out an interrupted exception because the thread was interrupted while waiting");
            e.printStackTrace();
        }
    }
}
