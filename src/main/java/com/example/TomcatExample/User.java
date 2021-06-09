package com.example.TomcatExample;

import java.util.Objects;

public class User {

    private boolean authenticated;
    private final String username;

    public User(String username){
        this.username = username;
        this.authenticated = false;
    }

    public User(String username, String password){
        this.username = username;
        this.authenticated = authenticate(password);
    }

    public UserData getUserData(){
        //TODO database of users
        return new UserData("Ezra", "Mitchell");
    }

    public boolean authenticate(String password){
        if(isAuthenticated()) return true;
        //TODO replace with database
        if(username.equals("user") && password.equals("123")){
            return (authenticated = true);
        }
        return false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return authenticated == user.authenticated && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticated, username);
    }
}
