package tcp;

import util.ConfigUtil;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Map<String, String> mapConfig = ConfigUtil.readConfigFile();
        int port = Integer.parseInt(mapConfig.get("port"));

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            // luồng nhận tin nhắn từ client
            Thread receiveThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected.");
                }
            });

            // luồng gửi tin nhắn đến client
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
