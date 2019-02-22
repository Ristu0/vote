package com.baizhi.controller;

import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @RequestMapping("addVote")
    public String addVote(VoteSubject subject, String[] options) {
        voteService.addVote(subject, options);
        return "add_success";
    }
}
