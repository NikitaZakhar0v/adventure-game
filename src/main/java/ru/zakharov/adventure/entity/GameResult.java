package ru.zakharov.adventure.entity;

import lombok.Getter;

@Getter
public enum GameResult {
    VICTORY("Победа"),
    DEFEAT("Поражение"),
    CONTINUE("Продолжение");

    private final String description;

    GameResult(String description) {
        this.description = description;
    }
}
