package com.novauc;

/**
 * Created by kevinallen on 3/28/17.
 */

public  class  Post {
    static int i =0;
    int id;

//   ArrayList<Messages> messages = new ArrayList<>();

    String text;



    public Post(){

    }

    public Post(String text) {
        this.id = i++;
        this.text = text;

    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Post.i = i;
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

    public void setText(String post) {
        this.text = text;
    }
}






