package chapter1.e07_stop_the_thread.interrupt_method;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class InterruptThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 1 ; i< 502 ; i++) {
            System.out.println("current count: " + i);
            if(i==499){
                System.out.println("i = 499 , this.interrupted: "+Thread.interrupted());
            }
            if(i==500){
                this.interrupt();
                System.out.println("i comes to 500 ,thread interrupt!");
            }
            if(i==501){
                System.out.println("i = 501 , this.interrupted: "+Thread.interrupted());
                System.out.println("i = 501 , this.interrupted: "+Thread.interrupted());
            }
        }
    }
}
