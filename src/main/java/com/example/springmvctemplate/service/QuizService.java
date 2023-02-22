package com.example.springmvctemplate.service;

import com.example.springmvctemplate.dao.*;
import com.example.springmvctemplate.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class QuizService {
    private ChoiceDao choiceDao;
    private QuestionDao questionDao;
    private CategoryDao categoryDao;
    private QuizInfoDao quizInfoDao;
    private ResultDao resultDao;
    private UserDao userDao;

    @Autowired
    public QuizService(ChoiceDao choiceDao,
                       QuestionDao questionDao,
                       CategoryDao categoryDao,
                       QuizInfoDao quizInfoDao,
                       ResultDao resultDao,
                       UserDao userDao) {
        this.choiceDao = choiceDao;
        this.questionDao = questionDao;
        this.categoryDao = categoryDao;
        this.quizInfoDao = quizInfoDao;
        this.resultDao = resultDao;
        this.userDao = userDao;
    }

    private List<Question> loadQuestions(List<Integer> question_id_list) {
        List<Question> question_list = new ArrayList<>();
        for (int question_id: question_id_list) {
            Question q = questionDao.getQuestionById(question_id);
            List<Choice> ch_list = choiceDao.getChoiceByQuestionId(question_id);
            q.setChoice_list(ch_list);
            question_list.add(q);
        }
        return question_list;
    }

    private List<Choice> loadUserAnswers(List<Integer> user_answer_id_list) {
        List<Choice> user_answer_list = new ArrayList<>();
        for (int user_answer_id: user_answer_id_list) {
            Choice user_answer = choiceDao.getChoiceById(user_answer_id);
            user_answer_list.add(user_answer);
        }
        return user_answer_list;
    }

    public List<Category> getAllCategories() {
        List<Category> ca_list = categoryDao.getAllCategory();
        for (Category ca: ca_list) {
            List<Integer> question_id_list = questionDao.getQuestionIdByCategoryId(ca.getCategory_id());
            ca.setCategory_question_ids(question_id_list);
        }
        return ca_list;
    }

    public List<Question> getAllQuestions() {
        List<Integer> qid_list = questionDao.getAllQuestionId();
        return loadQuestions(qid_list);
    }

    public void addQuestion(String category_name,
                            String question_content,
                            String choice1,
                            String choice2,
                            String choice3,
                            String choice4,
                            int correct_choice_num) {
        int category_id = categoryDao.getIdByCategoryName(category_name);
        questionDao.addQuestion(category_id, question_content, true);
        int question_id = questionDao.getQuestionIdByQuestionContent(question_content);
        List<String> choice_contents = new ArrayList<>();
        choice_contents.add(choice1);
        choice_contents.add(choice2);
        choice_contents.add(choice3);
        choice_contents.add(choice4);
        for (int i = 0; i < 4; i++) {
            boolean is_answer = false;
            if (i == correct_choice_num-1) {
                is_answer = true;
            }
            choiceDao.addChoice(question_id, choice_contents.get(i), is_answer);
        }
    }

    public void updateQuestion(int question_id,
                               String question_content,
                               String choice1,
                               String choice2,
                               String choice3,
                               String choice4,
                               int correct_choice_num) {
        questionDao.updateQuestionContentById(question_id, question_content);
        List<String> choice_contents = new ArrayList<>();
        choice_contents.add(choice1);
        choice_contents.add(choice2);
        choice_contents.add(choice3);
        choice_contents.add(choice4);
        List<Choice> ch_list = choiceDao.getChoiceByQuestionId(question_id);
        for (int i = 0; i < 4; i++) {
            boolean is_answer = false;
            if (i == correct_choice_num-1) {
                is_answer = true;
            }
            Choice ch = ch_list.get(i);

            choiceDao.updateChoiceContentById(ch.getChoice_id(), choice_contents.get(i), is_answer);
        }
    }

    public void activateOrSuspendQuestion(int question_id, String action) {
        questionDao.activateOrSuspendQuestionById(question_id, action);
    }

    public List<Quiz> getAllTakenQuizInfo(int user_id) {
        List<Quiz> taken_quiz_list = quizInfoDao.getQuizByUserId(user_id);
        return taken_quiz_list;
    }

    public List<Quiz> getAllTakenQuiz() {
        List<Integer> taken_quiz_id_list = quizInfoDao.getAllQuiz();
        List<Quiz> taken_quiz_list = new ArrayList<>();
        for (int taken_quiz_id: taken_quiz_id_list) {
            Quiz qu = loadTakenQuizById(taken_quiz_id);
            taken_quiz_list.add(qu);
        }
        Collections.sort(taken_quiz_list, new Comparator<Quiz>() {
            @Override
            public int compare(Quiz o1, Quiz o2) {
                return o2.getStart_time().compareTo(o1.getStart_time());
            }
        });
        return taken_quiz_list;
    }

    public Quiz loadTakenQuizById(int quiz_id) {
        Quiz qu = quizInfoDao.getQuizById(quiz_id);

        User user = userDao.getUserById(qu.getUser_id());
        String user_fullname = user.getFirstname() + " " + user.getLastname();
        qu.setUser_fullname(user_fullname);

        String category_name = categoryDao.getCategoryNameById(qu.getCategory_id());
        qu.setCategory_name(category_name);

        List<Integer> question_id_list = resultDao.getQuestionIdByQuizId(qu.getQuiz_id());
        List<Question> question_list = loadQuestions(question_id_list);
        qu.setQuestion_list(question_list);

        List<Integer> user_answer_id_list = new ArrayList<>();
        int score = 0;
        for (int question_id: question_id_list) {
            int user_answer_id = resultDao.getUserChoiceIdByQuizIdAndQuestionId(qu.getQuiz_id(), question_id);
            user_answer_id_list.add(user_answer_id);
            score += choiceDao.checkCorrect(user_answer_id);
        }
        List<Choice> user_answer_list = loadUserAnswers(user_answer_id_list);
        qu.setScore(score);
        qu.setUser_answer_id_list(user_answer_id_list);
        qu.setUser_answer_list(user_answer_list);

        return qu;
    }

    public Quiz prepareNewQuiz(int user_id, int category_id) {
        // initiate a new quiz
        Quiz new_quiz = new Quiz();
        new_quiz.setUser_id(user_id);
        User user = userDao.getUserById(user_id);
        String user_fullname = user.getFirstname() + " " + user.getLastname();
        new_quiz.setUser_fullname(user_fullname);
        new_quiz.setCategory_id(category_id);

        // load questions
        List<Integer> question_ids = questionDao.getQuestionIdByCategoryId(category_id);
        Collections.shuffle(question_ids);
        List<Integer> quiz_question_ids = question_ids.subList(0, 5);
        List<Question> quiz_questions = loadQuestions(quiz_question_ids);
        new_quiz.setQuestion_list(quiz_questions);

        // record start time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        new_quiz.setStart_time(currentTime);

        return new_quiz;
    }

    public Quiz collectQuizResult(Quiz quiz) {
        // record end time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        quiz.setEnd_time(currentTime);
        quizInfoDao.addQuiz(quiz);
        int quiz_id = quizInfoDao.getQuizId(quiz);

        List<Question> question_list = quiz.getQuestion_list();
        List<Integer> user_answer_id_list = quiz.getUser_answer_id_list();
        List<Choice> user_answer_list = new ArrayList<>();
        int score = 0;
        for (int i = 0; i < question_list.size(); i++) {
            Question q = question_list.get(i);
            int user_answer_id = user_answer_id_list.get(i);
            resultDao.addResult(quiz_id, q.getQuestion_id(), user_answer_id);
            Choice user_answer = choiceDao.getChoiceById(user_answer_id);
            user_answer_list.add(user_answer);
            score += choiceDao.checkCorrect(user_answer_id);
        }
        quiz.setScore(score);
        quiz.setUser_answer_list(user_answer_list);

        return quiz;
    }

}
