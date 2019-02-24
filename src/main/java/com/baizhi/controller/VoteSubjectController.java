package com.baizhi.controller;

import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/votesubject")
public class VoteSubjectController {
    @Autowired
    private VoteSubjectService voteSubjectService;

    @RequestMapping("/showOne")
    public String showOne(Integer id, HttpServletRequest req) {
        VoteSubject voteSubject = voteSubjectService.selectById(id);
        req.setAttribute("voteSubject", voteSubject);
        return "update";
    }

    @RequestMapping("/updateVote")
    public String updateVote(VoteSubject subject, String[] options) {
        System.out.println(subject);
        System.out.println(options);
        voteSubjectService.updateSubject(subject, options);
        return "redirect:/index.jsp";
    }
}
