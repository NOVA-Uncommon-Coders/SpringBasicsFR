package com.novauc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class FRController {
    Database database = Database.getInstance();
//    @RequestMapping(path = "/person", method = RequestMethod.GET)
//    public String person(Model model, String name, String city, int age) {
//       // Person p = new Person(name, city, age);
//        model.addAttribute("user", );
//        return "person";
//    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) {
        try {
            int id = database.verifyUser(userName, password);
            if (id >= 0){
                session.setAttribute("user", database.selectUser(id));
                return "redirect:/";
            } else {
                return "redirect:/register";
            }
        } catch (Exception e){
            System.out.println("Huston had a problem @" + e.getMessage());
            return "redirect:/";
        }
    }
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user != null){
            return "home";
        }
        return "register";
    }
    @RequestMapping(path ="/register-user", method = RequestMethod.POST)
    public String register(HttpSession session, String userName, String password){
        try {
            if (database.insertUser(userName, password)){
                int id = database.verifyUser(userName, password);
                session.setAttribute("user", database.selectUser(id));
                return "redirect:/home";
            } else {
                return "redirect:/register";
            }
        } catch (Exception e){
            System.out.println("Huston had a problem @" + e.getMessage());
            return "redirect:/register";
        }
    }
}
