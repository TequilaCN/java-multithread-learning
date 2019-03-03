package chapter2.e09_dirty_read_again;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Nacht
 * Created on 28/02/2019
 */
public class LimitOneListObject {
    private List<String> list = new ArrayList<String>();
    synchronized public void add(String data){
            list.add(data);
    }
    synchronized public int getListSize(){
        return list.size();
    }
}
