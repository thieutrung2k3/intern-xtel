package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        Scanner sc = new Scanner(System.in);
        String msg;

        try {
            while (true) {
                // Mở kết nối mỗi lần gửi tin nhắn
                try (Socket socket = new Socket(hostname, port);
                     OutputStream output = socket.getOutputStream();
                     PrintWriter writer = new PrintWriter(output, true);
                     InputStream input = socket.getInputStream();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

                    System.out.print("Enter message to send to server: ");
                    msg = sc.nextLine();
                    writer.println(msg);  // Gửi thông điệp đến server

                    // Nếu người dùng nhập "exit", thoát khỏi vòng lặp
                    if ("exit".equalsIgnoreCase(msg)) {
                        System.out.println("Closing connection...");
                        break;
                    }

                    // Nhận phản hồi từ server
                    String response = reader.readLine();
                    System.out.println("Server response: " + response);

                } catch (IOException ex) {
                    Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, "Error during connection", ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, "General error", ex);
        }
    }
}
