package electricMoney;

import common.ConfigUtil;

import java.util.Map;
import java.util.Scanner;

public class ElectricNumberProgram {
    public static void main(String[] args) {
        Map<String, String> configMap = ConfigUtil.readConfigFile();

        int range1 = Integer.parseInt(configMap.get("range1.max"));
        int range2 = Integer.parseInt(configMap.get("range2.max"));
        int price1 = Integer.parseInt(configMap.get("range1.price"));
        int price2 = Integer.parseInt(configMap.get("range2.price"));
        int price = Integer.parseInt(configMap.get("range3.price"));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter you electric number: ");
        int num = scanner.nextInt();
        System.out.print("\nYour price: ");
        if (num <= 100){
            System.out.println(num * 1000);
        } else if (num > 100 && num < 150) {
            System.out.println(100 * 1000 + (num - 100) * 1500);
        } else{
            System.out.println(100 * 1000 + 149 * 1500 + (num - 249) * 2000);
        }
    }
}
