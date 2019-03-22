package chapter3.e16_use_inheritable_thread_local;

/**
 * InheritableThreadLocal用于将父线程的值共享给子线程
 * 设计这个类的目的是解决ThreadLocal无法实现子线程中获取父线程的值的场景
 * 需要注意的是, 子线程实例创建new Thread()的时候, 父线程必须已经向InheritableThreadLocal中set了值, 不然子线程只能获取到null或者初始值
 * 实验中子线程成功获取到了main线程也就是父线程在InheritThreadLocal中set的值(这个类名真的很难打,佛了)
 * 但是需要注意的是, 如果子线程实例创建的代码移动到父线程set值那句代码的前面,会导致子线程只能获取到初始值, 也就是第三行注释提到的那一点蛋疼的情况
 * 注意一下就行了, 也不用太冲动认真
 * 重写childValue方法还能对父线程的变量值做加工,可真牛逼啊
 * @Author Nacht
 * Created on 23/03/2019
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread is running...");
        InheritableThreadLocalUtil.inheritableThreadLocalExt.set("value(set by main thread)");
        System.out.println("main thread has set a value in threadlocal"+InheritableThreadLocalUtil.inheritableThreadLocalExt.get());
        Thread.sleep(1000L);
        Thread subThread = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("sub thread is running");
                System.out.println("the value get by sub thread from inheritable threadlocal:"+InheritableThreadLocalUtil.inheritableThreadLocalExt.get());
            }
        };
        subThread.start();
    }
}
