package chapter2.e08_synchronized_code_block;

/**
 * @Author Nacht
 * Created on 28/02/2019
 */
public class PartSynchronizedObject {
    public void doTask(){
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("[asynchronized] current thread: "+Thread.currentThread().getName()+"===>"+i);
        }
        try{
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        synchronized (this){
            for(int i = 0 ; i < 10 ; i++){
                System.out.println("[synchronized] current thread: "+Thread.currentThread().getName()+"===>"+i);
            }
        }
    }
}
