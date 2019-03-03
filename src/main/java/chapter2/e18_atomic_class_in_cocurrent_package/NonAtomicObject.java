package chapter2.e18_atomic_class_in_cocurrent_package;

/**
 * @Author Nacht
 * Created on 03/03/2019
 */
public class NonAtomicObject {
    private int count = 0 ;
    public int getCount() {
        return count;
    }
    public void increCount(){
        for(int i = 0 ; i < 50 ; i++) {
            System.out.println("current count:" + count++ + " , operated by thread:" + Thread.currentThread().getName());
        }
    }
}
