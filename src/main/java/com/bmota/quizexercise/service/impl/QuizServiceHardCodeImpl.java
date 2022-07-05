package com.bmota.quizexercise.service.impl;

import com.bmota.quizexercise.model.Question;
import com.bmota.quizexercise.model.service.quizService.QuestionResponse;
import com.bmota.quizexercise.model.service.quizService.QuizServiceResponse;
import com.bmota.quizexercise.service.QuizService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@ConditionalOnProperty(
        value="quiz-service.enabled",
        havingValue = "false")
public class QuizServiceHardCodeImpl implements QuizService {

    @Override
    public QuizServiceResponse getRandomQuestion(Integer numberOfQuestions, String difficulty) {
        var question = QuestionResponse.builder()
                .category("random")
                .question("Bulls are attracted to the color red.")
                .correctAnswer("True")
                .incorrectAnswers(List.of("False"))
                .build();
        return QuizServiceResponse.builder()
                .responseCode(0)
                .results(Collections.singletonList(question))
                .build();
    }

}
