package chapter1.e02_randomness_of_thread;

/**
 * 验证线程执行的随机性
 * randomThread-1和randomThread-2将随机交替执行
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        RandomThread randomThread1 = new RandomThread();
        RandomThread randomThread2 = new RandomThread();
        randomThread1.setName("randomThread-1");
        randomThread2.setName("randomThread-2");
        randomThread1.start();
        randomThread2.start();
    }
}
