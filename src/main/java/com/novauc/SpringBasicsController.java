package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by dangelojoyce on 3/13/17.
 */

@Controller
public class SpringBasicsController {

    static ArrayList<Message> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("text", messages);
        return "home";
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String Person(Model model, HttpSession session, int id) {
        //Message message = new Message(id, "id");
        model.addAttribute("text", session.getAttribute("userMessage"));
        return "message";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping (path = "/add-messages", method = RequestMethod.POST)
    public String addMessages(Model model, HttpSession session, String userMessage){
        messages.add(new Message(userMessage));
        return "redirect:/";
        }

    @RequestMapping (path = "/delete-messages", method = RequestMethod.POST)
    public String deleteMessages(Model model, String id) {
        int i = 0;
        Message myMessage = null;
        for (Message message : messages) {
            System.out.println(++i);
            if (message.getId() == Integer.valueOf(id)) {
                myMessage = message;
            }
        }
        messages.remove(myMessage);
        return "redirect:/";
    }
    @RequestMapping (path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}









