package chapter3.e11_pipe_stream_between_threads;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedInputStream和PipedOutputStream用于线程间传输字节流, 还有一个PipedReader和PipedWriter, 用于传输字符流
 * 一个屌样, 记住用法即可
 * @Author Nacht
 * Created on 12/03/2019
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        inputStream.connect(outputStream);
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();
        Thread readThread = new Thread(){
            @Override
            public void run() {
                super.run();
                readData.readData(inputStream);
            }
        };
        Thread writeThread = new Thread(){
            @Override
            public void run() {
                super.run();
                writeData.writeData(outputStream);
            }
        };
        readThread.start();
        Thread.sleep(2000L);
        writeThread.start();
    }
}
