package chapter3.e14_the_difference_between_join_and_sleep;

/**
 * @Author Nacht
 * Created on 14/03/2019
 */
public class BeJoinThread extends Thread{
    private Thread joinThread ;

    public void setJoinThread(Thread joinThread) {
        this.joinThread = joinThread;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("被join的线程开始执行");
            joinThread.start();
            joinThread.join();
            System.out.println("被join的线程执行完成");
        }catch (Exception e){
            System.out.println("被join的线程发生了一个异常, 异常详情:");
            e.printStackTrace();
        }
    }
}
