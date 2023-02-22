package com.example.springmvctemplate.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Choice {
    private int choice_id;
    private int question_id;
    private String choice_content;
    private boolean is_answer;
}
