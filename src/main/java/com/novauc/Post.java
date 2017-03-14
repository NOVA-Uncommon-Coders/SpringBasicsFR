package com.novauc;

public class Post {
    String message;
    int id;
    int userId;
    boolean edit = false;

    /***************
     * Constructor
     **************/

    public Post(String message,  int id, int userId) {
        this.message = message;
        this.id = id;
        this.userId = userId;
    }

    /***************
     * Getter
     **************/

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public int getUserIdd() {
        return userId;
    }

    public boolean isEdit() {
        return edit;
    }

    /***************
     * Setter
     **************/

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
