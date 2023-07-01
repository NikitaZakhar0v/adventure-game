package ru.zakharov.adventure.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.zakharov.adventure.db.DataBase;
import ru.zakharov.adventure.entity.Statistics;
import ru.zakharov.adventure.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    User user;
    @BeforeEach
    void init() {
        user = new User("", "", new Statistics(""));
    }

    @Test
    void newUserSavetoDb() {
        assertEquals(user, UserService.createNewUser("", "", ""));
        assertEquals(1, DataBase.getInstance().getUsers().size());
    }

    @Test
    void newUserHasFirstQuestion() {
        assertEquals(1, UserService.getQuestionWithName(user).getId());
    }

    @Test
    void newUserHasZeroStatistics() {
        UserService.updateStatistics(user);
        assertEquals(0, user.getStatistics().getScore());
        assertEquals(0, user.getStatistics().getScoreDefeat());
        assertEquals(0, user.getStatistics().getScoreVictory());
    }
}