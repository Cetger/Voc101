package com.example.nocim.voc101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    TextView butontextgeri;

    EditText name,surname,username,email,password;
    Spinner dil;

    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.wp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        butontextgeri=findViewById(R.id.ihave);

        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        dil=findViewById(R.id.dil);

        sign=findViewById(R.id.signup);

        butontextgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(Register.this,Login.class);
                startActivity(ıntent);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kayıtfonksiyonu();

            }
        });


    }

    private void kayıtfonksiyonu(){

        String url = "http://35.242.201.109:3000/ekle";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Register.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, "error", Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                params.put("name", name.getText().toString().trim());
                params.put("surname", surname.getText().toString().trim());
                params.put("username", username.getText().toString().trim());
                params.put("password", password.getText().toString().trim());
                params.put("email", email.getText().toString().trim());
                params.put("language", dil.getTransitionName().toString().trim());

                return params;

            }


        };

        RequestQueue requestQueue  =Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    }

