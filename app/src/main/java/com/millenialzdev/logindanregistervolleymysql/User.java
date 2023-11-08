package com.millenialzdev.logindanregistervolleymysql;

public class User {
    private String username;
    private String password;
    private String jenis_kelamin;
    private String tanggal_lahir;
    private String nama_ayah;
    private String nama_ibu;
    private String no_telepon;
    private String berat_badan;
    private String tinggi_badan;
    private String alamat;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public String getBerat_badan() {
        return berat_badan;
    }

    public String getTinggi_badan() {
        return tinggi_badan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void setBerat_badan(String berat_badan) {
        this.berat_badan = berat_badan;
    }

    public void setTinggi_badan(String tinggi_badan) {
        this.tinggi_badan = tinggi_badan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public User() {
    }


}
