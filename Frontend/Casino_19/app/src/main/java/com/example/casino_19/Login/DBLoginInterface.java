package com.example.casino_19.Login;

import com.example.casino_19.Users.User;

import org.json.JSONObject;

/**
 * Interface for Login interactions
 */
public interface DBLoginInterface {
    void attemptLogin (String userKey, String Password);
    User buildUser(JSONObject json);
    boolean validateLoginInfo(String username, String password, String email);
    void attemptSignup(String username, String password, String email);
    void onFailureToLogin();
}
