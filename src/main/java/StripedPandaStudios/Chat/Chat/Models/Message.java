package StripedPandaStudios.Chat.Chat.Models;

public class Message {

    public String sender;
    public String senderId;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender,String senderId) {
        this.sender = sender;
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String text;




}
