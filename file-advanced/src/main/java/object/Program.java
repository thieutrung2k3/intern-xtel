package object;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))) {
            int number = dis.readInt();
            double decimal = dis.readDouble();
            boolean flag = dis.readBoolean();
            String text = dis.readUTF();

            System.out.println("Integer: " + number);
            System.out.println("Double: " + decimal);
            System.out.println("Boolean: " + flag);
            System.out.println("String: " + text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
