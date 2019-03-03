package chapter2.e19_synchronized_makes_variable_visible;

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
            synchronized (""){}
        }
        System.out.println("the loop breaks and the thread will stop running");
    }
}
