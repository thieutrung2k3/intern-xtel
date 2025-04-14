package e1;

import java.io.*;

public class BufferedFileEx {
    public static void main(String[] args) {
        try(
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
                ){
            String newline;
            while ((newline = reader.readLine()) != null){
                writer.write(newline);
                writer.newLine();
            }
        }
        catch (IOException e){

        }
    }
}
