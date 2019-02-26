package chapter1.e03_variable_share_unsafe;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class UnsafeThread extends Thread{
    private int count = 5 ;
    @Override
    public void run() {
        super.run();
        while(count > 0) {
            count--;
            System.out.println("operated by thread:" + currentThread().getName() +"before operated count:"+(count+1)+ ", current count:" + count);
        }
    }
}
