package chapter3.e09_single_produce_and_consumption;

/**
 * 单消费者&单生产者模式:如果有值=>生产者wait,消费者消费后notify, 如果没有值=>消费者wait,生产者生产后notify
 * @Author Nacht
 * Created on 11/03/2019
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        Consumption consumption = new Consumption();
        Produce produce = new Produce();
        consumption.setLock(lock);
        produce.setLock(lock);
        Thread produceThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    produce.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumptionThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    consumption.concumption();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        produceThread.start();
        consumptionThread.start();
    }
}
