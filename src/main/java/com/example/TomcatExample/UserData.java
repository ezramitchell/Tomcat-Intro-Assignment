package com.example.TomcatExample;

public class UserData {

    private final String firstName;
    private final String lastName;

    public UserData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName + ' ' + lastName;
    }
}
