package chapter1.e05_decrement_and_sout;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class DecrementThread extends Thread{
    private int count = 10 ;
    @Override
    public void run() {
        super.run();
        while(count>0) {
            System.out.println("operated by thread:" + currentThread().getName() + " the current count value:" + (count--));
        }
    }
}
