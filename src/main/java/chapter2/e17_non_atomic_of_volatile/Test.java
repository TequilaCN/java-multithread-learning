package chapter2.e17_non_atomic_of_volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile只能保证变量在线程间的可见性, 不能保证线程对变量操作的原子性
 * 比如一个i++的操作, 虽然只有一个语句, 但是它并不是一个原子操作, 实际上可以分为三步:
 * 1.从内存中取出i的值
 * 2.将工作内存中i的值+1
 * 3.将工作内存中的值写入到主内存中
 * volatile只能保证线程在第一步中获取到的值是主内存中最新的值, 但是如果在第二步中有其他线程对这个变量做了操作, 该线程是无法感知到的
 * 这样就会导致将工作内存中的值写入主内存中的时候写入的数据并非最新的数+1
 * 可以假设以下过程
 * 1.count初始值为0
 * 2.线程1获取count初始值=>0
 * 3.线程2获取count初始值=>0
 * 4.线程1对count值+1, 并写入主内存(主内存为1)
 * 5.线程2对count值+1, 并写入主内存(主内存为1)
 * 6.主内存中的count值和预期值2不符, 出现数据不一致问题
 * 实验中起了50个线程, 分别在循环中进行50次count++操作, 实验结果证明如果不加同步关键字, count最终的值可能非预期中的2500, 而是比2500要小
 * 说明volatile只能保证变量在线程间的可见性, 但是无法保证对变量操作的原子性
 * @Author Nacht
 * Created on 03/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        FuckObject object = new FuckObject();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0 ; i < 50 ; i++){
            IncreThread increThread = new IncreThread();
            increThread.setFuckObject(object);
            threads.add(increThread);
        }
        for(Thread thread : threads){
            thread.start();
        }
        Thread.sleep(1000L);
        System.out.println(FuckObject.getCount());
    }
}
