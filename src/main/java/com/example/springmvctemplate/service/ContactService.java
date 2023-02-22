package com.example.springmvctemplate.service;

import com.example.springmvctemplate.dao.FeedbackDao;
import com.example.springmvctemplate.dao.MessageDao;
import com.example.springmvctemplate.domain.Feedback;
import com.example.springmvctemplate.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private FeedbackDao feedbackDao;
    private MessageDao messageDao;

    @Autowired
    public ContactService(FeedbackDao feedbackDao, MessageDao messageDao) {
        this.feedbackDao = feedbackDao;
        this.messageDao = messageDao;
    }

    public void addFeedback(int rating, String feedback) {
        feedbackDao.addFeedback(rating, feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackDao.getAllFeedback();
    }

    public void addMessage(String name, String email, String message) {
        messageDao.addMessage(name, email, message);
    }

    public List<Message> getAllMessage() {
        return messageDao.getAllMessage();
    }




}
