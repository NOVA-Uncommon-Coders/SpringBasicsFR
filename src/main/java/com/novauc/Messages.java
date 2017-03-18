package com.novauc;

/**
 * Created by souporman on 3/13/17.
 */
public class Messages{
    int id;
    String message;

    public Messages(int id) {
        this.id = id;
    }

    public Messages(String message) {
        this.message = message;
    }

    public Messages(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
