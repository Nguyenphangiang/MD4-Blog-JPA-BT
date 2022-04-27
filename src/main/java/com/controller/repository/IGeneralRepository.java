package com.controller.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> showAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);


}
