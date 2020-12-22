package com.example.casino_19.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.casino_19.Activities.Dashboard;
import com.example.casino_19.R;
import com.example.casino_19.Users.User;
import com.example.casino_19.Users.UserInterface;

/**
 * Class that interacts with the UI of the login page
 * @see AppCompatActivity
 * @see LoginActivityInterface
 */
public class LoginActivity extends AppCompatActivity implements LoginActivityInterface {
    private EditText userKey, password;
    private RequestQueue queue;
    private static final String URL = "http://coms-309-rp-10.cs.iastate.edu:8080/";

    private DBLoginInterface dbUtility;
    private UserInterface user;

    public Button submit;
    public Button signup;

    //CONSTRUCTOR OF ACTIVITY

    /**
     * On creation of the page, locates important elements by ID and sets click-listeners for buttons
     * @param savedInstanceState passes any important information about the app state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        this.userKey = (EditText)findViewById(R.id.userKey);
        this.password = (EditText)findViewById(R.id.password);

        this.queue = Volley.newRequestQueue(this);
        this.dbUtility = new DBLoginUtil(queue,this);

        this.user = new User();

        submit = (Button) findViewById(R.id.submitBtn);
        signup = (Button) findViewById(R.id.createAccount);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dbUtility.attemptLogin(userKey.getText().toString(),password.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signUpRedirect(view);
            }
        });
    }

    //SETTERS/INJECTORS for testing
    /**
     * Sets the database utility for testing purposes
     * @param dbInt DBLoginInterface for test
     */
    public void setDatabaseUtil(DBLoginInterface dbInt){
        dbUtility = dbInt;
    }

    /**
     * Sets user for testing purposes
     * @param user User Object for test
     */
    public void setUser(UserInterface user){
        this.user = user;
    }

    /**
     * Sets volley request queue for testing purposes
     * @param queue RequestQueue for test
     */
    public void setQueue(RequestQueue queue){
        this.queue = queue;
    }

    //NEW VIEWS

    /**
     * Upon successful login, this method redirects the user to the Dashboard and passes the user's information
     * @param view information from the current view of the app
     * @param user user's information from successful login
     * @see Dashboard
     */
    public void successfulLogin(LoginActivityInterface view, UserInterface user) {
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtra("ThisUser", user);
        startActivity(intent);
    }

    /**
     * Sets error message for failed login
     * @param view information about the current view
     * @param error error for display
     */
    public void setErrorMsg(LoginActivityInterface view, String error){
        //TODO create error message
    }

    /**
     * Redirects user to the sign up page
     * @param view information about the current view
     */
    public void signUpRedirect(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}