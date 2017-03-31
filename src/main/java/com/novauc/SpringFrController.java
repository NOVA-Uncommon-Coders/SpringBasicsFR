package com.novauc;

import com.sun.jdi.IntegerValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinallen on 3/28/17.
 */

@Controller
public class SpringFrController{
    static ArrayList<Post> posts = new ArrayList<>();



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("posts",posts);
        return "home";

    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }
    @RequestMapping(path = "/create-post", method = RequestMethod.POST)
    public String createpost(Model model, HttpSession session, String postName) {
         posts.add(new Post(postName));

        return "redirect:/";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(Integer deletePost) {
       Post stopPost = new Post();
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == deletePost){
                stopPost = posts.get(i);
            }

        }
        posts.remove(stopPost);
        return "redirect:/";
    }




}

