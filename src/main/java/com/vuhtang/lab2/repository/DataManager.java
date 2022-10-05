package com.vuhtang.lab2.repository;

import com.vuhtang.lab2.utils.Shot;

import java.util.List;

public interface DataManager {
    void add(Shot shot);

    void removeAll();

    List<Shot> getAll();
}
