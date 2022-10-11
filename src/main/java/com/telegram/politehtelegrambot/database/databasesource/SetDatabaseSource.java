package com.telegram.politehtelegrambot.database.databasesource;

import java.util.*;

public class SetDatabaseSource<T> extends DatabaseSource<T>{
    Set<T> data;

    public SetDatabaseSource(Comparator<T> comparator) {
        data = new TreeSet<>(comparator);
    }

    @Override
    public boolean insert(T obj) {
        return data.add(obj);
    }

    @Override
    public List<T> selectAll() {
        return data.stream().toList();
    }

    @Override
    public boolean delete(T obj) {
        data.remove(obj);
        return true; // FIXME
    }
}
