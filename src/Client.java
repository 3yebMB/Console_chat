import java.io.*;
import java.net.*;

public class Client {

    public void main(String args) throws IOException {

        System.out.println("Добро пожаловать в олдскульный консольный чат");

        Socket fromserver = null;

        String ipAdr;

        if (args.length()==0) {
            System.out.println("Вы запустили его на localhost");
//            System.exit(-1);
            ipAdr = "localhost";
        }
        else ipAdr = args;

        System.out.println("Соеденяемся с сервером... "+ipAdr);

        fromserver = new Socket(ipAdr,8189);
        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        PrintWriter    out = new
                PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new
                BufferedReader(new InputStreamReader(System.in));

        String fuser,fserver;

        while ((fuser = inu.readLine())!=null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
            if (fuser.equalsIgnoreCase("выход")) break;
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}