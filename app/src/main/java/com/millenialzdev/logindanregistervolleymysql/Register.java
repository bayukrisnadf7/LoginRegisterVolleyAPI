package com.millenialzdev.logindanregistervolleymysql;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.BreakIterator;
import java.util.Calendar;
import java.util.HashMap;

public class Register extends AppCompatActivity {

    private EditText etUsername, etPassword,etNama_ayah, etNama_ibu, etNo_telepon,etBerat_badan,etTinggi_badan, etAlamat, etTanggal_lahir;
    private Button btnRegister;
    private Activity view;

    DatePickerDialog picker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        Spinner spinner = findViewById(R.id.etJenis_kelamin);
        etTanggal_lahir = findViewById(R.id.etTanggal_lahir);
        etNama_ayah = findViewById(R.id.etNama_ayah);
        etNama_ibu = findViewById(R.id.etNama_ibu);
        etNo_telepon = findViewById(R.id.etNo_telepon);
        etBerat_badan = findViewById(R.id.etBerat_badan);
        etTinggi_badan = findViewById(R.id.etTinggi_badan);
        etAlamat = findViewById(R.id.etAlamat);

        btnRegister = findViewById(R.id.btnRegister);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"Laki - Laki", "Perempuan"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        etTanggal_lahir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Register.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etTanggal_lahir.setText(dayOfMonth  + "/" + (monthOfYear + 1)+ "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kadang isi dari textfield berupa object
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String jenis_kelamin = spinner.getSelectedItem().toString();
                String tanggal_lahir = etTanggal_lahir.getText().toString();
                String nama_ayah = etNama_ayah.getText().toString();
                String nama_ibu = etNama_ibu.getText().toString();
                String no_telepon = etNo_telepon.getText().toString();
                String berat_badan = etBerat_badan.getText().toString();
                String tinggi_badan = etTinggi_badan.getText().toString();
                String alamat = etAlamat.getText().toString();


                if (!(username.isEmpty() || password.isEmpty() || alamat.isEmpty())){

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Db_Contract.urlRegister, new Response.Listener<String>() {
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
                        protected HashMap<String, String> getParams() throws AuthFailureError{
                            HashMap<String, String> params = new HashMap<>();

                            params.put("username", username);
                            params.put("password", password);
                            params.put("jenis_kelamin", jenis_kelamin);
                            params.put("tanggal_lahir", tanggal_lahir);
                            params.put("nama_ayah", nama_ayah);
                            params.put("nama_ibu", nama_ibu);
                            params.put("no_telepon", no_telepon);
                            params.put("berat_badan", berat_badan);
                            params.put("tinggi_badan", tinggi_badan);
                            params.put("alamat", alamat);


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