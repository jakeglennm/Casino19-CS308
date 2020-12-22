package com.example.casino_19.Games;

import com.example.casino_19.Users.UserInterface;

/**
 * Abstract class for games
 */
public abstract class Game {
    protected UserInterface[] users;
    protected int buyInAmnt;
    protected int gameID;
    protected UserInterface currentPlayer;

    /**
     * Game constructor
     */
    public Game()
    {
        /*TODO
           - make this useful in initialization of each game.
            - possibly change protected variables to private variables with setters and getters?
            - initialize instance variables in constructive manner.
            - figure out which instance variables should be passed into the super() constructor
                of each game
         */
        this.users = null;
        this.buyInAmnt = 0;
        this.gameID = 0; //TODO game ID generation? Likely database call needed to complete
        this.currentPlayer = null;
    }

    /**
     * deals appropriate amount of cards to each player
     */
    public abstract void dealCards();

    /**
     * set the new current player
     */
    public abstract void setCurrentPlayer();

    /**
     * Returns user that is current player
     * @return currentPlayer the UserInterface of the current player
     */
    public UserInterface getCurrentPlayer()
    {
        return currentPlayer;
    }





}
