package com.example.springmvctemplate.domain;

import lombok.*;

import java.util.List;

@Data
public class Quiz {
    private int quiz_id;
    private int user_id;
    private String user_fullname;
    private int category_id;
    private String category_name;
    private String start_time;
    private String end_time;
    private int score;
    private List<Question> question_list;
    private List<Integer> user_answer_id_list;
    private List<Choice> user_answer_list;
}
