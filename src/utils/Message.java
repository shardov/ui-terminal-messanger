package utils;

import java.io.Serializable;

public class Message implements Serializable {
    private MessageType type;
    private String from;
    private String text;

    public Message(MessageType type, String from, String text) {
        this.type = type;
        this.from = from;
        this.text = text;
    }

    public MessageType getType() { return type; }
    public String getFrom() { return from; }
    public String getText() { return text; }
}
