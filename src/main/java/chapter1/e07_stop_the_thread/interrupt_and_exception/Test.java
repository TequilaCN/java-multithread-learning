package chapter1.e07_stop_the_thread.interrupt_and_exception;

/**
 *
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        InterruptAndExceptionThread interruptAndExceptionThread = new InterruptAndExceptionThread();
        interruptAndExceptionThread.start();
    }
}
