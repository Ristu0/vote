package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteOption {
    private Integer voId;
    private Integer vsId;
    private String voOption;
    private Integer voOrder;
    private VoteSubject voteSubject;
}
