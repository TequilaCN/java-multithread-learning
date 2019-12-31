package chapter4.e04_read_write_lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Nacht
 * Created on 2019/12/31
 */
public class ReadWriteService {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read(){
        try{
            readWriteLock.readLock().lock();
            System.out.println("read begin:"+Thread.currentThread().getName());
            Thread.sleep(10000L);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
            System.out.println("read end:"+Thread.currentThread().getName());
        }

    }
    public void write(){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("write begin:"+Thread.currentThread().getName());
            Thread.sleep(10000L);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
            System.out.println("write end:"+Thread.currentThread().getName());
        }

    }
}
