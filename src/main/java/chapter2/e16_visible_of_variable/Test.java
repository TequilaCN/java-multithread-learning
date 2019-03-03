package chapter2.e16_visible_of_variable;

/**
 * jvm的线程在运行的时候, 会有独自的一个线程缓存, 如果不使用volatile关键字的话, 一个变量的值原则上不会自动从主存刷新到线程的工作内存中
 * 也就是说, volatile保证了变量更新时的线程间可见性
 * 实验中flag不加volatile关键字时主线程设置的flag无法被thread1获取到, 导致thread中的循环无法退出
 * 加了volatile关键字时候, thread会从主内存中刷新flag变量的值, 退出循环
 * 但是需要特别注意的是, 如果线程的循环中有System.out.println()或者sleep等会释放cpu资源的操作时即使不加volatile关键字循环也会终止
 * 因为：JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字。换句话说，只要CPU有时间，JVM会尽力去保证变量值的更新。
 * 这种与volatile关键字的不同在于，volatile关键字会强制的保证线程的可见性。而不加这个关键字，JVM也会尽力去保证可见性，但是如果CPU一直有其他的事情在处理，它也没办法。
 * 最开始的代码，一直处于死循环中，CPU处于一直占用的状态，这个时候CPU没有时间，JVM也不能强制要求CPU分点时间去取最新的变量值。
 * 而加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，于是while循环可以被终止。
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
