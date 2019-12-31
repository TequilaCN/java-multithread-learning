package chapter1.e09_yield_method;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class IncrementThread extends Thread{
    private int count = 0 ;
    @Override
    public void run() {
        super.run();
        System.out.println("loop begin");
        long currentTime = System.currentTimeMillis();
        for(int i = 0 ; i < 100000 ; i++){
            Thread.yield();
            count++;
        }
        System.out.println("loop end, cost "+ (System.currentTimeMillis()-currentTime) +"ms");
    }
}
