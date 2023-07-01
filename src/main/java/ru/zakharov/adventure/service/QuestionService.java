package ru.zakharov.adventure.service;

import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.Question;

@UtilityClass
public final class QuestionService {
    public Question findQuestionById(int id) {
        return QuizService.getQuiz().questions().stream()
                .filter(question -> question.getId() == id)
                .findFirst()
                .orElse(QuizService.getQuiz().questions().get(0));
    }
}
