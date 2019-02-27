package chapter2.e01_unsynchronized_example;

/**
 * @Author Nacht
 * Created on 27/02/2019
 */
public class UnsynchronizedObject {
    private String name ;
    private int age ;
    public void setNameAndAge(String name , int age ) {
        this.name = name ;
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            System.out.println("sleep interrupted exception");
            e.printStackTrace();
        }
        this.age = age ;
        System.out.println("name:"+this.name+", age:"+this.age);
    }
}
