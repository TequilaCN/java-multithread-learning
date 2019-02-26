package chapter1.e07_stop_the_thread.interrupt_break;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class InterruptAndBreakThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 1 ; i < 100 ; i++){
            System.out.println("current count: " + i);
            if(i == 50){
                System.out.println("i comes to 50 ,thread interrupt!");
                this.interrupt();
            }
            if(this.isInterrupted()){
                break ;
            }
        }
        System.out.println("the thread didn't actually stop , the code outside the for loop will be executed!");
    }
}
