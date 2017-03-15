package com.novauc;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by dangelojoyce on 3/13/17.
 */


public abstract class Controller extends Object implements ErrorAttributes, Ordered
{
    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";



    static ArrayList<Message> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public String Person(Model model, int id, String name) {
        Message message = new Message(0, "message");
        model.addAttribute("message", message);
        return "message";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping (path = "add-messages", method = RequestMethod.POST)
    public String addMessages(Model model, ArrayList messages, int id){
        Message message = new Message(0);
        messages.add(message.id);
        message.id = id;
        model.addAttribute("add-messages", id);

        for (id = 0; id < id + 1; id++) {
            while (id < id + 1) {
                messages.size();
                model.addAttribute("/message", message);

            }
        }

        return "add-message";
        }

    @RequestMapping (path = "delete-messages", method = RequestMethod.POST)
    public String deleteMessages(Model model, ArrayList messages, int id){




        return "delete-messages";
    }

    }









