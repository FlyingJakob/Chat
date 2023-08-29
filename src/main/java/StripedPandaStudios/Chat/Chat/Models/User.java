package StripedPandaStudios.Chat.Chat.Models;

import java.io.Serializable;

public class User implements Serializable {

    public User(String username,String id) {
        this.username = username;
        this.id = id;
    }

    private String username;
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
