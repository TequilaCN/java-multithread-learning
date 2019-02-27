package chapter2.e07_asynchronized_in_overwrite;

/**
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Son extends Father {
    @Override
    public void overwriteMe() throws InterruptedException {
        super.overwriteMe();
        System.out.println("function overwriteMe in Son executed by thread:"+Thread.currentThread().getName());
        Thread.sleep(2000L);
        System.out.println("function overwriteMe in Son executed end by thread:"+Thread.currentThread().getName());
    }
}
