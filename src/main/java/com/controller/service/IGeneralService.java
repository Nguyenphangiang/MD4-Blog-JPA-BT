package com.controller.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> showAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
