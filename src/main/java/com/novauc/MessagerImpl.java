package com.novauc;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by souporman on 3/14/17.
 */
@Service
public class MessagerImpl implements Messager {

    List<Messages> messagesList = new ArrayList<Messages>();
    private static int id = 0;


    public List<Messages> viewAllMessages() {
    return messagesList;
    }

    public void createMessage(Messages messages) {
        messagesList.add(id,messages);
        id++;
    }
    public void deleteMessage(int id) {
        messagesList.remove(id);
    }


    //ILL USE THESE LATER
//    public void updateMessage(int pointer, Messages newMessages) {
//    messagesList.set(pointer, newMessages);
//    }
//
//    public void deleteMessages() {
//    messagesList.clear();
//    id = 0;
//    }
//
    public Messages findSpecificMessage(int id) {
    return messagesList.get(id);
    }
}
