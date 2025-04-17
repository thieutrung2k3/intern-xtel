import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final String FILE_NAME = "number.txt";
    private static volatile boolean running = true;
    public static void main(String[] args) {
        final int mTime = 1;
        final long startTime = System.currentTimeMillis();
        final long duration = mTime * 60 * 1000;
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
               long checkTime = System.currentTimeMillis() - startTime;
               if(checkTime >= duration){
                   running = false;
               }

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
