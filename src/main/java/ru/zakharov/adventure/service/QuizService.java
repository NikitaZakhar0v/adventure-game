package ru.zakharov.adventure.service;

import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.Quiz;
import ru.zakharov.adventure.utils.Loader;

@UtilityClass
public final class QuizService {
    private final Quiz quiz = Loader.loadQuiz();
    public Quiz getQuiz(){
        return quiz;
    }
}
