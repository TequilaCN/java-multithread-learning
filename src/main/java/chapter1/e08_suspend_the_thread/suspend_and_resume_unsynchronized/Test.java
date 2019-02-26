package chapter1.e08_suspend_the_thread.suspend_and_resume_unsynchronized;

/**
 * suspend的缺点:如果在线程处理过程中被suspend了, 后续的处理过程无法执行, 可能会导致数据不同步
 * @Author Nacht
 * Created on 27/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final Person person = new Person() ;
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                person.setNameAndFuckName("Paul","Paul");//如果线程名字为a,此方法执行到一半时线程将挂起,导致数据不一致(set了第一个值之后就挂起了)
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500L);
        System.out.println("name: "+person.getName()+", fuck name: "+person.getFuckName());
    }
}
