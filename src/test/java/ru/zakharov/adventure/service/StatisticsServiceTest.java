package ru.zakharov.adventure.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.zakharov.adventure.entity.Statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsServiceTest {
    Statistics statistics;

    @BeforeEach
    void init() {
        statistics = new Statistics("");
    }

    @Test
    void increaseScoreVICTORY() {
        StatisticsService.increaseScoreVICTORY(statistics);
        assertEquals(1, statistics.getScoreVictory());
    }

    @Test
    void increaseScoreDEFEAT() {
        StatisticsService.increaseScoreDEFEAT(statistics);
        assertEquals(1, statistics.getScoreDefeat());
    }

    @Test
    void increaseScore() {
        StatisticsService.increaseScore(statistics);
        assertEquals(1, statistics.getScore());
    }
}