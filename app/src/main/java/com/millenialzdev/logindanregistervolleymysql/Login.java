package com.millenialzdev.logindanregistervolleymysql;

import static android.app.PendingIntent.getActivity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private TextView ubah_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        ubah_pw = findViewById(R.id.ubah_password);

        ubah_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChangePassword.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                Gson gson = new Gson();

                if (! (username.isEmpty() || password.isEmpty())){

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, Db_Contract.urlLogin + "?username=" + username + "&password=" + password, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response != null) {
                                UserResponse userResponse = gson.fromJson(response.toString(), UserResponse.class);
                                if (userResponse.getCode() == 200) {
                                    List<User> userList = userResponse.getUser_list();
                                    User user = userList.get(0);
                                    Intent intent = new Intent(getApplicationContext(),UserLoginView.class);
                                    intent.putExtra("username", user.getUsername());
                                    intent.putExtra("password",user.getPassword());
                                    intent.putExtra("telepon", user.getNo_telepon());
                                    Toast.makeText(getApplicationContext(), "User : "+username, Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getApplicationContext(), "Login Gagal"+userResponse.getStatus(), Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(stringRequest);
                }else{
                    Toast.makeText(getApplicationContext(), "Password Atau Username Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
        private void login(User user) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", user.getUsername());
            startActivity(intent);

            Toast.makeText(this, "Berhasil Login sebagai " + user.getUsername(), Toast.LENGTH_SHORT).show();
        }
}
