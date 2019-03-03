package chapter2.e17_non_atomic_of_volatile;

/**
 * @Author Nacht
 * Created on 03/03/2019
 */
public class IncreThread extends Thread {
    private FuckObject fuckObject ;

    public void setFuckObject(FuckObject fuckObject) {
        this.fuckObject = fuckObject;
    }

    @Override
    public void run() {
        super.run();
        fuckObject.increCount();
    }
}
