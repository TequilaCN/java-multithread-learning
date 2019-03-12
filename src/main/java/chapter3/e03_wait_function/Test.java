package chapter3.e03_wait_function;

/**
 * 调用wait方法会让当前线程释放持有的对象锁, 并等待。直到notify方法被调用
 * @Author Nacht
 * Created on 06/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("before synchronized");
        String lock = "lock";
        synchronized (lock){
            System.out.println("before wait");
            lock.wait();
            System.out.println("after wait");//不会被打印
        }
        System.out.println("after synchronized");//不会被打印
    }
}
