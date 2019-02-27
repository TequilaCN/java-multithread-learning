package chapter2.e03_dirty_read;

/**
 * 脏读:一个线程读到了另外一个线程上做了修改的数据,但是另外一个线程尚未执行完成, 导致该线程读到错误的或者不完整的数据
 * 类比数据库中的脏读: 脏读又称无效数据的读出，是指在数据库访问中，事务T1将某一值修改，然后事务T2读取该值，
 *                  此后T1因为某种原因撤销对该值的修改，这就导致了T2所读取到的数据是无效的。 脏读就是指
 *                  当一个事务正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，这时，
 *                  另外一个事务也访问这个数据，然后使用了这个数据。
 * 该实验中main线程读到了被thread1修改的部分数据, 导致取到的数据不完整(name: nameB , password: passwordA, 为被thread1修改到一半的数据)
 * 在读方法加上synchronized关键字可以解决这个问题(其他线程必须等获得锁的线程执行完毕之后才能进行读操作)
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final FuckObject object = new FuckObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                object.setNameAndPassword("nameB","passwordB");
            }
        };
        thread1.start();
        Thread.sleep(500L);
        object.printNameAndPassword();
    }
}
