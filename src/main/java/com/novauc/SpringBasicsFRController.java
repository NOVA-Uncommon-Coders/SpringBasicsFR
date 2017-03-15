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
public class SpringBasicsFRController {

    // crete a route for "/"
    // a) it should take the model and request as arguments // {args}
    // b) it should read the username from the session and add it to the model add.
    // c) it should return the home template  return;

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public String home(Model model, HttpSession session) {
//        model.addAttribute("name", session.getAttribute("userName"));
//        return "home";


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    // In your controller, create a route "/login"
    // it should take the request and the username as arguments
    // it should save the username to the session
    // it should return a redirect to "/" return "/";

//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    public String login(HttpSession session, String userName) {
//        session.setAttribute("userName", userName);
//        return "redirect:/";
//    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    // in your controller, create a route for "/add-message"
    // It should take the message text as an argument
    // It should create a "Message" object and add it to the arrayList(for the id, do something
    // like "messages.size() + 1)
    // It should return a redirect to "/"

    @RequestMapping(path = "/add-message", method = RequestMethod.GET)
    public String message(HttpSession session, String insertMessage) {
        session.setAttribute("insertMessage", insertMessage);
        m.add(new Message(insertMessage));
        System.out.println("m size adding " + m.size());
        System.out.println(m.lastIndexOf(insertMessage));   // Yo MiKE MIKE MIKE MIKE, guess what this is? Cuz Idk
        return "redirect:/";
    }

    // in your controller, create a route for "/delete-message"
    // it should take the message id as an argument
    // it should remove the message with the given id(do something like
    // "message.remove(id -1))
    // it should return a redirect to "/"

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int deleteMessage) {
        session.setAttribute("deleteMessage", deleteMessage);
        m.remove(deleteMessage);
        System.out.println("m size deleting " + m.size());
        return "redirect:/";
    }

    ArrayList<Message> m = new ArrayList<>();  // my ArrayList to store submitted messages

    public static void main(String[] args) {
    }
}