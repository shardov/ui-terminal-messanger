package server;

import java.net.ServerSocket;
import java.net.Socket;
import config.Config;

public class Server {

    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();

        try (ServerSocket serverSocket = new ServerSocket(Config.getPort())) {
            System.out.println("Сервер запущен на порте: " + Config.getPort());

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, userManager).start();
            }
        }
    }
}