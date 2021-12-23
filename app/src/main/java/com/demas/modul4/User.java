package com.demas.modul4;


public class User {

    private int id;
    private String namaLengkap;
    private String tglSewa;
    private String umur;
    private String gender;
    private String penyewaan;



    public int getId() {return id;}

    public void setId(int id) {this.id =id; }

    public String getNamaLengkap() { return namaLengkap;}

    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap;}

    public String getTglSewa() { return tglSewa;}

    public void setTglSewa(String tglLahir) { this.tglSewa = tglLahir;}

    public String getUmur() { return umur;}

    public void setUmur(String umur) { this.umur = umur;}

    public String getGender() { return gender;}

    public void setGender(String gender) { this.gender = gender;}

    public String getPenyewaan() { return penyewaan;}

    public void setService(String service) { this.penyewaan = service;}

}
