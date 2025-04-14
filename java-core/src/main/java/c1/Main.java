package c1;

public class Main {
    public static void main(String[] args) {
        /**
         * Kiem tra num va chay dieu kien dung
         */
        int num = 2;
        if(num % 2 == 0){
            System.out.println("Num la so chan.");
        } else{
            System.out.println("Num la so le");
        }

        /**
         * For: duyet tung phan tu i va in ra tu 1-> 10
         */
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        /**
         * while: Kiem tra dieu kien truoc khi chay
         *  ==> Result: Count: 10
         */
        int count = 10;
        while(count < 10){
            count++;
        }
        System.out.println("Count: " + count);


        /**
         * do-while: Chay truoc roi moi kiem tra dieu kien
         * ==> Result: Num1:
         */
        int num1 = 10;
        do {
            num1--;
        }while (num1 < 10 && num1 > 0);
        System.out.println("Num1: " + num1);

        /**
         * Kiem tra gia tri cua num2 xem vao truong hop nao
         * , neu khong ton tai thi se nhay vao default
         */
        int num2 = 5;
        switch (num2){
            case 0:
                System.out.println("This is number 0.");
                break;
            case 5:
                System.out.println("This is number 5");
                break;
            default:
                System.out.println("Invalid number.");
                break;
        }

    }
}
