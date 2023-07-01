package ru.zakharov.adventure.db;

import lombok.Getter;
import ru.zakharov.adventure.entity.User;

import java.util.HashMap;
import java.util.Map;

public final class DataBase {
    @Getter
    private final Map<String, User> users = new HashMap<>();

    private static final DataBase INSTANCE = new DataBase();
    private DataBase(){
    }
    public static DataBase getInstance(){
        return INSTANCE;
    }
}
