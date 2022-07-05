package com.bmota.quizexercise.service;

import com.bmota.quizexercise.model.Question;
import com.bmota.quizexercise.model.service.quizService.QuizServiceResponse;

public interface QuizService {
    QuizServiceResponse getRandomQuestion(Integer numberOfQuestions, String difficulty);
}
