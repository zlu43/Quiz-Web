package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.Question;
import com.example.springmvctemplate.domain.Quiz;
import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public String getQuiz(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "quiz";
    }

    @GetMapping("/quiz/{category_id}")
    public String startQuiz(@PathVariable(value="category_id") int category_id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        int user_id = user.getUser_id();
        Quiz quiz = quizService.prepareNewQuiz(user_id, category_id);
        session.setAttribute("quiz", quiz);
        return "quiz";
    }

    @PostMapping("/quiz")
    public String collectQuizResult(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        List<Question> question_list = quiz.getQuestion_list();
        List<Integer> user_answer_id_list = new ArrayList<>();
        for (Question q: question_list) {
            String user_answer = request.getParameter("answer_" + q.getQuestion_id());
            user_answer_id_list.add(Integer.parseInt(user_answer));
        }
        quiz.setUser_answer_id_list(user_answer_id_list);
        quiz = quizService.collectQuizResult(quiz);
        session.setAttribute("quiz", quiz);

        return "redirect:/result";
    }

}
