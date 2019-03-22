package chapter3.e13_interrupt_during_join;

/**
 * @Author Nacht
 * Created on 13/03/2019
 */
public class JoinThread extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0 ; i<100; i++){
            try {
                Thread.sleep(1000L);
                System.out.println("join线程正在执行中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
