package chapter3.e15_use_thread_local;

/**
 * ThreadLocal的作用: 每个线程get的时候都会取到自己set的值, 互不干扰
 * 具体的细节这里就不多bb了, 看下代码就懂了
 * @Author Nacht
 * Created on 15/03/2019
 */
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    for (int i = 0; i < 10; i++) {
                        ThreadLocalUtil.threadLocal.set(Thread.currentThread().getName()+" "+String.valueOf(i));
//                        System.out.println(Thread.currentThread().getName() + " set value: " + i);
                        Thread.sleep(2000L);
                        System.out.println(Thread.currentThread().getName()+" get value: "+ThreadLocalUtil.threadLocal.get());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    for (int i = 0; i < 10; i++) {
                        ThreadLocalUtil.threadLocal.set(Thread.currentThread().getName()+" "+String.valueOf(i));
//                        System.out.println(Thread.currentThread().getName() + " set value: " + i);
                        Thread.sleep(2000L);
                        System.out.println(Thread.currentThread().getName()+" get value: "+ThreadLocalUtil.threadLocal.get());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start();
        thread2.start();
    }
}
