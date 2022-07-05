package com.bmota.quizexercise.model.service.quizService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class QuizServiceResponse {
    @JsonProperty("response_code")
    private int responseCode;
    private List<QuestionResponse> results;
}
