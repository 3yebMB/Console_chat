import java.io.*;
import java.net.*;

public class Client {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    final static int PORT = 8189;

    DataInputStream in;
    DataOutputStream out;
    PrintWriter pw;
    Socket socket = null;

    public void go(){
        System.out.println(ANSI_YELLOW + "Добро пожаловать в олдскульный консольный чат" + ANSI_RESET);

        System.out.println("Соеденяемся с сервером... " + Main.IP);

        try {
            socket = new Socket(Main.IP, Main.PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            PrintWriter    out = new PrintWriter(socket.getOutputStream(),true);
            DataInputStream fuser = new DataInputStream(System.in);

            while (fuser!=null) {
                out.println(fuser);
                String str = in.readUTF();
                System.out.println(str);
            }

        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String msg){
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
//            out.writeUTF(reader.readLine());
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}