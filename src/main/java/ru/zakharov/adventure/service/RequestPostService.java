package ru.zakharov.adventure.service;

import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.entity.Question;
import ru.zakharov.adventure.entity.User;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public final class RequestPostService {
    private final String RADIO = "answerRadio";

    public static void process(HttpServletRequest req) {
        var parameter = req.getParameter(RADIO);
        if(parameter == null){
            return;
        }
        var user = (User) req.getSession().getAttribute("user");
        user.setQuestionId(Integer.parseInt(parameter));
    }

    public Question getCurrentQuestion(HttpServletRequest req) {
        return UserService.getQuestionWithName((User) req.getSession().getAttribute("user"));
    }
}
