import java.io.*;
import java.net.*;

public class Server {

    public void main() throws IOException {
        System.out.println("Сервер запущен!");
        BufferedReader in = null;
        PrintWriter    out= null;

        ServerSocket servers = null;
        Socket       fromclient = null;

        // create server socket
        try {
            servers = new ServerSocket(8189);
        } catch (IOException e) {
            System.out.println("Порт 8189 занят, не могу запуститься.");
            System.exit(-1);
        }

        try {
            System.out.print("Ожидаем подключаения клиента...");
            fromclient= servers.accept();
            System.out.println("Дождались, он подключился.");
        } catch (IOException e) {
            System.out.println("Не могу подключить.");
            System.exit(-1);
        }

        in  = new BufferedReader(new
                InputStreamReader(fromclient.getInputStream()));
        out = new PrintWriter(fromclient.getOutputStream(),true);
        String         input,output;

        System.out.println("Такс! Сейчас посмотрим, что он нам напишет");
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) break;
//            out.println("S ::: "+input);

//            System.out.println(input);
        }
        out.close();
        in.close();
        fromclient.close();
        servers.close();
    }
}