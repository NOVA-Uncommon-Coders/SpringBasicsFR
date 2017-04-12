package com.novauc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class SpringBasicsController {

    static User user;

    ArrayList<Message> vegasc = new ArrayList<>();


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUsers(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("username"));
        model.addAttribute("zbt", vegasc);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String getMoney(Model model, String yname, HttpSession session) {
        User y = new User(yname);
        user = y;
        session.setAttribute("username", user.name);
        return "redirect:/";
    }

    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String getMe(Model model, String message) {
    Message z = new Message(message);
    vegasc.add(z);
        return "redirect:/";
    }

    @RequestMapping(path = "/deleteMessage", method = RequestMethod.POST)
    public String getOut(Model model, Integer delete) {
    vegasc.remove(delete-1);
          return "redirect:/";
    }

//
//        Spark.get(
//                "/",
//                ((request, response) -> {
//                    HashMap m = new HashMap();
//                    if (user == null) {
//                        return new ModelAndView(m, "index.html");
//                    } else {
//                        m.put("name", user.name);
//                        //m.put("post",user.post);
//                        return new ModelAndView(m, "messages.html");
//                    }
//                }),
//                new MustacheTemplateEngine()
//        );
//
//        Spark.post(
//                "/login",
//                ((request, response) -> {
//                    String name = request.queryParams("loginName");
//                    user = new User(name);
//                    response.redirect("/");
//                    return "";
//                })
//        );
//        Spark.post("/Submit",
//                ((request, response) -> {
//                    String Message = request.queryParams("Message");
//                    //user.posts.add(Message);
//                    response.redirect("/");
//                    return "";
//
//                }));


}