package com.bmota.quizexercise.service.impl;

import com.bmota.quizexercise.model.service.quizService.QuizServiceResponse;
import com.bmota.quizexercise.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        value="quiz-service.enabled",
        havingValue = "true")
public class QuizServiceImpl implements QuizService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public QuizServiceResponse getRandomQuestion(Integer numberOfQuestions, String difficulty) {
        String quizUrl = "https://opentdb.com/api.php?amount={numberOfQuestions}&difficulty={difficulty}";
        var url = quizUrl
                .replace("{numberOfQuestions}", numberOfQuestions.toString())
                .replace("{difficulty}", difficulty);
        return restTemplateBuilder.build()
                .getForObject(url, QuizServiceResponse.class);
    }

}
