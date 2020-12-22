package com.example.casino_19.Login;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.casino_19.Users.User;
import com.example.casino_19.Users.UserInterface;
import com.google.gson.Gson;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for handling login and sign up interactions with the database
 */
public class DBLoginUtil implements DBLoginInterface {


    private static final String URL = "http://coms-309-rp-10.cs.iastate.edu:8080/";
    public User user;
    private LoginActivityInterface loginActivityInterface;
    private Response.Listener<JSONObject> listener;

    private final static String TAG = "loginAttempt";
    private RequestQueue queue;

    /**
     * Constructor for DBLoginUtil
     * @param queue RequestQueue for Volley requests
     * @param view the LoginActivityInterface for interactions with the frontend
     * @see LoginActivityInterface
     */
    public DBLoginUtil(RequestQueue queue, LoginActivityInterface view){
        this.queue = queue;
        this.user = new User();
        this.loginActivityInterface = view;

        listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                user = buildUser(response);
                loginActivityInterface.successfulLogin(loginActivityInterface, user);
            }
        };


    }

    /**
     * Attempts a login against the database
     * @param userKey either the username or email of the user for attempted login
     * @param password password given by user to try against the database
     */
    @Override
    public void attemptLogin(String userKey, String password) {

        String tempURL = URL;
        tempURL += "login?";
        tempURL += addParam("userkey", userKey);
        tempURL += addParam("password", password);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                tempURL, null, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("there has been an login error!!");
                user = null;
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                onFailureToLogin();
            }
        });

        queue.add(jsonObjReq);
    }

    /**
     * Attempts account sign up with the database
     * @param username username for new user
     * @param password password for new user
     * @param email email of new user
     */
    public void attemptSignup(String username, String password, String email){

        //makes sure that info is valid(will throw error if not)
        if(validateLoginInfo(username, password, email)){

            String tempURL = URL;
            tempURL += "user";

            JSONObject json = buildJson(username, password, email, 500);

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    tempURL, json, listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("there has been an signup error!!");
                    loginActivityInterface.setErrorMsg(loginActivityInterface, "Username or Email has already been taken!");
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to request queue
            queue.add(jsonObjReq);

        }

    }

    /**
     * Upon login failure, this handles the failed login
     */
    public void onFailureToLogin(){
        //TODO Need error message if login doesn't work
    }

    /**
     * From a 'user' in JSON Object from, a User object is constructed and returned
     * @param json JSON Object containing a 'user' object
     * @see JSONObject
     * @see User
     * @return User object
     */
    public User buildUser(JSONObject json){
        User temp;
        Gson gson = new Gson();                             //create Gson
        temp = gson.fromJson(json.toString(),User.class);   //parse jsp
        System.out.println(temp.toString());
      return temp;
    }

    /**
     * Creates a JSON Object that represents a user built from its attributes
     * @see JSONObject
     * @param username username string
     * @param password password string
     * @param email email string
     * @param balance balance int
     * @return JSONObject of the user's information
     */
    public JSONObject buildJson(String username, String password, String email, int balance){

        HashMap params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        params.put("email", email);
        params.put("balance", balance);

        return new JSONObject(params);
    }

    /**
     * For parameters to be passed in the URL of a GET or POST request,
     * they must be in the form of: <key>=<value>
     *     where <key> is replaced with the key for the path parameter
     *     and <value> is the information being passed by the path parameter
     *     the '&' is being passed so that multiple path parameters can be concatenated to be passed together
     * @param key name of the parameter being passed
     * @param data value being passed
     * @return string that can be concatenated to the URL used for the request
     */
    public static String addParam(String key, String data){
        return key + "=" + data + "&";
    }

    //TODO mock from signup (mock dbutil to check for validation)
    //Method uses regular expressions to validate the forms of the username, password, and email entered

    /**
     * This method validates whether or not a username, password, and email
     * are in a valid form to have an account created from them. Through the utilization of
     * regular expressions, the form of each piece of the given user credentials meets our specifications.
     * @param username
     * @param password
     * @param email
     * @return
     */
    public boolean validateLoginInfo(String username, String password, String email) {
        String errorString = "";
        boolean valid = true;

        if(!username.matches("^\\w+$")){
            errorString += "-Username: must be alphanumeric and contain no symbols\n";
            valid = false;
        }

        //Search for at least 1 alphabetical character in the password
        Pattern alphanumeric = Pattern.compile("[a-zA-Z]");
        Matcher alphaMatch = alphanumeric.matcher(password);
        boolean alpha = alphaMatch.find();

        //Search for at least 1 number in the password
        Pattern numeric = Pattern.compile("\\d");
        Matcher numericMatch = numeric.matcher(password);
        boolean num = numericMatch.find();

        //Search for at least 1 special character in the password
        Pattern specialChar = Pattern.compile("[\\`\\~\\!@#$%^&*+?]");
        Matcher specialMatch = specialChar.matcher(password);
        boolean special = specialMatch.find();

        //Search for at least 1 special character in the password
        Pattern invalidChar = Pattern.compile("[^\\w\\`\\~\\!@#$%^&*+?]");
        Matcher invalidMatch = invalidChar.matcher(password);

        if(!(password.matches("^[\\w\\`\\~!@#$%^&*+?]{8,}$")
                && alpha && num && special)){
            errorString += "-Password: ";
            boolean passwordErrorFound = false;
            valid = false;

            if(password.length() < 8){
                errorString += "must be longer than 8 characters\n";
                passwordErrorFound = true;
            }
            if(!alpha){
                errorString += "must contain at least one alphabetical character\n";
                passwordErrorFound = true;
            }
            if(!num){
                errorString += "must contain at least one number\n";
                passwordErrorFound = true;
            }
            if(!special){
                errorString += "must contain at least one special character\n";
                passwordErrorFound = true;
            }
            if(!passwordErrorFound){
                errorString += "do not use \"";
                while(invalidMatch.find()){
                    errorString += invalidMatch.group();
                }
                errorString += "\", in your password\n";
            }

        }
        if(!email.matches("^\\w{3,}@\\w+\\.\\w+$")){
            errorString += "-Email: Please enter email in the form of\n'XXX@XXX.XXX' where 'X' is alphanumeric";
            valid = false;
        }

        loginActivityInterface.setErrorMsg(loginActivityInterface, errorString);

        return valid;
    }

}
