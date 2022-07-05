package com.bmota.quizexercise.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class QuizControllerTest {

    @Autowired
    private QuizController quizController;

    @Test
    public void givenIWantToCreateOneQuestion_iShouldGetQuestionDetails() {
        var numberOfQuestions = 1;
        var difficulty = "easy";
        var questions = quizController.createQuestion(numberOfQuestions, difficulty);
        assertNotNull(questions);
        assertEquals(1, questions.size());
        //assertNotNull(questions.get(0).getId());
        assertNotNull(questions.get(0).getQuestion());
        assertNotNull(questions.get(0).getAnswers());
    }

}