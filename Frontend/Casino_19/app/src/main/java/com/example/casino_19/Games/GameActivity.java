package com.example.casino_19.Games;

/**
 * Interface for Games
 * @see Game
 */
public interface GameActivity {

    /**
     * Updates the displayed balance of a user
     * @param response string of integer balance of user
     */
    void updateBalanceDisplay(String response);

    /**
     * Updates the user's balance
     * @param response integer value of the user's balance
     */
    void updateUserBalance(int response);

    void printToTerminal(String tempDisplay);
}
