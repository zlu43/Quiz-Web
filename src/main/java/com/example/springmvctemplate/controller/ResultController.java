package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.Quiz;
import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ResultController {

    private QuizService quizService;

    public ResultController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/result")
    public String getResult(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "result";
    }

    @GetMapping("/result/{taken_quiz_id}")
    public String getTakenQuizResult(@PathVariable(value="taken_quiz_id") int taken_quiz_id,
                                     HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Quiz taken_quiz = quizService.loadTakenQuizById(taken_quiz_id);
        session.setAttribute("quiz", taken_quiz);
        return "result";
    }
}
