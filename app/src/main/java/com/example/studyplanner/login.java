package com.example.studyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private CardView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.uname);
        Password = findViewById(R.id.pword);
        loginButton = findViewById(R.id.btn_sign_in);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    final String username = Username.getText().toString();
                    final String password = Password.getText().toString();

                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url ="http://192.168.1.108/CampuzWiz-VScode/login.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        String user_name = jsonResponse.getString("Name");
                                        String user_pass = jsonResponse.getString("Password");

                                        if (user_name.equals(username) && user_pass.equals(password)) {
                                            // If match, navigate to another activity
                                            Intent intent = new Intent(login.this, Home.class);
                                            startActivity(intent);
                                            finish(); // Finish current activity
                                            return; // Exit the method after successful login
                                        }
                                        // If credentials don't match, display an error message
                                        Toast.makeText(login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                                    } catch (JSONException e) {
                                        // If an error occurs while parsing JSON response, display an error message
                                        Toast.makeText(login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("username", username);
                            paramV.put("password", password);
                            return paramV;
                        }
                    };

                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }
            }
        });

        TextView btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_signup();
            }
        });
    }

    public void openactivity_signup() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    private boolean validateInputs() {
        String username = Username.getText().toString().trim();
        String currentPassword = Password.getText().toString().trim();

        if (username.isEmpty()) {
            Username.setError("Username is required");
            return false;
        }

        if (currentPassword.isEmpty()) {
            Password.setError("Current password is required");
            return false;
        }
        return true;
    }
}
