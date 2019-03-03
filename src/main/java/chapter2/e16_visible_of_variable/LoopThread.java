package chapter2.e16_visible_of_variable;

/**
 * @Author Nacht
 * Created on 02/03/2019
 */
public class LoopThread extends Thread{
    private boolean flag = true ;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        super.run();
        while(flag){
//            try{
//                System.out.println("loop is still running...");
//                System.out.println("before sleep:"+System.currentTimeMillis());
//                Thread.sleep(1000L);
//                System.out.println("after sleep:"+System.currentTimeMillis());
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
        System.out.println("the loop breaks and the thread will stop running");
    }
}
