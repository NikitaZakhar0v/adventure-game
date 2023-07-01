package ru.zakharov.adventure.service;

import lombok.experimental.UtilityClass;
import ru.zakharov.adventure.dao.UserDao;
import ru.zakharov.adventure.entity.GameResult;
import ru.zakharov.adventure.entity.Question;
import ru.zakharov.adventure.entity.Statistics;
import ru.zakharov.adventure.entity.User;

@UtilityClass
public final class UserService {
    private final UserDao userDao = new UserDao();

    public User createNewUser(String id, String name, String ipAddress){
        User user = new User(id, name, new Statistics(ipAddress));
        userDao.save(user);
        return user;
    }
    public User delete(User user){
        return userDao.delete(user);
    }

    public Question getQuestionWithName(User user){
        Question question = QuestionService.findQuestionById(user.getQuestionId());
        question.setText(String.format(question.getText(), user.getName()));
        return question;
    }
    public void updateStatistics(User user){
        Question question = getQuestionWithName(user);
        Statistics statistics = user.getStatistics();
        if(question.getResult().equals(GameResult.VICTORY)){
            StatisticsService.increaseScoreVICTORY(statistics);
        } else if (question.getResult().equals(GameResult.DEFEAT)) {
            StatisticsService.increaseScoreDEFEAT(statistics);
        }
    }
}
