package e1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try (
                FileInputStream in = new FileInputStream("input.txt");
                FileOutputStream out = new FileOutputStream("output.txt");
        ) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData); // ghi từng byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
