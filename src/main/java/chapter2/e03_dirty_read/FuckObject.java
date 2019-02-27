package chapter2.e03_dirty_read;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class FuckObject {
    private String name = "nameA";
    private String password = "passwordA";
    synchronized public void setNameAndPassword(String name , String password){
        try{
            this.name = name ;
            Thread.sleep(5000L);
            this.password = password;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void printNameAndPassword(){
        System.out.println("name: "+name+" , password: "+password);
    }
}
