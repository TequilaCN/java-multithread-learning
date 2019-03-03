package chapter2.e19_synchronized_makes_variable_visible;

/**
 * synchronized会让线程中的工作缓存从主内存中更新最新值(synchronized包含了volatile的线程间可见功能)
 * 它可以同时保证线程操作的互斥性和可见性
 * 借用e16中的实验代码, 在线程中的循环部分添加synchronized代码块
 * 实验结果表明, 加了同步代码块之后, 线程在取flag进行判断的时候从主内存获取了最新的值, 线程循环成功终止
 * @Author Nacht
 * Created on 02/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        LoopThread thread = new LoopThread();
        thread.start();
        Thread.sleep(50L);
        thread.setFlag(false);
    }
}
