package com.baizhi.test;

import com.baizhi.dao.VoteItemDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoteTest {
    @Autowired
    private VoteItemDao voteItemDao;

    @Test
    public void test() {
        System.out.println(voteItemDao.selectAll());
    }
}
