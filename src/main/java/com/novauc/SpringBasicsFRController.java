package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by souporman on 3/13/17.
 */
@Controller
@RequestMapping("/")
public class SpringBasicsFRController {

    @Autowired
    Messager userMessages;

//    static ArrayList allMessages = new ArrayList();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        for(Messages looper : userMessages.viewAllMessages()) {
            model.addAttribute("messages",looper);
        }
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logout(Model model,HttpSession session, String userName){
        session.setAttribute("userName",userName);
        model.addAttribute("name", session.getAttribute("userName"));
        return"redirect:/";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String loginUser(Model model,HttpSession session, String userName){
        session.invalidate();
        return"redirect:/";
    }

//    @RequestMapping(value = "/create-message", method = RequestMethod.POST)
//    public @ResponseBody void createMessage(@RequestBody Messages messageInput) {
//        userMessages.createMessage(messageInput);
//    }

    @RequestMapping(value = "/create-message", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String messageInput) {
        Messages currentMessage = new Messages(messageInput);
        userMessages.createMessage(currentMessage);
        session.setAttribute("messages",userMessages);
        return "redirect:/";
    }


    @RequestMapping(value = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(String id) {
        userMessages.deleteMessage(Integer.valueOf(id));
        return "redirect:/";
    }
//
//    @RequestMapping(value = "/all.json", method = RequestMethod.GET)
//    public @ResponseBody List<AddressBook> viewAllAddressBook() {
//        return addressBookService.viewAllAddressBook();
//    }
//
//
//    @RequestMapping(value = "/update/{pos}", method = RequestMethod.PUT)
//    public @ResponseBody void updateAddressBook(
//            @RequestBody AddressBook addressBook,
//            @PathVariable("pos") String pos) {
//        addressBookService.updateAddressBook(Integer.valueOf(pos), addressBook);
//    }
//
//    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
//    public @ResponseBody void deleteAllAddressBook() {
//        addressBookService.deleteAllAddressBook();
//    }
//
//    @RequestMapping("/layout")
//    public String getTodoPartialPage() {
//        return "addressbook/layout";
//    }
}
