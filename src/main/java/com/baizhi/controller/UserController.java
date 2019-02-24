package com.baizhi.controller;

import com.baizhi.entity.UserResult;
import com.baizhi.entity.VoteUser;
import com.baizhi.service.VoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private VoteUserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        UserResult result = userService.login(username, password);
        boolean login = result.isLogin();
        if (login){
            VoteUser user = result.getUser();
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }else {
            return "login";
        }
    }

    @RequestMapping("/regist")
    public String regist(VoteUser user,HttpSession session){
        UserResult regist = userService.regist(user);
        boolean register = regist.isLogin();
        VoteUser user1 = regist.getUser();
        if (register){
            session.setAttribute("user",user1);
            return "reg_success";
        }else {
            return "register";
        }
    }
}
