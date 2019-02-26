package chapter1.e01_sample_thread;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class SampleThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Sample Thread Running!");
    }
}
