package com.novauc;

/**
 * Created by Eric on 3/28/17.
 */

public class Message {

    Integer id;
    String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message(){

    }

}
