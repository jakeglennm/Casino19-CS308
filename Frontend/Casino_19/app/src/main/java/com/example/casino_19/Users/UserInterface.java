package com.example.casino_19.Users;

import com.example.casino_19.Games.Pieces.Card;

import java.io.Serializable;

public abstract class UserInterface implements Serializable  {
    protected int id;
    protected int rank;
    protected String username;
    //protected String password;
    protected String email;
    protected String role;
    protected Card[] currentHand;
    protected int balance;
    protected int currentGameID;

    /**
     * User constructor that takes a userID as parameter
     */
    public UserInterface(int id, String username, String email)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.balance = 500;
        this.role = "noob";
    }


    /**
     * getter method for UserID
     */
    public int getUserID()
    {
        return id;
    }

    /**
     * getter method for User's username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * getter method for User's current hand
     */
    public Card[] getCurrentHand()
    {
        return currentHand;
    }

    public void setCurrentHand(Card[] cards){this.currentHand = cards;}

    /**
     * getter method for User's balance
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * set user balance
     * @param newBalance
     */
    public void setBalance(int newBalance){
        balance = newBalance;
    }

    /**
     * getter method for User's current game ID
     */
    public int getCurrentGameID()
    {
        return currentGameID;
    }


    /**
     * set user ID
     * @param id
     */
    public void setID(int id){this.id = id;}

    /**
     * set user's username
     * @param username
     */
    public void setUsername(String username){this.username = username;}

    /**
     * set user's email
     * @param email
     */
    public void setEmail(String email){this.email = email;}

    /**
     * set user's rank
     * @param rank
     */
    public void setUserRank(int rank){this.rank = rank;}

    /**
     * set user rank
     * @return
     */
    public int getUserRank(){return this.rank;}



    /*
     * to string method
     */
    @Override
    public String toString(){
        return "Id: " + id
                + " Username: " + username
                + " Email: " + email
                + " Balance: " + balance
                + " Role: " + role;
    }
}


