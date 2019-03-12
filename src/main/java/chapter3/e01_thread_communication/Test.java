package chapter3.e01_thread_communication;

/**
 * 该实验中线程1和线程2通过线程2的while(true)进行不断轮询操作达到线程之间通信的效果
 * 但是这种方式如果轮询时间很小, 会比较耗费cpu资源, 如果轮询时间很长, 会导致可能取不到想要的数据
 * @Author Nacht
 * Created on 05/03/2019
 */
public class Test {
    public static void main(String[] args) {
        TestList testList = new TestList();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0 ; i < 10 ; i++) {
                    try {
                        testList.add();
                        System.out.println("list size:"+testList.getSize());
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    while (true) {
                        Thread.sleep(50L);//加一小段sleep, 让thread2有机会获取testList的主存最新值
                        if (testList.getSize()==5){
                            throw new InterruptedException();
                        }
                    }
                }catch (Exception e){
                    System.out.println("the size of list is larger than 5, thread-2 will exit.");
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
