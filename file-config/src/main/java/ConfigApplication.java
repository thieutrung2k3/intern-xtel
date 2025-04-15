import java.io.*;
import java.util.Properties;

public class ConfigApplication {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream input = ConfigApplication.class.getClassLoader().getResourceAsStream("config.properties")) {
            if(input == null){
                System.out.println("Can not find config file.");
                return;
            }
            props.load(input);
            String port = props.getProperty("port");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            System.out.println("Port: " + port);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
