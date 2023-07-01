package ru.zakharov.adventure.dao;

public interface Dao<T> {
    void save(T t);
    T delete(T t);
}
