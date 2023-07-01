package ru.zakharov.adventure.servlet;

import lombok.SneakyThrows;
import ru.zakharov.adventure.service.RequestPostService;
import ru.zakharov.adventure.utils.JspHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz")
public final class QuizServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        RequestPostService.process(req);
        if(!resp.isCommitted()) {
            req.setAttribute("question", RequestPostService.getCurrentQuestion(req));
            req.getRequestDispatcher(JspHelper.getPath("quiz")).forward(req, resp);
        }
    }
}
