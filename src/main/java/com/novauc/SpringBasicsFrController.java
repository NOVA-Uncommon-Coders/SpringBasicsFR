package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by octavio on 3/14/17.
 */

@Controller
public class SpringBasicsFrController {

    ArrayList<Message> m = new ArrayList<>();


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("message", m);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.GET)
    public String message(HttpSession session, String insertMessage) {
        session.setAttribute("insertMessage", insertMessage);
        m.add(new Message(insertMessage));
        System.out.println("m size adding " + m.size());
        System.out.println(m.lastIndexOf(insertMessage));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int deleteMessage) {
        session.setAttribute("deleteMessage", deleteMessage);

//        m.removeIf(message -> message.getId("").equals("id"));

        Message temp = new Message();
        for (Message mess : m) {
            if (deleteMessage == mess.getId()) {
                temp = mess;
            }
        }
        m.remove(temp);
        System.out.println("m size deleting " + m.size());
        return "redirect:/";
    }
}


