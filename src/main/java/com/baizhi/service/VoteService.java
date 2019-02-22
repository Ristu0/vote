package com.baizhi.service;

import com.baizhi.entity.VoteSubject;

public interface VoteService {
    void addVote(VoteSubject subject, String[] options);
}
