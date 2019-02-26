package chapter1.e07_stop_the_thread.stop_method;

/**
 * @Author Nacht
 * Created on 26/02/2019
 */
public class StopThread extends Thread{
    private Person person ;
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("thread running...");
        try {
            person.setNameAndFuckName("Paul","Paul");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            System.out.println("the code in finally block will be executed even if the thread was forced to be stop .");
        }
    }
}
