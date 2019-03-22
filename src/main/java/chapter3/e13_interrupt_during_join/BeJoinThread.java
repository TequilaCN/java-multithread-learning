package chapter3.e13_interrupt_during_join;

/**
 * @Author Nacht
 * Created on 13/03/2019
 */
public class BeJoinThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("被join的线程开始执行");
            Thread joinThread = new JoinThread();
            joinThread.start();
            joinThread.join();
            System.out.println("被join的线程执行完成");
        }catch (Exception e){
            System.out.println("被join的线程发生了一个异常, 异常详情:");
            e.printStackTrace();
        }
    }
}
