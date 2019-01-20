package console_chat;

import console_chat.Client.Controller;
import console_chat.Server.ServerTest;

public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ServerTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Controller().init();
            }
        }).start();
    }
}

