package com.example.springmvctemplate.controller;

import com.example.springmvctemplate.domain.User;
import com.example.springmvctemplate.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {
        User user = loginService.validateLogin(username, password);
        if (user != null) {
            HttpSession Session = request.getSession(false);
            if (Session != null) {
                Session.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("user", user);
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String firstname,
                               @RequestParam String lastname,
                               @RequestParam String phone,
                               @RequestParam String email,
                               @RequestParam String address,
                               HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null) {
            oldSession.invalidate();
        }
        HttpSession newSession = request.getSession(true);
        loginService.register(username, password, firstname, lastname, phone, email, address);
        newSession.setAttribute("registerSuccess", true);
        return "redirect:/login";
    }


}
