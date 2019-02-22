package com.baizhi.dao;

import com.baizhi.entity.VoteSubject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteSubjectDao {
    /**
     * 获得VoteSubject数据的总行数
     *
     * @return
     */
    long getVoteSubjectRowCount();

    /**
     * 获得VoteSubject数据集合
     *
     * @return
     */
    List<VoteSubject> selectVoteSubject();

    /**
     * 获得一个VoteSubject对象,以参数VoteSubject对象中不为空的属性作为条件进行查询
     *
     * @param obj
     * @return
     */
    VoteSubject selectVoteSubjectByObj(VoteSubject obj);

    /**
     * 通过VoteSubject的id获得VoteSubject对象
     *
     * @param id
     * @return
     */
    VoteSubject selectVoteSubjectById(Integer id);

    /**
     * 插入VoteSubject到数据库,包括null值
     *
     * @param value
     * @return
     */
    int insertVoteSubject(VoteSubject value);

    /**
     * 插入VoteSubject中属性值不为null的数据到数据库
     *
     * @param value
     * @return
     */
    int insertNonEmptyVoteSubject(VoteSubject value);

    /**
     * 通过VoteSubject的id删除VoteSubject
     *
     * @param id
     * @return
     */
    int deleteVoteSubjectById(Integer id);

    /**
     * 通过VoteSubject的id更新VoteSubject中的数据,包括null值
     *
     * @param enti
     * @return
     */
    int updateVoteSubjectById(VoteSubject enti);

    /**
     * 通过VoteSubject的id更新VoteSubject中属性不为null的数据
     *
     * @param enti
     * @return
     */
    int updateNonEmptyVoteSubjectById(VoteSubject enti);

    /**
     * 添加一个新投票
     */
    void insertSub(VoteSubject voteSubject);
}