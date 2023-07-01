package ru.zakharov.adventure.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuizServiceTest {

    @Test
    void getQuiz() {
        assertNotNull(QuizService.getQuiz());
    }
}