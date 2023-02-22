package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.Category;
import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.ContactService;
import com.example.springmvctemplate.service.QuizService;
import com.example.springmvctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

    private QuizService quizService;
    private UserService userService;
    private ContactService contactService;

    @Autowired
    public HomeController(QuizService quizService, UserService userService, ContactService contactService) {
        this.quizService = quizService;
        this.userService = userService;
        this.contactService = contactService;
    }


    @GetMapping("/home")
    public String getHome(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        if (Objects.equals(user.getUser_name(), "admin")) {
            request.setAttribute("user_list", userService.getAllUsers());
            request.setAttribute("taken_quiz_list", quizService.getAllTakenQuiz());
            request.setAttribute("question_list", quizService.getAllQuestions());
            request.setAttribute("feedback_list", contactService.getAllFeedback());
            request.setAttribute("message_list", contactService.getAllMessage());
            request.setAttribute("category_list", quizService.getAllCategories());
            return "admin";
        } else {
            request.setAttribute("category_list", quizService.getAllCategories());
            request.setAttribute("taken_quiz_list", quizService.getAllTakenQuizInfo(user.getUser_id()));
            return "home";
        }
    }

    @GetMapping("/")
    public String getRoot() {
        return "redirect:/home";
    }

    @PostMapping("/home")
    public String changeStatus(@RequestParam String action_str, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String[] parts = action_str.split("_");
        String action = parts[0];
        String target = parts[1];
        int target_id = Integer.parseInt(parts[2]);
        if (target.equals("user")) {
            userService.activateOrSuspendUser(target_id, action);
        } else {
            quizService.activateOrSuspendQuestion(target_id, action);
        }
        request.setAttribute("user_list", userService.getAllUsers());
        request.setAttribute("taken_quiz_list", quizService.getAllTakenQuiz());
        request.setAttribute("question_list", quizService.getAllQuestions());

        return "admin";
    }
}