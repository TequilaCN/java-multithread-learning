package chapter1.test;

/**
 * @author Nacht
 * Created on 2019/11/13
 */
public class TestThread extends Thread{
    private int i = 0 ;
    @Override
    public void run() {
        super.run();
        while(true){
            i++;
            System.out.println("...");
        }
    }
}
