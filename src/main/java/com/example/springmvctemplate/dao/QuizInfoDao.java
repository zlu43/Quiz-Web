package com.example.springmvctemplate.dao;

import com.example.springmvctemplate.dao.mapper.QuizMapper;
import com.example.springmvctemplate.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizInfoDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuiz(Quiz quiz) {
        String sql = "insert into QuizInfo (quiz_id, user_id, category_id, start_time, end_time) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                quiz.getQuiz_id(),
                quiz.getUser_id(),
                quiz.getCategory_id(),
                quiz.getStart_time(),
                quiz.getEnd_time());
    }

    public int getQuizId(Quiz quiz) {
        String sql = "select quiz_id from QuizInfo where user_id = ? and category_id = ? and start_time = ? and end_time = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class,
                quiz.getUser_id(),
                quiz.getCategory_id(),
                quiz.getStart_time(),
                quiz.getEnd_time());
    }

    public void deleteQuizById(int quiz_id) {
        String sql = "delete from QuizInfo where quiz_id = ?";
        jdbcTemplate.update(sql, quiz_id);
    }

    public Quiz getQuizById(int quiz_id) {
        String sql = "select * from QuizInfo where quiz_id = ?";
        List<Quiz> rs = jdbcTemplate.query(sql, new QuizMapper(), quiz_id);
        return rs.size() > 0 ? rs.get(0) : null;
    }

    public List<Quiz> getQuizByUserId(int user_id) {
        String sql = "select * from QuizInfo where user_id = ?";
        return jdbcTemplate.query(sql, new QuizMapper(), user_id);
    }

    public List<Integer> getAllQuiz() {
        String sql = "select quiz_id from QuizInfo";
        return jdbcTemplate.queryForList(sql, Integer.class);
    }
}
