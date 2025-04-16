package tcp;

import util.ConfigUtil;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Map<String, String> mapConfig = ConfigUtil.readConfigFile();
        String hostname = mapConfig.get("hostname");
        int port = Integer.parseInt(mapConfig.get("port"));

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server.");

            // luồng nhận tin nhắn từ server
            Thread receiveThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Server disconnected.");
                }
            });

            // luồng gửi tin nhắn đến server
            Thread sendThread = new Thread(() -> {
                try {
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    Scanner scanner = new Scanner(System.in);
                    String msg;
                    while (true) {
                        msg = scanner.nextLine();
                        writer.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("Cannot send message.");
                }
            });

            receiveThread.start();
            sendThread.start();

            receiveThread.join();
            sendThread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
