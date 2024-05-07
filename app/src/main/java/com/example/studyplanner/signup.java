package com.example.studyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText txt_username= findViewById(R.id.uname);
        EditText txt_password= findViewById(R.id.pword);
        EditText txt_email= findViewById(R.id.email);
        TextView btn_sign_in= findViewById(R.id.btn_sign_in);
        CardView btn_sign_up=findViewById(R.id.btn_sign_up);
        EditText errorhehe=findViewById(R.id.error);
        EditText error=findViewById(R.id.error2);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_login();
            }
        });


        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=txt_username.getText().toString();
                String pword=txt_password.getText().toString();
                String mail=txt_email.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.108/CampuzWiz-VScode/signup.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("Success")){
                                    Toast.makeText(signup.this, "Account Created", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(signup.this, "Failed to Create an Account", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(signup.this, response, Toast.LENGTH_SHORT).show();
                                   error.setText(response);

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // textView.setText("That didn't work!");
                        errorhehe.setText(error.toString());

                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("uname", uname);
                        paramV.put("pword", pword);
                        paramV.put("email", mail);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });



    }public void openactivity_login(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}