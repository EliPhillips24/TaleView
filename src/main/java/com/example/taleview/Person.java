package com.example.taleview;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String won;

    private String Subs;
    private String Content;
    private String where;

    public Person(String firstName, String lastName, String won, String subs, String content, String where) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.won = won;
        this.Subs = subs;
        this.Content = content;
        this.where = where;
    }

    public String getSubs() {
        return Subs;
    }

    public void setSubs(String subs) {
        Subs = subs;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

public String toString() {
    return  firstName +  lastName + won + Subs + Content + where;
}

}
