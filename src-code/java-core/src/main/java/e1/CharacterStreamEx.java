package e1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamEx {
    public static void main(String[] args) {
        try(
                FileReader reader = new FileReader("input.txt");
                FileWriter writer = new FileWriter("output.txt");
                ){
                int charData;
                while((charData = reader.read()) != -1){
                    writer.write(charData);
                }
        }catch (IOException e){

        }


    }
}
