package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SpringBasicsFRController {

    public static ArrayList<Message> messagesAL = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("modeledMessage", messagesAL);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(HttpSession session, String enterMessage) {
        session.setAttribute("enterMessage", enterMessage);
        messagesAL.add(new Message(enterMessage));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int deleteMessage) {
        session.setAttribute("deleteMessage", deleteMessage);
        Message messenger = null;
        for(Message picker : messagesAL) {
            if (picker.getId() == deleteMessage) {
                messenger = picker;
                break;
            }
        }
        if(messenger != null) {
            messagesAL.remove(messenger);
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
