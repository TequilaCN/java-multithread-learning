package chapter3.e10_multi_produce_and_consumption;

/**
 * @Author Nacht
 * Created on 12/03/2019
 */
public class ProduceThread extends Thread {
    private Produce produce;

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        super.run();
        try {
            produce.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
