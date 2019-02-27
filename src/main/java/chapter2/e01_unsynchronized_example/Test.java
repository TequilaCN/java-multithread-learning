package chapter2.e01_unsynchronized_example;

/**
 * 输出结果并非期望中的name=>1,age=>1和name=>2,age=>2
 * 线程1中打印的值不是自身set进去的值, 而是线程2set进去的值, 发生了线程同步问题
 * 在setNameAndAge方法前面添加synchronized关键字之后问题解决
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) {
        final UnsynchronizedObject object = new UnsynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.setNameAndAge("a",1);
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.setNameAndAge("b",2);
            }
        };
        thread1.start();
        thread2.start();
    }
}
