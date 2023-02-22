package com.example.springmvctemplate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addResult(int quiz_id, int question_id, int user_choice_id) {
        String sql = "insert into Result (quiz_id, question_id, user_choice_id) values (?, ?, ?)";
        jdbcTemplate.update(sql, quiz_id, question_id, user_choice_id);
    }

    public List<Integer> getQuestionIdByQuizId(int quiz_id) {
        String sql = "select question_id from Result where quiz_id = ?";
        return jdbcTemplate.queryForList(sql, Integer.class, quiz_id);
    }

    public Integer getUserChoiceIdByQuizIdAndQuestionId(int quiz_id, int question_id) {
        String sql = "select user_choice_id from Result where quiz_id = ? and question_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, quiz_id, question_id);
    }

}
