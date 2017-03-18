package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jerieshasmith on 3/13/17.
 */
@Controller

public class MessageController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }


ArrayList<Message> messages = new ArrayList<>();
    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String message){
        session.setAttribute("messageText", message);
        messages.add(new Message(message));
        return "redirect:/";

    }

@RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session,int deleteMessage){
        session.setAttribute("deleteMessage",deleteMessage);
        messages.remove( -1);
        return"redirect:/";
}

@RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(HttpSession session,int editMessage){
        session.setAttribute("editMessage",editMessage);
        Message message = new Message();
        messages.add(new Message(message.getText()));
        return "redirect:/";
}

}




