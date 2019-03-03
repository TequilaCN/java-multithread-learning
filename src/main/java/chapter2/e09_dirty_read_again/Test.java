package chapter2.e09_dirty_read_again;

/**
 * 虽然在LimitOneListObject中对同一个list的读操作和写操作都是原子性的
 * 但是读=>判断=>写这个操作无法保证其原子性
 * 实验中模拟脏读的过程:
 * thread1判断list size是否小于1(true)
 * thread2判断list size是否小于1(true)
 * thread1向list中添加一条数据
 * thread2向list中添加一条数据
 * 最终list中有两条数据
 * @Author Nacht
 * Created on 28/02/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final LimitOneListObject object = new LimitOneListObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                if(object.getListSize()<1) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.add("data1");
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                if(object.getListSize()<1) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.add("data2");
                }
            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(3000L);
        System.out.println("the size of limitone list:"+object.getListSize());
    }
}
