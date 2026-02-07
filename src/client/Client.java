package client;

import java.io.*;
import java.net.Socket;
import config.Config;

public class Client {

    public static void main(String[] args) throws Exception {
        try (
                Socket socket = new Socket(Config.getServerIp(), Config.getPort());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            new MessageListener(in).start();

            String text;
            while ((text = console.readLine()) != null) {
                out.println(text);
            }
        }
    }
}