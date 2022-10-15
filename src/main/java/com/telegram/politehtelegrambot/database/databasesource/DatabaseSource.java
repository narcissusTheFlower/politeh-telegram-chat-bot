package com.telegram.politehtelegrambot.database.databasesource;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseSource<T> {

    public abstract boolean insert(T obj);
    public abstract List<T> selectAll();

    public abstract boolean delete(T obj);

}
