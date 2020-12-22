package com.example.casino_19;

//import org.mockito.Mockito.*;
import android.content.Context;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.casino_19.Login.DBLoginUtil;
import com.example.casino_19.Login.LoginActivity;
import com.example.casino_19.Login.LoginActivityInterface;
import com.example.casino_19.Login.SignUpActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Locale;
import java.util.Queue;

@RunWith(MockitoJUnitRunner.class)
public class LoginMockTesting {

    @Mock
    private Context context;

    @Mock
    private DBLoginUtil loginTestUtil;

//    @Mock
//    private LoginActivityInterface testingView;

    @Mock
    private RequestQueue mockQueue;
    //this.queue = Volley.newRequestQueue(this);


    @Test
    public void testLoginActivity(){

        LoginActivity activity = new LoginActivity();

        //init mocking stuff
        //context = new LoginActivity();
        loginTestUtil = new DBLoginUtil(mockQueue, activity);

        //injecting mock stuff
        activity.setDatabaseUtil(loginTestUtil);
        activity.setQueue(mockQueue);

        //activity.findViewById(R.id.inEmail).perform(type)



    }

    @Test
    public void testSignupActivity(){

        //start activity
        //create mock server stuff (DB Login Util)
        LoginActivity activity = new LoginActivity();

        //injecting dependecies
        activity.setDatabaseUtil(loginTestUtil);



    }

    @Test
    public void testBuildingUser(){

    }

    @Test
    public void testServerRequests(){

    }


}
