package com.novauc;


public class Message {
    public static int i = 0;
    private int id;
    private String text;

    public Message(String text) {
        this.text = text;
        id = i++;
    }

    public Message() {}

    public int getId() {
        return id;
    }
}
