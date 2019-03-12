package chapter3.e02_call_wait_func_outside_sync_block;

/**
 * wait和notify方法只能在synchronized代码块中执行, 并且只能在获得对象锁之后执行
 * 下面的代码运行之后会抛出异常 Exception in thread "main" java.lang.IllegalMonitorStateException
 * @Author Nacht
 * Created on 06/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        String lock = "fuck";
        lock.wait();
//        lock.notify();
    }
}
