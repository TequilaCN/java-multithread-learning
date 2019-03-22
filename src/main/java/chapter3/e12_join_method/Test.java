package chapter3.e12_join_method;

/**
 * join作用:相当于将调用joid方法的线程代码嵌入到另一个线程的代码块中,实现同步效果, 但要注意还是两个线程
 * 与synchronized区别:join内部通过wait实现, synchronized内部通过对象监视器实现
 * @Author Nacht
 * Created on 13/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    System.out.println("sub thread begin sleeping");
                    Thread.sleep(5000L);
                    System.out.println("sub thread end sleeping");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        thread.join();
        Thread.sleep(2000L);
        System.out.println("i will be printed after subthread ends");
    }
}
