package chapter2.e12_string_constant_pool;

/**
 * JVM具有常量池缓存的特性,比如定义s1="a" s2="a" 那么s1和s2指向的都是同一个常量池中的常量, s1==s2
 * 如果是s1=new String("a") s2=new String("a") 那么s1和s2指向的是两个不同的对象, s1!=s2
 * 基于这个特性, 如果用String作为同步锁的话很容易出现问题, 看上去不同的两个变量实际上是指向同一个常量对象, 会导致以这个常量作为锁的所有代码块都同步执行
 * 实验中分别取了s1和s2来作为代码块的锁, 但是执行结果是互斥同步的, 说明s1和s2实质上是同一个锁
 * 所以在实际应用中, 要避免使用String来作为同步锁, 可以使用一个object对象来作为同步锁
 * @Author Nacht
 * Created on 01/03/2019
 */
public class Test {
    public static void main(String[] args) {
        final String s1 = "a";
        final String s2 = "a";
        final StringAsLockService service = new StringAsLockService();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.methodA(s1);
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                service.methodA(s2);
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
