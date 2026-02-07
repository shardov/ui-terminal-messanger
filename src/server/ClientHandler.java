package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private final Socket socket;
    private final UserManager userManager;
    private String username;

    public ClientHandler(Socket socket, UserManager userManager) {
        this.socket = socket;
        this.userManager = userManager;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Введите свое имя:");
            username = in.readLine();

            userManager.addUser(username, out);
            userManager.broadcast("[SYSTEM] " + username + " присоединился к чату!");

            String msg;
            while ((msg = in.readLine()) != null) {
                userManager.broadcast("[" + username + "]: " + msg);
            }

        } catch (IOException ignored) {
        } finally {
            if (username != null) {
                userManager.removeUser(username);
                userManager.broadcast("[SYSTEM] " + username + " покинул чат!");
            }
        }
    }
}
