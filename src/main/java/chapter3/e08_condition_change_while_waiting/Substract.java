package chapter3.e08_condition_change_while_waiting;

/**
 * @Author Nacht
 * Created on 10/03/2019
 */
public class Substract {
    private Object lock ;
    public void setLock(Object lock){
        this.lock = lock ;
    }
    public void substractList() throws InterruptedException {
        synchronized (lock){
            System.out.println("begin substract by thread:"+Thread.currentThread().getName());
            if(ListObject.list.size() == 0 ){ //此处改为whlie可避免抛出数组越界异常
                lock.wait();
            }
            ListObject.list.remove(0);
            System.out.println("end substract by thread:"+Thread.currentThread().getName());
        }
    }
}
