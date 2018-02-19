package app.dto;

public class ChatUser {

    private String name;

    public ChatUser() {

    }

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
