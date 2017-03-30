package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Eric on 3/28/17.
 */
@Controller
public class SpringBasicsFrController {

    ArrayList<Message> messagelist = new ArrayList<Message>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
    model.addAttribute("userName", session.getAttribute("userName"));
    model.addAttribute("message", messagelist);
    return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String message) {
        session.setAttribute("message", message);
        messagelist.add(new Message(messagelist.size() + 1, message)); //
        System.out.println(messagelist.size());
        return "redirect:/";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String deleteMessage(HttpSession session, Integer deletedMessage) {
        session.setAttribute("deletedMessage", deletedMessage);
        Message tempMess = new Message();
        for(Message m : messagelist) {
            if (deletedMessage == m.getId()) {
                tempMess = m;
            }
        }
            messagelist.remove(tempMess);
            return "redirect:/";
    }

}

