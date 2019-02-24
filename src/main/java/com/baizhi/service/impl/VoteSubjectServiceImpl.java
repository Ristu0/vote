package com.baizhi.service.impl;

import com.baizhi.dao.SubjectDTODao;
import com.baizhi.dao.VoteOptionDao;
import com.baizhi.dao.VoteSubjectDao;
import com.baizhi.entity.OptionDTO;
import com.baizhi.entity.SubjectDTO;
import com.baizhi.entity.VoteSubject;
import com.baizhi.service.VoteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VoteSubjectServiceImpl implements VoteSubjectService {
    @Autowired
    private VoteSubjectDao voteSubjectDao;
    @Autowired
    private VoteOptionDao voteOptionDao;
    @Autowired
    private SubjectDTODao subjectDTODao;

    @Override
    public SubjectDTO selectSubById(Integer id){
        SubjectDTO subjectDTO = subjectDTODao.selectById(id);
        List<OptionDTO> dtos = subjectDTODao.selectOpById(id);
        subjectDTO.setOptionDTOS(dtos);
        return subjectDTO;
    }
    @Override
    public long getVoteSubjectRowCount() {
        return voteSubjectDao.getVoteSubjectRowCount();
    }

    @Override
    public List<VoteSubject> selectVoteSubject() {
        return voteSubjectDao.selectVoteSubject();
    }

    @Override
    public VoteSubject selectVoteSubjectByObj(VoteSubject obj) {
        return voteSubjectDao.selectVoteSubjectByObj(obj);
    }

    @Override
    public VoteSubject selectVoteSubjectById(Integer id) {
        return voteSubjectDao.selectVoteSubjectById(id);
    }

    @Override
    public int insertVoteSubject(VoteSubject value) {
        return voteSubjectDao.insertVoteSubject(value);
    }

    @Override
    public int insertNonEmptyVoteSubject(VoteSubject value) {
        return voteSubjectDao.insertNonEmptyVoteSubject(value);
    }

    @Override
    public int deleteVoteSubjectById(Integer id) {
        return voteSubjectDao.deleteVoteSubjectById(id);
    }

    @Override
    public int updateVoteSubjectById(VoteSubject enti) {
        return voteSubjectDao.updateVoteSubjectById(enti);
    }

    @Override
    public int updateNonEmptyVoteSubjectById(VoteSubject enti) {
        return voteSubjectDao.updateNonEmptyVoteSubjectById(enti);
    }

    @Override
    public VoteSubject selectById(Integer id) {
        VoteSubject voteSubject = voteSubjectDao.selectById(id);
        return voteSubject;
    }

    @Override
    public void updateSubject(VoteSubject subject, String[] options) {
        if (options != null) {
            voteOptionDao.insertOption(options, subject.getVsId());
        }
    }

    public VoteSubjectDao getVoteSubjectDao() {
        return this.voteSubjectDao;
    }

    public void setVoteSubjectDao(VoteSubjectDao voteSubjectDao) {
        this.voteSubjectDao = voteSubjectDao;
    }

}