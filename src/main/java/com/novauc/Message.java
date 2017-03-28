package com.novauc;

/**
 * Created by jerieshasmith on 3/13/17.
 */
public class Message {
    static int i =0;
    int id;
    String text;

    public Message() {
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Message.i = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(String text){
        this.id = Message.i++;
        this.text = text;














    }
}
