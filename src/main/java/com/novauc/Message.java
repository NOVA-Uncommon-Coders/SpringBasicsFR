package com.novauc;


public class Message {
    public static int i = 0;
    private int id;
    private String name;

    public Message(String name) {
        //this.id = id;
        this.name = name;
        id = i++;
    }

    public Message() {}

    public int getId() {
        return id;
    }
}
