package com.baizhi.controller;

import com.baizhi.entity.VoteDTO;
import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("voteList")
    @ResponseBody
    public Object voteList(HttpServletRequest request) {
        List<VoteDTO> voteDTOS = voteService.voteList();
        return voteDTOS;
    }

    @RequestMapping("showVote")
    public void showVote(Integer id) {

    }
}
