package ru.zakharov.adventure.service;

import org.junit.jupiter.api.Test;
import ru.zakharov.adventure.entity.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionServiceTest {

    @Test
    void findQuestionById() {
        Question questionById = QuestionService.findQuestionById(5);
        assertEquals(5, questionById.getId());
    }
}