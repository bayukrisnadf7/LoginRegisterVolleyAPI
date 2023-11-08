package com.millenialzdev.logindanregistervolleymysql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> objects){
        super (context, 0, objects);
    }
    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        User user = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from((getContext())).inflate(R.layout.activity_user, parent, false);
        }

        TextView username = convertView.findViewById(R.id.au_username);
        TextView password = convertView.findViewById(R.id.au_password);
        TextView jenis_kelamin = convertView.findViewById(R.id.au_jenis_kelamin);
        TextView tanggal_lahir = convertView.findViewById(R.id.au_tanggal_lahir);
        TextView nama_ayah = convertView.findViewById(R.id.au_nama_ayah);
        TextView nama_ibu = convertView.findViewById(R.id.au_nama_ibu);
        TextView no_telepon = convertView.findViewById(R.id.au_no_telepon);
        TextView berat_badan = convertView.findViewById(R.id.au_berat_badan);
        TextView tinggi_badan = convertView.findViewById(R.id.au_tinggi_badan);
        TextView alamat = convertView.findViewById(R.id.au_alamat);


        username.setText(user.getUsername());
        password.setText(user.getPassword());
        jenis_kelamin.setText(user.getJenis_kelamin());
        tanggal_lahir.setText(user.getTanggal_lahir());
        nama_ayah.setText(user.getNama_ayah());
        nama_ibu.setText(user.getNama_ibu());
        no_telepon.setText(user.getNo_telepon());
        berat_badan.setText(user.getBerat_badan());
        tinggi_badan.setText(user.getTinggi_badan());
        alamat.setText(user.getAlamat());

        return convertView;
    }

}

