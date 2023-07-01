package ru.zakharov.adventure.entity;


import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public final class Statistics implements Serializable {
    private final String ipAddress;
    private int scoreVictory;
    private int scoreDefeat;
    private int score;

    public Statistics(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public int getScoreVictory() {
        return this.scoreVictory;
    }

    public int getScoreDefeat() {
        return this.scoreDefeat;
    }

    public int getScore() {
        return this.score;
    }

    public void setScoreVictory(int scoreVictory) {
        this.scoreVictory = scoreVictory;
    }

    public void setScoreDefeat(int scoreDefeat) {
        this.scoreDefeat = scoreDefeat;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
