package ru.zakharov.adventure.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.zakharov.adventure.entity.Answer;
import ru.zakharov.adventure.entity.GameResult;
import ru.zakharov.adventure.entity.Question;
import ru.zakharov.adventure.entity.Quiz;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizLoaderTest {
    private static Question firstQuestion;
    private static Question lastQuestion;
    private static Answer answer;

    @BeforeAll
    static void init(){
        Quiz quiz = Loader.loadQuiz();
        List<Question> questions = quiz.questions();
        firstQuestion = questions.get(0);
        lastQuestion = questions.get(6);
        answer = firstQuestion.getAnswers().stream().filter(answerWithId1 -> answerWithId1.id() == 1).findFirst().get();
    }

    @Test
    void checkTheCorrectDownloadFirstQuestion(){
        int questionId = firstQuestion.getId();
        String text = firstQuestion.getText();
        GameResult result = firstQuestion.getResult();
        int size = firstQuestion.getAnswers().size();
        assertEquals(1, questionId);
        assertEquals("Здравствуй %s. Ты потерял память. Принять вызов?", text);
        assertEquals(GameResult.CONTINUE, result);
        assertEquals(2, size);

    }
    @Test
    void checkTheCorrectDownloadLastQuestion(){
        int questionId = lastQuestion.getId();
        String text = lastQuestion.getText();
        GameResult result = lastQuestion.getResult();
        int size = lastQuestion.getAnswers().size();
        assertEquals(7, questionId);
        assertEquals("Тебя вернули домой.", text);
        assertEquals(GameResult.VICTORY, result);
        assertEquals(0, size);

    }

    @Test
    void checkTheCorrectDownloadFirstAnswer(){
        int id = answer.id();
        String text = answer.text();
        int nextQuestionId = answer.nextQuestionId();
        assertEquals(1, id);
        assertEquals("Отклонить вызов", text);
        assertEquals(2, nextQuestionId);
    }

}