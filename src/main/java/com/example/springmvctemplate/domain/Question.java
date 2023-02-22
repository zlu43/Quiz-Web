package com.example.springmvctemplate.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class Question {
    private int question_id;
    private int category_id;
    private String question_content;
    private List<Choice> choice_list;
    private Boolean is_active;
}
