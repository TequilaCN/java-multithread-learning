package chapter1.e02_randomness_of_thread;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class RandomThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 10 ; i++){
            System.out.println("Thread:"+currentThread().getName()+"==>"+i);
        }
    }
}
