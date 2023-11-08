package com.millenialzdev.logindanregistervolleymysql;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class ChangePassword extends AppCompatActivity {
    private EditText etuUsername, etuPassword;
    private Button btn_changePassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etuUsername = findViewById(R.id.etuUsername);
        etuPassword = findViewById(R.id.etuPassword);
        btn_changePassword = findViewById(R.id.btnChangePassword);


        btn_changePassword.setOnClickListener(new View.OnClickListener() {

            String username = etuUsername.getText().toString();
            String password = etuPassword.getText().toString();
            @Override
            public void onClick(View view) {
                if (!(username.isEmpty() || password.isEmpty())){

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Db_Contract.urlUpdate, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), Login.class));
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    {
                        @Override
                        protected HashMap<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<>();
                            params.put("username", username);
                            params.put("password", password);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

                }else{
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
