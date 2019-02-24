package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Integer vsId;
    private String vsTitle;
    private String vsType;
    private Integer optionCount;
    private Integer personCount;
    private List<OptionDTO> optionDTOS;
}
