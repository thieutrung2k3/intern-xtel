package e1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("input.txt");
                FileWriter writer = new FileWriter("output.txt");
        ) {
            int charData;
            while ((charData = reader.read()) != -1) {
                writer.write(charData); // ghi từng ký tự
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
