package com.novauc;

/**
 * Created by octavio on 3/14/17.
 */

// create a message class next to the other classes
// create field for id and text
public class Message {

    public static int i = 0;
    int id;
    String text;

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
