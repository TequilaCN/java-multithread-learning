package chapter2.e05_reentrancy_of_lock_in_inherit;

/**
 * 子类对象可以通过可重入锁调用父类的同步方法
 * 该实验中线程thread获取了son对象的对象锁, 因此可以在线程运行过程中调用Son类的父类Father中的同步方法
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final Son son = new Son();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    son.methodInSon();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        son.methodInSon();
    }
}
