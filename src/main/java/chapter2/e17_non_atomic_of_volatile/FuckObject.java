package chapter2.e17_non_atomic_of_volatile;

/**
 * @Author Nacht
 * Created on 03/03/2019
 */
public class FuckObject {
    private static volatile int count = 0 ;

    public static int getCount() {
        return count;
    }

    public  static void increCount(){
        for(int i = 0 ; i < 50 ; i++) {
            try {
                count++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("the value of count:" + count);
    }
}
