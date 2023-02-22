package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.QuestionMapper;
import com.example.springmvctemplate.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuestion(int category_id, String question_content, Boolean is_active) {
        String sql = "insert into Question (category_id, question_content, is_active) values (?, ?, ?)";
        jdbcTemplate.update(sql, category_id, question_content, is_active);
    }

    public void deleteQuestionById(int question_id) {
        String sql = "delete from Question where question_id = ?";
        jdbcTemplate.update(sql, question_id);
    }

    public void deleteQuestionByCategoryId(int category_id) {
        String sql = "delete from Question where question_id = ?";
        jdbcTemplate.update(sql, category_id);
    }

    public void updateQuestionContentById(int question_id, String question_content) {
        String sql = "update Question set question_content = ? where question_id = ?";
        jdbcTemplate.update(sql, question_content, question_id);
    }

    public void activateOrSuspendQuestionById(int question_id, String action) {
        String sql = "update Question set is_active = ? where question_id = ?";
        if (action.equals("activate")) {
            jdbcTemplate.update(sql, true, question_id);
        } else {
            jdbcTemplate.update(sql, false, question_id);
        }
    }

    public Question getQuestionById(int question_id) {
        String sql = "select * from Question where question_id = ?";
        List<Question> rs = jdbcTemplate.query(sql, new QuestionMapper(), question_id);
        return rs.size() > 0 ? rs.get(0) : null;
    }

    public int getQuestionIdByQuestionContent(String question_content) {
        String sql = "select question_id from Question where question_content = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, question_content);
    }

    public List<Integer> getQuestionIdByCategoryId(int category_id) {
        String sql = "select question_id from Question where category_id = ? and is_active = true";
        return jdbcTemplate.queryForList(sql, Integer.class, category_id);
    }

    public List<Question> getAllQuestion() {
        String sql = "select * from Question";
        return jdbcTemplate.query(sql, new QuestionMapper());
    }

    public List<Integer> getAllQuestionId() {
        String sql = "select question_id from Question";
        return jdbcTemplate.queryForList(sql, Integer.class);
    }
}
