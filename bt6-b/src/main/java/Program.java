import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final String FILE_NAME = "number.txt";
    private static volatile boolean running = true;
    public static void main(String[] args) {
        Thread inputThread = new Thread(() ->{
            Scanner sc = new Scanner(System.in);
            while(running){
                String command = sc.nextLine();
                if("stop".equalsIgnoreCase(command)){
                    running = false;
                    System.out.println("This program has been stop.");
                    break;
                }
            }
            sc.close();
        });

        inputThread.setDaemon(true);
        inputThread.start();

        Random random = new Random();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));){
            while (running){
                int num = random.nextInt();
                writer.write(num);
                writer.newLine();
                writer.flush();
                System.out.println("Number: " + num);
                Thread.sleep(1000);
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
