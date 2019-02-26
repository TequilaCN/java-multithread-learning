package chapter1.e09_yield_method;

/**
 * yield()方法:放弃当前的CPU资源,让给其他任务去占用CPU执行时间,但是放弃时间不确定
 * 可能刚放弃又马上获得CPU时间片
 * 如果在IncrementThread的run方法中的循环体中调用yield方法, 可以看到执行时间明显变长
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();
    }
}
