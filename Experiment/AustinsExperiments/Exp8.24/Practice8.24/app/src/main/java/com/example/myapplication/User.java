package com.example.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    protected String email;
    protected String username;
    protected String password;

    User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;

    }

    @Override
    public String toString(){

        String result = email + "\n" + username + "\n" + password;

        return result;
    }

    public static String toJSon(User user){

            try {

                JSONObject jsonObj = new JSONObject();
                jsonObj.put("email", user.email); // Set the first name/pair
                jsonObj.put("username", user.username);
                jsonObj.put("password", user.password);

                return jsonObj.toString();

            }catch (JSONException ex){
                ex.printStackTrace();
            }


            return null;
    }










}
