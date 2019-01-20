import java.io.*;
import java.net.*;

public class Server {
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";

    public static void go(){
        DataInputStream in;
        DataOutputStream out;

        ServerSocket server = null;
        Socket  socket = null;

        try {
            server = new ServerSocket(Main.PORT);
            System.out.println("Сервер запущен!");
        } catch (IOException e) {
            System.out.println("\u001B[31m Не получилось завести сервер на " + Main.IP +
                               " \u001B[31m порту.\nПохоже, что уже запущен, или порт занят. " +
                               "\nПопробуйте поменять порт");
        }

        try {
            System.out.print("Ожидаем подключаения клиента...");
            socket= server.accept();
            System.out.println("Слава боту он пришёл.");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true){
                String str = in.readUTF();
                if (str.equals("/end")) break;
                out.writeUTF(str);
            }
        } catch (IOException e) {
            System.out.println("Не могу подключить.");
            System.exit(-1);
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(){
        //
    }
}