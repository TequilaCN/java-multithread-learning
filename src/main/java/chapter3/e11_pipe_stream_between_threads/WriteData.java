package chapter3.e11_pipe_stream_between_threads;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Author Nacht
 * Created on 12/03/2019
 */
public class WriteData {
    public void writeData(PipedOutputStream outputStream){
        String message = "fuck you read thread";
        try{
            System.out.println("write thread begin writing");
            outputStream.write(message.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
