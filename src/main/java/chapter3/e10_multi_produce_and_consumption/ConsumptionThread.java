package chapter3.e10_multi_produce_and_consumption;

/**
 * @Author Nacht
 * Created on 12/03/2019
 */
public class ConsumptionThread extends Thread{
    private Consumption consumption ;
    public void setConsumption(Consumption consumption){
        this.consumption = consumption;
    }
    @Override
    public void run() {
        super.run();
        try {
            consumption.concumption();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
