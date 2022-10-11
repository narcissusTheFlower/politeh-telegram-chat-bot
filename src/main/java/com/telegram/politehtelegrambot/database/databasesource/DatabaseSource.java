package com.telegram.politehtelegrambot.database.databasesource;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSource<T> {
    public DatabaseSource() {

    }

    public boolean insert(T obj) {
        throw new NotImplementedException();
    }
    public List<T> selectAll(){
        throw new NotImplementedException();
    }

    public boolean delete(T obj) {
        throw new NotImplementedException();
    }

}
