package chapter1.e08_suspend_the_thread.suspend_and_resume;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class IncrementThread extends Thread {
    private int count = 0;
    @Override
    public void run() {
        super.run();
        while(true){
            count++;
        }
    }
    public int getCount(){
        return this.count;
    }
}
