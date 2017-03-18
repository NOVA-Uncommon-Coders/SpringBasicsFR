package com.novauc;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souporman on 3/13/17.
 */
//@Component
//@RequestMapping("userMessages")
public class User{

    String userName;

    List<String> messages = new ArrayList();

    public User(List messages) {
        this.messages = messages;
    }

    public User(String userName) {

        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
