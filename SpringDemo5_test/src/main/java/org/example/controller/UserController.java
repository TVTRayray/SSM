package org.example.controller;

import org.example.domain.Role;
import org.example.domain.User;
import org.example.service.RoleService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList =  userService.list();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") long userId ){
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession httpSession){
        User user= userService.login(username,password);
        if (user != null){
            //用户不为空
            httpSession.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
