package com.example.casino_19.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.casino_19.Activities.Dashboard;
import com.example.casino_19.R;
import com.example.casino_19.Users.User;
import com.example.casino_19.Users.UserInterface;

/**
 * Class for handling the UI interactions of the user with the Sign up page
 * @see AppCompatActivity
 * @see LoginActivityInterface
 */
public class SignUpActivity extends AppCompatActivity implements LoginActivityInterface {

    private Button btnSubmit;
    private EditText inUsername, inPassword, inEmail;
    private String username,password,email;
    private TextView errorMsg;
    private DBLoginInterface dbUtility;
    private RequestQueue queue;
    private User user;

    /**
     * Locates fields that will be interacted with and assigns them to private variables
     * @param savedInstanceState information relevant to the state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.queue = Volley.newRequestQueue(this);

        this.inUsername = (EditText) findViewById(R.id.inUsername);
        this.inPassword = (EditText) findViewById(R.id.inPassword);
        this.inEmail = (EditText) findViewById(R.id.inEmail);
        this.errorMsg = (TextView)findViewById(R.id.errorMsg);

        this.dbUtility = new DBLoginUtil(queue, this);

        // Find buttons
        this.btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setEnabled(true);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Set Fields
                username = inUsername.getText().toString();
                password = inPassword.getText().toString();
                email = inEmail.getText().toString();

                //Attempt Signup
                dbUtility.attemptSignup(username, password, email);
            }
        });
    }

    /**
     * Upon successful account creation, this method redirects the user to the Dashboard
     * @see Dashboard
     * @param view relevant information about the current view
     * @param user the user's information
     */
    public void successfulLogin(LoginActivityInterface view, UserInterface user){
        //Go to dashboard
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtra("ThisUser", user);
        startActivity(intent);
    }

    /**
     * Displays any error the user encounters from the credentials the user attempts to use
     * in the creation of their account
     * @param view LoginActivityInterface
     * @param error what the user did to f*** up
     */
    public void setErrorMsg(LoginActivityInterface view, String error){
        errorMsg.setText(error);
    }

    /**
     * For testing purposes
     * @param dbInt
     */
    @Override
    public void setDatabaseUtil(DBLoginInterface dbInt) {
        dbUtility = dbInt;
    }

    /**
     * For testing purposes
     * @param user
     */
    @Override
    public void setUser(UserInterface user) {
//        this.user = user;
    }

    /**
     * For testing purposes
     * @param queue
     */
    @Override
    public void setQueue(RequestQueue queue) {
        this.queue = queue;
    }


}
