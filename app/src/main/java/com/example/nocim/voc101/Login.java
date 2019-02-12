package com.example.nocim.voc101;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    TextView butonDoYou;
    TextView butonForget;
    EditText username, pass;
    TextView denemetext;
    Button login;
    Boolean dogrumu;
    CheckBox remember;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setTheme(R.style.wp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        butonDoYou = findViewById(R.id.doyou);
        username = findViewById(R.id.ID);
        pass = findViewById(R.id.Pass);
        login = findViewById(R.id.login);
        remember = findViewById(R.id.remember);

        denemetext = findViewById(R.id.denemeText);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String savedString = sharedPref.getString("stringGiris","Null");
        String savedPass = sharedPref.getString("stringPass","Null");



        if(savedString.equals("Null")){

            Toast.makeText(this, "Null Fonksiyonu", Toast.LENGTH_SHORT).show();

        }
        else
        {

            Toast.makeText(this, "Null Değil Fonksiyonu"+"ID: "+savedString+"Pass: "+savedPass, Toast.LENGTH_SHORT).show();
            username.setText(savedString);
            pass.setText(savedPass);
            login();

        }

        butonForget = findViewById(R.id.Forget);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                login();
            }
        });


        butonDoYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(Login.this, Register.class);
                startActivity(ıntent);
            }
        });

        butonForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);

                View mView = getLayoutInflater().inflate(R.layout.dialog_forget, null);

                builder.setView(mView);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });


    }

    private void login() {

        if (remember.isChecked()) {
            Toast.makeText(Login.this, "Hatırla", Toast.LENGTH_SHORT).show();

            SharedPreferences sharedPref = Login.this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("stringGiris", username.getText().toString());
            editor.putString("stringPass", pass.getText().toString());
            editor.commit(); //Kayıt.

        } else {

            Toast.makeText(Login.this, "Sadece giriş yap", Toast.LENGTH_SHORT).show();
        }

        String url = "http://35.242.201.109:3000/giris";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(Login.this, response.toString(), Toast.LENGTH_SHORT).show();


                if (response.equals("Success")) {

                    Toast.makeText(Login.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();


                } else if (response.equals("Wrong")) {

                    Toast.makeText(Login.this, "Hatalı giriş", Toast.LENGTH_SHORT).show();
                } else if (response.equals("NoUser")) {

                    Toast.makeText(Login.this, "NoUser girildi.", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "ErrorResponse", Toast.LENGTH_SHORT).show();
            }

        }

        ) {
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                params.put("username", username.getText().toString().trim());
                params.put("password", pass.getText().toString().trim());
                return params;

            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
