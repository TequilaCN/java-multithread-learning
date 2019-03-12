package chapter3.e10_multi_produce_and_consumption;

/**
 * 多个消费者/多个生产者模式时可能会产生死锁, 死锁过程分析如下:
 * 实验中启动了两个生产者和两个消费者(由于在本机测试环境中notify随机性表现不出来,需打乱线程启动的顺序来使之出现假死效果)
 * 分析实验日志如下:
 * Thread:consumption-thread-1, begin waiting                       =>1.消费者线程1被start()启动,发现没值, 开始waiting
 * produce-thread-2,produce:1552335598088_269996467096078           =>2.生产者线程2被start()启动,生产了一个值,调用notify(),并进入下一个循环
 * Thread:produce-thread-2, begin waiting                           =>3.生产者线程2在下一个循环发现有值, 开始waiting
 * consumption-thread-2,consumption:1552335598088_269996467096078   =>4.消费者线程2被start()启动, 消费了值, 并调用notify(), 进入下一个循环
 * Thread:consumption-thread-2, begin waiting                       =>5.消费者线程2在下一个循环发现没值, 开始waiting
 * produce-thread-1,produce:1552335600092_269998471227732           =>6.生产者线程1被start启动,生产了一个值,并调用notify(), 进入下一个循环
 * Thread:produce-thread-1, begin waiting                           =>7.生产者线程1在下一个循环发现有值, 开始waiting
 * consumption-thread-2,consumption:1552335600092_269998471227732   =>8.消费者线程2被唤醒获得锁,消费了值并调用notify(), 进入下一个循环
 * Thread:consumption-thread-2, begin waiting                       =>9.消费者线程2在下一个循环发现没值, 开始waiting
 * produce-thread-2,produce:1552335602094_270000473304421           =>10.生产者线程2被唤醒获得锁,生产了一个值,并调用notify(), 进入下一个循环
 * Thread:produce-thread-2, begin waiting                           =>11.生产者线程2在下一个循环发现有值, 开始waiting
 * consumption-thread-1,consumption:1552335602094_270000473304421   =>12.消费者线程1被唤醒获得锁,消费了值并调用notify(), 进入下一个循环
 * Thread:consumption-thread-1, begin waiting                       =>13.消费者线程1在下一个循环发现没值, 开始waiting
 * Thread:consumption-thread-2, begin waiting                       =>14.消费者线程2被唤醒,发现没有值, 开始waiting
 * produce-thread-1,produce:1552335604105_270002483729977           =>15.生产者线程1被唤醒,生产了一个值,并调用notify(), 进入下一个循环
 * Thread:produce-thread-1, begin waiting                           =>16.生产者线程1在下一个循环发现有值, 开始waiting
 * Thread:produce-thread-2, begin waiting                           =>17.生产者线程2被唤醒,发现有值,开始waiting
 * consumption-thread-1,consumption:1552335604105_270002483729977   =>18.消费者线程1被唤醒,发现有值,消费了值并调用notify(), 进入下一个循环
 * Thread:consumption-thread-1, begin waiting                       =>19.消费者线程1在下一个循环发现没值, 开始waiting
 * Thread:consumption-thread-2, begin waiting                       =>20.消费者线程2被唤醒,发现没有值, 开始waiting
 * notify()被调用8次,所有线程也总共被唤醒8次,出现假死原因是出现了消费者唤醒消费者和生产者唤醒生产者
 * 可能的一种顺序如下:
 * 消费者1唤醒消费者2后waiting=>消费者2waiting
 * 生产者1唤醒生产者2后waiting=>生产者2waiting
 * 全部线程waiting
 * 这个东西分析看起来很鸡巴复杂, 实际上记住假死是由同类线程唤醒造成的就行了
 * 解决办法:将notify换成notifyAll, 这个实验唯一的目的就是浪费时间, 草
 * 总结一波生产者模式/消费者模式
 * a.在对象的生产和消费时, 必须调用notifyAll而不是notify, 否则容易出现线程假死
 * b.在对象的生产和消费做判断是否存在可消费对象时, 要用while循环而不是if做判断, 否则容易出现异常(一个对象被消费两次)
 * 我知道这样说你可能不明白, a点看这个实验, b点看e08, 好好复习
 * @Author Nacht
 * Created on 12/03/2019
 */
public class Test {
    public static void main(String[] args) {
        Object lock =new Object() ;
        Consumption consumption = new Consumption();
        Produce produce = new Produce();
        consumption.setLock(lock);
        produce.setLock(lock);
        ConsumptionThread conThread1 = new ConsumptionThread();
        ConsumptionThread conThread2 = new ConsumptionThread();
        ProduceThread produceThread1 = new ProduceThread();
        ProduceThread produceThread2 = new ProduceThread();
        conThread1.setConsumption(consumption);
        conThread2.setConsumption(consumption);
        produceThread1.setProduce(produce);
        produceThread2.setProduce(produce);
        conThread1.setName("consumption-thread-1");
        conThread2.setName("consumption-thread-2");
        produceThread1.setName("produce-thread-1");
        produceThread2.setName("produce-thread-2");
        conThread1.start();
        produceThread1.start();
        conThread2.start();
        produceThread2.start();
    }
}
