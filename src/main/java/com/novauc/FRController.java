package com.novauc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class FRController {
    Database database = Database.getInstance();

    /***********************
     * GET routes
     ***********************/

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "home";
    }
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user != null){
            model.addAttribute("user", user);
            return "home";
        }
        return "register";
    }
    @RequestMapping(path="/home", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "home";
        }
        try {
            model.addAttribute("user", user);
            return "home";
        } catch (Exception e){
            System.out.println("Huston had a problem loading home. Message @" + e.getMessage());
            return "register";
        }
    }
    @RequestMapping(path="/viewall", method = RequestMethod.GET)
    public String viewall(Model model, HttpSession session){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "home";
        }
        try {
            user.setPosts(database.selectUserPosts(user.getId()));
            model.addAttribute("allPost", database.selectJoinPost());
            model.addAttribute("user", user);
            return "viewall";
        } catch (Exception e){
            System.out.println("Huston had a problem viewing all. Message @" + e.getMessage());
            return "home";
        }
    }
    @RequestMapping(path="/logout", method=RequestMethod.GET)
    public String logout(Model model, HttpSession session){
        session.invalidate();
        return "home";
    }

    /***********************
     * POST routes
     ***********************/

    @RequestMapping(path ="/register-user", method = RequestMethod.POST)
    public String register(HttpSession session, String userName, String password){
        try {
            if (database.insertUser(userName, password)){
                int id = database.verifyUser(userName, password);
                session.setAttribute("user", database.selectUser(id));
                return "redirect:/";
            } else {
                return "redirect:/register";
            }
        } catch (Exception e){
            System.out.println("Huston had a problem during registration. Message @" + e.getMessage());
            return "redirect:/register";
        }
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
            System.out.println("Huston had a problem during login. Message @" + e.getMessage());
            return "redirect:/";
        }
    }
    @RequestMapping(path="/add-post", method=RequestMethod.POST)
    public String addPost(HttpSession session, String message){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "redirect:/home";
        }
        try {
            database.insertPost(message, user.getId());
            user.setPosts(database.selectUserPosts(user.getId()));
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("Huston had a problem while adding post. Message @" + e.getMessage());
            return "redirect:/home";
        }
    }
    @RequestMapping(path="/set-edit", method=RequestMethod.POST)
    public String setEdit(HttpSession session, String id){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "redirect:/home";
        }
        try {
            int postId = Integer.valueOf(id);
            Post userPost = null;
            for (Post post: user.getPosts()){
                post.setEdit(false);
                if (post.getId() == postId){
//                    userPost = post;
                    post.setEdit(true);
                }
            }
            //userPost.setEdit(true);
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("Huston had a problem with setting edit. Message @" + e.getMessage());
            return "redirect:/home";
        }
    }
    @RequestMapping(path="/edit-post", method=RequestMethod.POST)
    public String editPost(HttpSession session, String id, String message){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "redirect:/home";
        }
        try {
            database.updatePost(Integer.valueOf(id), message);
            user.setPosts(database.selectUserPosts(user.getId()));
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("Huston had a problem with edit post. Message @" + e.getMessage());
            return "redirect:/home";
        }
    }
    @RequestMapping(path="/remove-post", method=RequestMethod.POST)
    public String removePost(HttpSession session, String id){
        User user =(User) session.getAttribute("user");
        if (user == null){
            return "redirect:/home";
        }
        try {
            database.removePost(Integer.valueOf(id));
            user.setPosts(database.selectUserPosts(user.getId()));
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("Huston had a problem with remove post. Message @" + e.getMessage());
            return "redirect:/home";
        }
    }
}
