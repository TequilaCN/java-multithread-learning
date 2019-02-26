package chapter1.e01_sample_thread;

/**
 * 使用多线程
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        new SampleThread().start();
        System.out.println("Main Thread Running!");
    }
}
