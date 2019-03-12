package chapter3.e05_interrupted_on_waiting;

/**
 * 线程在wait状态如果被Interrupt, 会抛出一个java.lang.InterruptedException异常
 * 实验中的线程调用wait方法之后, 在main线程中将此线程标记位Interrupt, 这波骚操作会导致线程会抛出异常
 * @Author Nacht
 * Created on 08/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitService service = new WaitService();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                service.waitMethod();
            }
        };
        thread.start();
        Thread.sleep(3000L);
        thread.interrupt();
    }
}
