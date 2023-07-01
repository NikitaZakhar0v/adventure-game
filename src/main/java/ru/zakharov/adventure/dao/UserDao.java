package ru.zakharov.adventure.dao;

import ru.zakharov.adventure.db.DataBase;
import ru.zakharov.adventure.entity.User;

public final class UserDao implements Dao<User> {
    private final DataBase dataBase = DataBase.getInstance();

    @Override
    public void save(User user) {
        dataBase.getUsers().put(user.getId(), user);
    }

    @Override
    public User delete(User user) {
        return dataBase.getUsers().remove(user.getId());
    }

}
