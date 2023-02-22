package com.example.springmvctemplate.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class Category {
    private int category_id;
    private String category_name;
    private List<Integer> category_question_ids;
}
