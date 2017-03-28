package com.novauc;

import java.util.ArrayList;

public class User {
    private String userName;
    private int id;
    private ArrayList<Post> posts = null;

    /***************
     * Constructor
     **************/
    public User(String userName, int id) {
        this.userName = userName;
        this.id = id;
    }

/***************
     * Getters
     **************/
    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
/***************
     * Setters
     **************/

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
