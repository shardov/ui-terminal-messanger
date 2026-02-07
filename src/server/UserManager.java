package server;

import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    private final Map<String, PrintWriter> users = new ConcurrentHashMap<>();

    public void addUser(String name, PrintWriter out) {
        users.put(name, out);
    }

    public void removeUser(String name) {
        users.remove(name);
    }

    public void broadcast(String message) {
        for (PrintWriter out : users.values()) {
            out.println(message);
        }
    }
}
