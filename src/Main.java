import java.io.IOException;

public class Main {
    static final String IP = "localhost";
    static final int PORT = 8189;

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Server.go();
            }
        });

        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                client.go();
            }
        }).start();
    }
}
