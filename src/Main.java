import java.io.IOException;

public class Main {
    final static String IP = "localhost";
    final static int port = 8189;

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();
        try {
            server.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            client.main(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
