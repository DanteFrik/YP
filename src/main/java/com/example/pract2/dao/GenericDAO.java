package com.example.pract2.dao;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();
    T getById(int id);
    void create(T model);
    void update(int id, T model);
    void delete(int id);
}
