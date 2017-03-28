package com.novauc;

/**
 * Created by ANVIL_OCTOPUS on 3/13/17.
 */
public class Message {

    private int id;
    public static int i = 0;
    private String text;

    public Message(String text) {
        id = i++;
        this.text = text;

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
}