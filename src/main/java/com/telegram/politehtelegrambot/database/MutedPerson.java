package com.telegram.politehtelegrambot.database;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Date;

public class MutedPerson {
    private long id;
    private String username;
    private Date tillDate;

    public MutedPerson(long id, String username, Date tillDate) {
        this.id = id;
        this.username = username;
        this.tillDate = tillDate;
    }
    public MutedPerson(long id, String username) {
        this.id = id;
        this.username = username;
        this.tillDate = new Date(Long.MAX_VALUE);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTillDate() {
        return tillDate;
    }

    public void setTillDate(Date tillDate) {
        this.tillDate = tillDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean samePerson(MutedPerson person){
        return (this.getId()!= -1 && this.getId() == person.getId() || this.getUsername().equals(person.getUsername()));
    }
    public boolean samePerson(User person){
        return (this.getId()!= -1 && this.getId() == person.getId()) || this.getUsername().equals(person.getUserName());
    }
    @Override
    public String toString() {
        if(getId() == -1){
            return "@" + getUsername();
        }else{
            return getId() + "@" + getUsername();
        }
    }
}

