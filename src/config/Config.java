package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Используется дефолтная конфигурация!");
        }
    }

    public static String getServerIp() {
        if (props.getProperty("server.ip") == null) {
            System.out.println("Заполните config.properties!");
        }
        return props.getProperty("server.ip");
    }

    public static int getPort() {
        if (props.getProperty("server.port") == null) {
            System.out.println("Заполните config.properties!");
        }
        return Integer.parseInt(props.getProperty("server.port"));
    }
}
