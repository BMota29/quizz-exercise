package com.bmota.quizexercise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class Question {
    private Long id;
    private String question;
    private List<String> answers;
}
