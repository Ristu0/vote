package com.baizhi.service.impl;

import com.baizhi.dao.VoteOptionDao;
import com.baizhi.entity.VoteOption;
import com.baizhi.service.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteOptionServiceImpl implements VoteOptionService {
    @Autowired
    private VoteOptionDao voteOptionDao;

    @Override
    public long getVoteOptionRowCount() {
        return voteOptionDao.getVoteOptionRowCount();
    }

    @Override
    public List<VoteOption> selectVoteOption() {
        return voteOptionDao.selectVoteOption();
    }

    @Override
    public VoteOption selectVoteOptionByObj(VoteOption obj) {
        return voteOptionDao.selectVoteOptionByObj(obj);
    }

    @Override
    public VoteOption selectVoteOptionById(Integer id) {
        return voteOptionDao.selectVoteOptionById(id);
    }

    @Override
    public int insertVoteOption(VoteOption value) {
        return voteOptionDao.insertVoteOption(value);
    }

    @Override
    public int insertNonEmptyVoteOption(VoteOption value) {
        return voteOptionDao.insertNonEmptyVoteOption(value);
    }

    @Override
    public int deleteVoteOptionById(Integer id) {
        return voteOptionDao.deleteVoteOptionById(id);
    }

    @Override
    public int updateVoteOptionById(VoteOption enti) {
        return voteOptionDao.updateVoteOptionById(enti);
    }

    @Override
    public int updateNonEmptyVoteOptionById(VoteOption enti) {
        return voteOptionDao.updateNonEmptyVoteOptionById(enti);
    }

    public VoteOptionDao getVoteOptionDao() {
        return this.voteOptionDao;
    }

    public void setVoteOptionDao(VoteOptionDao voteOptionDao) {
        this.voteOptionDao = voteOptionDao;
    }

}