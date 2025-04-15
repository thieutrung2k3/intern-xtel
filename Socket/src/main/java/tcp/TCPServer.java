package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int port = 1234;
        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server is listening on port: " + port);
            while(true){
                Socket socket = server.accept();
                System.out.println("New client connected.");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String msg = reader.readLine();

                System.out.println("Received from client: " + msg);

                writer.println("You sent: " + msg);

                socket.close();
            }
        }catch(IOException e){
        }
    }
}

