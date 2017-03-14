package com.novauc;

public class Post {
    String message;
    int id;
    int user_id;

    /***************
     * Constructor
     **************/

    public Post(String message, int id, int user_id) {
        this.message = message;
        this.id = id;
        this.user_id = user_id;
    }

    /***************
     * Constructor
     **************/

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    /***************
     * Constructor
     **************/

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
