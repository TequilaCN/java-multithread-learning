package chapter1.e11_daemon_thread;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class DaemonThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("i=" + i);
                Thread.sleep(1000L);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally , the loop ends");
        }
    }
}
