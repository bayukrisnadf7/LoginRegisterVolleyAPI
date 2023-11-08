package com.millenialzdev.logindanregistervolleymysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserLoginView extends AppCompatActivity {

    TextView uname,pw,telp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_view);

        uname = findViewById(R.id.get_uname);
        pw = findViewById(R.id.get_pw);
        telp = findViewById(R.id.get_telp);

        Intent intent = this.getIntent();
        String Username = (String) intent.getSerializableExtra("username");
        String Pw = (String) intent.getSerializableExtra("password");
        String Tlp = (String) intent.getSerializableExtra("telepon");

        uname.setText(Username);
        pw.setText(Pw);
        telp.setText(Tlp);
        Toast.makeText(getApplicationContext(),Username+Pw+Tlp, Toast.LENGTH_LONG).show();

    }
}