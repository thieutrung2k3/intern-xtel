package buffered;

import java.io.*;

public class BufferedProgram {
    public static void main(String[] args){
        // Đọc file bằng BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
