package chapter4.e03_fair_and_unfair_lock;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建ReentrantLock对象时可以传入一个boolean值来决定是否启用公平锁
 * 如果启用公平锁, 则线程调用遵循FIFO先进先出的顺序, 先启动的线程会优先获得锁
 * 如果不启用, 则随机竞争锁
 * 实验结果显示, 启用公平锁时, start running的顺序和start printing的顺序一样
 * 不启用时, start running的顺序和start printing的顺序不一样, 说明线程启动后随机获得锁, 而不是先启动的先获得锁
 * @author Nacht
 * Created on 2019/12/4
 */
public class Test {
    public static void main(String[] args) {
        LockService service = new LockService();
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" start running");
                service.print();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            Thread t = new Thread(thread);
            t.setName("Thread-"+i);
            t.start();
        }
    }
}
