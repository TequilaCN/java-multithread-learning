package chapter2.e13_dead_lock;

/**
 * @Author Nacht
 * Created on 01/03/2019
 */
public class DeadLockService {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private String name ;
    public void setName(String name){
        this.name = name;
    }
    public void fuck() {
        //如果name为fuck1,先获取lock1再获取lock2
        if("fuck1".equals(name)){
            synchronized (lock1){
                System.out.println("lock1 was acquired by thread:"+Thread.currentThread().getName()+", trying to get lock2");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock2 was acquired by thread:"+Thread.currentThread().getName());
                }
            }
        }
        if("fuck2".equals(name)){
            synchronized (lock2){
                System.out.println("lock2 was acquired by thread:"+Thread.currentThread().getName()+", trying to get lock1");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("lock1 was acquired by thread:"+Thread.currentThread().getName());
                }
            }
        }
    }
}
