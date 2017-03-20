package com.novauc;

/**
 * Created by dangelojoyce on 3/13/17.
 */
public class Message {
    private static int i = 0;
    private  int id;
    private String name;

    public Message(){

    }

    public Message(String name){
        this.name = name;
        this.id = ++i;
    }

    public Message(int id){
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
