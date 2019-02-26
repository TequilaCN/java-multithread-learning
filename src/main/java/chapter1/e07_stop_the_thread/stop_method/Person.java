package chapter1.e07_stop_the_thread.stop_method;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class Person {
    private String name = "Jack";
    private String fuckName = "Jack";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuckName() {
        return fuckName;
    }

    public void setFuckName(String fuckName) {
        this.fuckName = fuckName;
    }
    synchronized public void setNameAndFuckName(String name , String fuckName) throws InterruptedException {
        this.name = name ;
        Thread.sleep(10000L);//此处线程沉睡10s,在这个过程中线程将被stop方法强制终止
        this.fuckName = fuckName;
    }
}
