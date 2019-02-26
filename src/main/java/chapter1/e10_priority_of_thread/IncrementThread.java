package chapter1.e10_priority_of_thread;

import java.util.Random;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class IncrementThread extends Thread{
    private int count = 0 ;
    @Override
    public void run() {
        super.run();
        long currentTime = System.currentTimeMillis();
        while(count<10000000){
            count++;
            Random random = new Random();
            random.nextInt();
        }
        System.out.println("Thread: "+currentThread().getName()+", execute loop cost "+(System.currentTimeMillis()-currentTime)+"ms");
    }
}
