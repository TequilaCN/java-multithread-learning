package chapter3.e08_condition_change_while_waiting;

/**
 * @Author Nacht
 * Created on 10/03/2019
 */
public class Add {
    private Object lock ;
    public void setLock(Object lock){
        this.lock = lock ;
    }
    public void addList(Object o){
        synchronized (lock){
            System.out.println("begin add by thread:"+Thread.currentThread().getName());
            ListObject.list.add(o);
            System.out.println("end add by thread:"+Thread.currentThread().getName());
            lock.notifyAll();
        }
    }
}
