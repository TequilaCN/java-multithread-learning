package chapter3.e08_condition_change_while_waiting;

/**
 * 当使用wait/notify时,要注意在wait的过程中条件是否发生了变化
 * 实验中用两个减线程来对list做移除第一个元素的操作, 然后用一个加线程来做添加一个元素的操作
 * 开始由于list的size为0, 两个减线程都进入了wait状态, 知道加线程添加一个元素到list中并调用notifyAll方法来通知这两个线程
 * 此时两个线程都会执行减操作, 但是一个线程执行完后list中已经没有元素, 故会抛出数组越界异常
 * 解决办法是将if判断改为while循环体, 每次被唤醒都重新做一次判断条件是否依旧成立,如果不成立则继续等待
 * @Author Nacht
 * Created on 11/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Add add = new Add();
        Substract substract = new Substract();
        add.setLock(lock);
        substract.setLock(lock);
        Thread subThread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    substract.substractList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread subThread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    substract.substractList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread addThread = new Thread(){
            @Override
            public void run() {
                super.run();
                add.addList("haha");
            }
        };
        subThread1.setName("subThread-1");
        subThread2.setName("subThread-2");
        addThread.setName("addThread");
        subThread1.start();
        subThread2.start();
        Thread.sleep(3000L);
        addThread.start();
    }
}
