package com.vuhtang.lab2.repository;

import com.vuhtang.lab2.utils.Shot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataManagerImpl implements DataManager {
    private final List<Shot> collection = new LinkedList<>();

    @Override
    public void add(Shot shot) {
        collection.add(shot);
    }

    @Override
    public void removeAll() {
        collection.clear();
    }

    @Override
    public List<Shot> getAll() {
        return new ArrayList<>(collection);
    }
}
