package com.baizhi.controller;

import com.baizhi.entity.SubjectDTO;
import com.baizhi.entity.VoteDTO;
import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteItemService;
import com.baizhi.service.VoteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/votesubject")
public class VoteSubjectController {
    @Autowired
    private VoteSubjectService voteSubjectService;
    @Autowired
    private VoteItemService voteItemService;

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

    @RequestMapping("view")
    public Object view(Integer id,HttpServletRequest req){
        SubjectDTO subjectDTO = voteSubjectService.selectSubById(id);
        Integer count =0;
        for (int i = 0; i < subjectDTO.getOptionDTOS().size(); i++) {
            if (subjectDTO.getOptionDTOS().get(i).getCount() != null) {
                count += subjectDTO.getOptionDTOS().get(i).getCount();
            }
        }
        req.setAttribute("subjectDTO",subjectDTO);
        req.setAttribute("count", count);
        return "view";
    }
    @RequestMapping("search")
    @ResponseBody
    public Object search(String name){
        List<VoteDTO> voteDTOS = voteItemService.selectByName(name);
        return voteDTOS;
    }
}
