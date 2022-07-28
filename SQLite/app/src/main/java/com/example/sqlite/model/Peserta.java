package com.example.sqlite.model;

public class Peserta {
    private long id;
    private String nip;
    private String nama;
    private String email;
    private String instansi;

    public Peserta() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNIP() {
        return nip;
    }

    public void setNIP(String NIP) {
        this.nip = NIP;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    @Override
    public String toString() {
        return "Peserta{" +
                "id=" + id +
                ", NIP='" + nip + '\'' +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", instansi='" + instansi + '\'' +
                '}';
    }
}
