package com.baizhi.controller;

import com.baizhi.entity.VoteDTO;
import com.baizhi.entity.VoteSubject;
import com.baizhi.entity.VoteUser;
import com.baizhi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Object voteList() {
        List<VoteDTO> voteDTOS = voteService.voteList();
        return voteDTOS;
    }

    @RequestMapping("showVote")
    public String showVote(Integer id, HttpServletRequest request) {
        VoteDTO byId = voteService.getById(id);
        request.setAttribute("vote", byId);
        return "vote";
    }

    @RequestMapping("addVoteResult")
    public String addVoteResult(Integer vsId, Integer[] voId, HttpSession session) {
        System.out.println(vsId);
        System.out.println(voId);
        VoteUser user = (VoteUser) session.getAttribute("user");
        Integer vuUserId = user.getVuUserId();
        voteService.addVoteResult(vsId, vuUserId, voId);
        return "vote_success";
    }

}
