import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    /**
     * разукрасим наш скучный чат
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        final int port = 8189;

        try {
            server = new ServerSocket(port);
            System.out.println("Я готов! Подождём с кем пообщаться....");

            socket = server.accept();
            System.out.println(ANSI_YELLOW + "Ну наконец-то, слава боту ты пришёл!" + ANSI_RESET);

            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true){
                String str = scanner.nextLine();
                if (str.equals("Давай до свидания")) {
                    System.out.println(ANSI_RED + "Ну ты заходи, если чо!" + ANSI_RESET);
                    break;
                }
                out.println("echo " + ANSI_GREEN + str + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
