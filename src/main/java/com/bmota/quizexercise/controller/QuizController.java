package com.bmota.quizexercise.controller;

import com.bmota.quizexercise.converter.QuizResponseConverter;
import com.bmota.quizexercise.model.Question;
import com.bmota.quizexercise.service.QuizService;
import com.bmota.quizexercise.service.impl.QuizServiceHardCodeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizResponseConverter quizResponseConverter;

    @GetMapping("/question")
    public List<Question> createQuestion(@RequestParam(defaultValue = "1") Integer numberOfQuestions,
                                         @RequestParam(defaultValue = "medium") String difficulty) {
        var response =  quizService.getRandomQuestion(numberOfQuestions, difficulty);
        return quizResponseConverter.convertQuizServiceResponseList(response);
    }
}
