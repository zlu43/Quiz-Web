package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.Quiz;
import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.ContactService;
import com.example.springmvctemplate.service.QuizService;
import com.example.springmvctemplate.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ContactController {
    private UserService userService;
    private QuizService quizService;
    private ContactService contactService;

    public ContactController(UserService userService, QuizService quizService, ContactService contactService) {
        this.userService = userService;
        this.quizService = quizService;
        this.contactService = contactService;
    }

    @GetMapping("/feedback")
    public String getFeedback() {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String addFeedback(@RequestParam int rating,
                              @RequestParam String feedback,
                              HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        contactService.addFeedback(rating, feedback);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getUser_name().equals("admin")) {
                request.setAttribute("user_list", userService.getAllUsers());
                request.setAttribute("taken_quiz_list", quizService.getAllTakenQuiz());
                request.setAttribute("question_list", quizService.getAllQuestions());
                request.setAttribute("feedback_list", contactService.getAllFeedback());
                request.setAttribute("message_list", contactService.getAllMessage());
                request.setAttribute("category_list", quizService.getAllCategories());
                return "admin";
            }
            request.setAttribute("categories", quizService.getAllCategories());
            request.setAttribute("taken_quiz_list", quizService.getAllTakenQuizInfo(user.getUser_id()));
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/contact-us")
    public String getContactUs() {
        return "contact-us";
    }

    @PostMapping("/contact-us")
    public String addMessage(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String message,
                              HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        contactService.addMessage(name, email, message);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getUser_name().equals("admin")) {
                request.setAttribute("user_list", userService.getAllUsers());
                request.setAttribute("taken_quiz_list", quizService.getAllTakenQuiz());
                request.setAttribute("question_list", quizService.getAllQuestions());
                request.setAttribute("feedback_list", contactService.getAllFeedback());
                request.setAttribute("message_list", contactService.getAllMessage());
                request.setAttribute("category_list", quizService.getAllCategories());
                return "admin";
            }
            request.setAttribute("categories", quizService.getAllCategories());
            request.setAttribute("taken_quiz_list", quizService.getAllTakenQuizInfo(user.getUser_id()));
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }


}
