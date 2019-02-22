package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteSubject {
    private Integer vsId;
    private String vsTitle;
    private Integer vsType;
    private List<VoteOption> voteOptions;
}
