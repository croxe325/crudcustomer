package com.fikri.crudtestcustomer.model;

public class CustEmpDto {

    public String id;
    public String nama;
    public String alamat;
    public String pendapatan;
    public String nama_kota;
    public Integer version;

    public CustEmpDto(String id, String nama, String alamat, String pendapatan, String nama_kota, Integer version) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.pendapatan = pendapatan;
        this.nama_kota = nama_kota;
        this.version = version;
    }

}
