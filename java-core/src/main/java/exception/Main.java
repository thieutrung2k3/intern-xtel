package exception;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Lỗi chia cho 0!");
        } finally {
            System.out.println();
        }
    }

    public void readFile(String path) throws IOException {
        handlingException();
    }

    public void  handlingException() throws IOException {

        throw new IOException();
    }



}
