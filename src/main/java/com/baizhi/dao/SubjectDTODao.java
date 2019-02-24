package com.baizhi.dao;

import com.baizhi.entity.OptionDTO;
import com.baizhi.entity.SubjectDTO;
import com.baizhi.entity.VoteSubject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDTODao {
    SubjectDTO selectById(@Param("id") Integer id);
    List<OptionDTO> selectOpById(@Param("id") Integer id);
}