package com.bmota.quizexercise.converter;

import com.bmota.quizexercise.model.Question;
import com.bmota.quizexercise.model.service.quizService.QuestionResponse;
import com.bmota.quizexercise.model.service.quizService.QuizServiceResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

@Component
public class QuizResponseConverter {

    public List<Question> convertQuizServiceResponseList(QuizServiceResponse quizServiceResponseList) {
        return quizServiceResponseList.getResults().stream()
                .map(this::convertQuizServiceResponse)
                .collect(Collectors.toList());
    }

    private Question convertQuizServiceResponse(QuestionResponse questionResponse) {
        return Question.builder()
                .withQuestion(questionResponse.getQuestion())
                .withAnswers(getAnswers(questionResponse.getCorrectAnswer(), questionResponse.getIncorrectAnswers()))
                .build();
    }

    private List<String> getAnswers(String correctAnswer, List<String> incorrectAnswers) {
        var answers = new ArrayList<>(incorrectAnswers);
        answers.add(getRandomPosition(answers.size()), correctAnswer);
        return answers;
    }

    private int getRandomPosition(int max) {
        SplittableRandom splittableRandom = new SplittableRandom();
        return splittableRandom.nextInt(0, max + 1);
    }

}
