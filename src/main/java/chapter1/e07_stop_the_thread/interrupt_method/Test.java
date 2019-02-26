package chapter1.e07_stop_the_thread.interrupt_method;

/**
 * 直接调用interrupt方法不会导致线程停止, 仅仅是添加一个标志位, 此时调用Thread.interrupted()或this.isInterrupted()将返回true
 * Thread.interrupted()和this.isInterrupted()区别
 * Thread.interrupted()调用一次后会清除掉标志位(连续调用两次第二次将返回false)
 * this.isInterrupted()无论调用多少次都会保持标志位
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
    }
}
