package chapter3.e11_pipe_stream_between_threads;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Author Nacht
 * Created on 12/03/2019
 */
public class ReadData {
    public void readData(PipedInputStream inputStream){
        try {
            System.out.println("read thread begin reading");
            byte[] bytes = new byte[20];
            int readLength = inputStream.read(bytes);
            while(readLength!=-1){
                String newData = new String(bytes);
                System.out.print("read data ==>" + newData);
                readLength = inputStream.read(bytes);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
