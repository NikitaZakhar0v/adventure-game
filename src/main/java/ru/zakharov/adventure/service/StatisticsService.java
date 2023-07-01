package ru.zakharov.adventure.service;

import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.Statistics;
@UtilityClass
public final class StatisticsService {

    public void increaseScoreVICTORY(Statistics statistics){
        var scoreWin = statistics.getScoreVictory();
        statistics.setScoreVictory(++scoreWin);
        increaseScore(statistics);
    }
    public void increaseScoreDEFEAT(Statistics statistics){
        var scoreLose = statistics.getScoreDefeat();
        statistics.setScoreDefeat(++scoreLose);
        increaseScore(statistics);
    }
    public void increaseScore(Statistics statistics){
        var score = statistics.getScore();
        statistics.setScore(++score);
    }
}
