package com.novauc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souporman on 3/14/17.
 */
public interface Messager{

    List<Messages> viewAllMessages();

    void createMessage(Messages messages);

    void deleteMessage(int id);

    //THESE I WILL USE LATER
//    void updateMessage(int pos, Messages messages);
//
//    void deleteMessages();
//
    Messages findSpecificMessage(int id);

}
