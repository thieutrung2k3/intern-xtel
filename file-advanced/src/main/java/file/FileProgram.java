package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileProgram {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("example.txt"));
        lines.forEach(System.out::println);

        Files.write(Paths.get("newfile.txt"), Arrays.asList("Dòng 1", "Dòng 2"));

    }
}
