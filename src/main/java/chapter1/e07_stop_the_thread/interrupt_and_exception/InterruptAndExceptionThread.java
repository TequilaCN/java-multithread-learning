package chapter1.e07_stop_the_thread.interrupt_and_exception;

/**
 * 判断interrupt状态+exception的方法可以让正在执行的线程终止, 并且有利于抛出异常, 让上层代码做处理
 * @Author Nacht
 * Created on 26/02/2019
 */
public class InterruptAndExceptionThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 1; i < 100; i++) {
                System.out.println("current count: " + i);
                if (i == 50) {
                    System.out.println("i comes to 50 ,thread interrupt!");
                    this.interrupt();
                }
                if (this.isInterrupted()) {
                    throw new InterruptedException();
                }
            }
            System.out.println("this is the code behind the loop , it will not be printed");
        }catch (InterruptedException e){
            System.out.println("interrupted exception catched");
            e.printStackTrace();
        }
    }
}
