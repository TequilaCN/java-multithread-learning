package chapter2.e07_asynchronized_in_overwrite;

/**
 * 同步不能继承
 * 实验中Son中的overwriteMe方法重写了Father类中的overwriteMe方法, 但是没有添加同步关键字
 * 从实验结果可以看出, 起了两个线程同时调用son对象中的overwriteMe方法, 仅仅在引用super.overwriteMe()处线程同步, 子类重写的逻辑部分并没有同步
 * 所以在子类重写父类同步方法的时候也必须加上同步关键字, 因为同步无法从父类继承
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Test {
    public static void main(String[] args) {
        final Son son = new Son();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    son.overwriteMe();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    son.overwriteMe();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
