package com.example.taleview;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String won;

public Person(){
    this.firstName = "";
    this.lastName = "";
    this.won = "";
}

    public Person(String firstName, String lastName, String won)  {
        this.firstName = firstName;
        this.lastName = lastName;
        this.won = won;
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
    return  firstName +  lastName + won;
}

}
