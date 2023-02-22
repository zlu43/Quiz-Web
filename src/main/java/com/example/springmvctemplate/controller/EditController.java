package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EditController {

    private QuizService quizService;

    @Autowired
    public EditController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/add")
    public String getEdit(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "add";
    }

    @PostMapping("/add")
    public String addQuestion(@RequestParam String category_name,
                                 @RequestParam String question_content,
                                 @RequestParam String choice1,
                                 @RequestParam String choice2,
                                 @RequestParam String choice3,
                                 @RequestParam String choice4,
                                 @RequestParam int correct_choice_num,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        quizService.addQuestion(category_name, question_content, choice1, choice2, choice3, choice4, correct_choice_num);
        return "redirect:/home";
    }

    @GetMapping("/update")
    public String getUpdate(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "update";
    }

    @GetMapping("/update/{question_id}")
    public String getUpdate(@PathVariable(value="question_id") int question_id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setAttribute("update_qid", question_id);
        return "update";
    }

    @PostMapping("/update")
    public String updateQuestion(@RequestParam String question_content,
                              @RequestParam String choice1,
                              @RequestParam String choice2,
                              @RequestParam String choice3,
                              @RequestParam String choice4,
                              @RequestParam int correct_choice_num,
                              HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int question_id = (int) session.getAttribute("update_qid");
        quizService.updateQuestion(question_id, question_content, choice1, choice2, choice3, choice4, correct_choice_num);
        return "redirect:/home";
    }

}
