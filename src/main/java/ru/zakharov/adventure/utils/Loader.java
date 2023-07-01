package ru.zakharov.adventure.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.Answer;
import ru.zakharov.adventure.entity.GameResult;
import ru.zakharov.adventure.entity.Question;
import ru.zakharov.adventure.entity.Quiz;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public final class Loader {
    private Map<String, Object> quizMap;

    static {
        loadMapFromJsonFile();
    }

    public Quiz loadQuiz() {
        var questions = (ArrayList<HashMap<String, Object>>) quizMap.get("questions");
        List<Question> collect = questions.stream().map(Loader::loadQuestion).toList();
        return new Quiz(collect);
    }

    private Question loadQuestion(HashMap<String, Object> question) {
        int id = (Integer) question.get("id");
        String text = (String) question.get("text");
        var answers = (ArrayList<HashMap<String, Object>>) question.get("answers");
        GameResult result = GameResult.valueOf(question.get("result").toString());
        if (answers == null) {
            return new Question(id, text, Collections.emptySet(), result);
        }
        Set<Answer> collect = answers.stream().map(Loader::loadAnswer).collect(Collectors.toSet());
        return new Question(id, text, collect, result);
    }

    private Answer loadAnswer(HashMap<String, Object> answer) {
        int id = (Integer) answer.get("id");
        String text = (String) answer.get("answer");
        int nextQuestionId = (Integer) answer.get("nextQuestionId");
        return new Answer(id, text, nextQuestionId);
    }

    private void loadMapFromJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            quizMap = mapper.readValue(Loader.class.getClassLoader().getResourceAsStream("question_answer.json"),
                    new TypeReference<>(){});
        } catch (IOException e) {
            throw new ConverterException(e);
        }
    }

    private static class ConverterException extends RuntimeException {
        public ConverterException(IOException massage) {
            super(massage);
        }
    }
}
