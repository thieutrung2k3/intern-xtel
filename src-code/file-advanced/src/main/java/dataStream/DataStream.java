package dataStream;

import java.io.*;

public class DataStream {
    public static void main(String[] args) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
            DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))){
            dos.writeInt(100);
            dos.writeBoolean(false);
            dos.writeDouble(3.14);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
