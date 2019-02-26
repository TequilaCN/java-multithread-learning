package chapter1.e08_suspend_the_thread.suspend_and_resume_monopolize_lock;

/**
 * suspend和resume方法的缺点:独占锁, 如果使用不当容易造成锁永远无法释放
 * 同时需要注意的是, 如果方法中有System.out.println()方法(里面包含同步语句块), 线程挂起将导致其他线程无法执行该方法进行打印
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final SynchronizedObject object = new SynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.printString();//线程名字为a的线程执行到这一句时线程会挂起并永远不释放持有的锁
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.printString();//线程名字为b的线程无法获得锁
            }
        };
        thread1.setName("a");
        thread2.setName("b");
        thread1.start();
        Thread.sleep(1000L);
        thread2.start();
    }
}
