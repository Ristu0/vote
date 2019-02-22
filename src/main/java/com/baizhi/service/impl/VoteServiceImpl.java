package com.baizhi.service.impl;

import com.baizhi.dao.VoteOptionDao;
import com.baizhi.dao.VoteSubjectDao;
import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteSubjectDao voteSubjectDao;
    @Autowired
    private VoteOptionDao voteOptionDao;

    @Override
    public void addVote(VoteSubject subject, String[] options) {
        voteSubjectDao.insertSub(subject);
        Integer vsId = subject.getVsId();
        voteOptionDao.insertOption(options, vsId);
    }
}
