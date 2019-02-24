package com.baizhi.service;

import com.baizhi.entity.VoteDTO;
import com.baizhi.entity.VoteSubject;

import java.util.List;

public interface VoteService {
    void addVote(VoteSubject subject, String[] options);

    List<VoteDTO> voteList();

    VoteDTO getById(Integer id);

    void addVoteResult(Integer vsId, Integer userId, Integer[] optionIds);
}
