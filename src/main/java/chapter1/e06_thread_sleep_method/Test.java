package chapter1.e06_thread_sleep_method;

/**
 * Thread.sleep()方法是让<b>当前正在调用这句代码的线程</b>沉睡一定的时间
 * 如下测试例子,如果是sleepThread.run()的话是main线程对run方法进行调用,所以调用sleep的时候是main线程沉睡
 * 输出结果:
 * main start sleep, current time:1551173392773
 * main end sleep, current time:1551173394775
 * 如果是sleepThread.start()的话是sleepThread这个线程对run方法进行调用,所以调用sleep方法的时候是sleepThread线程沉睡
 * 输出结果:
 * sleep-thread start sleep, current time:1551173394776
 * sleep-thread end sleep, current time:1551173396779
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Test {
    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        sleepThread.setName("sleep-thread");
        sleepThread.run();
//      sleepThread.start();
    }
}
