package udp;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9876;

        Scanner sc = new Scanner(System.in);
        String msg;

        try {
            DatagramSocket socket = new DatagramSocket();

            while (true) {
                System.out.print("Enter message to send to server: ");
                msg = sc.nextLine();
                byte[] sendData = msg.getBytes();

                InetAddress serverAddress = InetAddress.getByName(hostname);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
                socket.send(sendPacket);  // Gửi dữ liệu tới server

                // Nếu nhập "exit" thì thoát
                if ("exit".equalsIgnoreCase(msg)) {
                    System.out.println("Closing connection...");
                    break;
                }

                // Nhận phản hồi từ server
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + response);
            }

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, "Communication error", ex);
        }
    }
}
