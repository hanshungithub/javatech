package cn.hassan.thread.voliatle;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/11 22:00
 * Description:
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);

        new Thread(() -> {
            int receive;
            try {
                while ((receive = in.read()) != -1){
                    System.out.print((char)receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"PrintThread").start();

        int receive;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
}
