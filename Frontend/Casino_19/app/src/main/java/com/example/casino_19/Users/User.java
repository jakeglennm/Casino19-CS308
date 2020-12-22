package com.example.casino_19.Users;

public class User extends UserInterface {

    public User(int id, String username, String email){
        super(id, username, email);
        balance = 0;
        rank = 0;
        role = "user";
    }

    public User(){
        this(-1, null, null);
    }

    public void setID(int id){this.id = id;}
    public void setUsername(String username){this.username = username;}
    public void setEmail(String email){this.email = email;}

}
