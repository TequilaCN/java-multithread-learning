package chapter2.e15_when_the_attribute_of_lock_changes;

/**
 * @Author Nacht
 * Created on 02/03/2019
 */
public class SelfLock {
    private String name = "defaultName";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
