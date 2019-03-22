package chapter3.e14_the_difference_between_join_and_sleep;

/**
 * @Author Nacht
 * Created on 14/03/2019
 */
public class JoinThread extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            for(int i = 0 ; i < 100 ; i ++){
                System.out.println("join thread is running ...");
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void syncMethodInJoinThread(){
        System.out.println("this is the synchronized method in join thread, it can be executed during join");
    }
}
