package chapter1.e07_stop_the_thread.interrupt_break;

/**
 * 判断interrupt状态+break退出循环的方法终止线程并不能真正停止线程, 在for循环外面的代码逻辑将被继续执行
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        InterruptAndBreakThread interruptAndBreakThread = new InterruptAndBreakThread();
        interruptAndBreakThread.start();
    }
}
