package com.cs309.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class JsonRequestActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "HELP";
    private Button btnjsonPost;
    private TextView output1;
    String URL, username, password, email;
    RequestQueue Queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        email = getIntent().getStringExtra("email");

        btnjsonPost = (Button) findViewById(R.id.btnjsonPost);
        output1 = (TextView) findViewById(R.id.output1);

        btnjsonPost.setOnClickListener(this);

        //Instantiate request queue to send requests
        Queue = Volley.newRequestQueue(this);
        //TODO
        URL = getResources().getString(R.string.local);

    }

    /**
     * Making json object request
     * */
    private void makeJsonObjReq(String url) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null, // IF YOU WANT TO SEND A JSONOBJECT WITH POST THEN PASS IT HERE
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        output1.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("email", email);
                return params;
            }

        };

        // Adding request to request queue
        Queue.add(jsonObjReq);

        // Cancelling request
        // Queue.cancelAll(tag_json_obj);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnjsonPost:
                makeJsonObjReq(URL + "/jsonObjPost");
                break;
            default:
                break;
        }
    }

}
