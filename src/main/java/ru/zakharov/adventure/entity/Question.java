package ru.zakharov.adventure.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
public final class Question {
    private final int id;
    @Setter
    private String text;
    private final Set<Answer> answers;
    private final GameResult result;

    public Question(int id, String text, Set<Answer> answers, GameResult result) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.result = result;
    }
}
