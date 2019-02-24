package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO implements Serializable {
    private Integer vsId;
    private String vsTitle;
    private String vsType;
    private Integer optionCount;
    private Integer personCount;
    private List<VoteOption> voteOptions;
}
