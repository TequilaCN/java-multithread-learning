package chapter1.e08_suspend_the_thread.suspend_and_resume_unsynchronized;

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
    synchronized public void setNameAndFuckName(String name , String fuckName)  {
        this.name = name ;
        if(Thread.currentThread().getName().equals("a")){
            Thread.currentThread().suspend();
        }
        this.fuckName = fuckName;
    }
}
