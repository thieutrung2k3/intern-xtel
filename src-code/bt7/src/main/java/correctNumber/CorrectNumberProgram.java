package correctNumber;

import common.ConfigUtil;

import java.util.Map;
import java.util.Scanner;

public class CorrectNumberProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Lay gia tri tu file config
        Map<String, String> configMap = ConfigUtil.readConfigFile();

        //Lay theo property
        int correctNumber = Integer.parseInt(configMap.get("correct.number"));
        int maxAttempts = Integer.parseInt(configMap.get("max.attempts"));

        System.out.print("Enter your number: ");
        while (maxAttempts >= 1){
            int yourNumber = scanner.nextInt();
            if(yourNumber == correctNumber){
                System.out.println("\nYour number is correct.");
                break;
            }
            System.out.println("Your number isn't correct.");
            maxAttempts--;
        }
    }
}
