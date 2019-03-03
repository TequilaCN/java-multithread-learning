package chapter2.e08_synchronized_code_block;

/**
 * 可以通过synchronized同步语句块来实现一个方法中部分代码(同步语句块中的代码)同步执行, 部分代码(同步语句块外的代码)异步执行
 * 实验中将doTask方法分为两部分:同步语句块和非同步语句块
 * 执行结果可以看出, 同步语句块中的代码都同步执行, 非同步语句块中的代码线程交替执行
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Test {
    public static void main(String[] args) {
        final PartSynchronizedObject object = new PartSynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.doTask();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.doTask();
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
