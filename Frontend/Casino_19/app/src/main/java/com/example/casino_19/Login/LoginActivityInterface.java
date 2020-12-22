package com.example.casino_19.Login;

import com.android.volley.RequestQueue;
import com.example.casino_19.Users.UserInterface;

/**
 * Interface for LoginActivity and DBLoginUtil interactions
 * @see LoginActivity
 * @see DBLoginUtil
 */
public interface LoginActivityInterface {


    void successfulLogin(LoginActivityInterface view, UserInterface user);
    void setErrorMsg(LoginActivityInterface view, String error);
    void setDatabaseUtil(DBLoginInterface dbInt);
    void setUser(UserInterface user);
    void setQueue(RequestQueue queue);

}
