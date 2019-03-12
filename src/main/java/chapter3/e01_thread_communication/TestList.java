package chapter3.e01_thread_communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Nacht
 * Created on 05/03/2019
 */
public class TestList {
    private List list = new ArrayList();
    public void add(){
        this.list.add("fuck");
    }
    public int getSize(){
        return this.list.size();
    }
}
