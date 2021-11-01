package com.fikri.crudtestcustomer.services;


import com.fikri.crudtestcustomer.model.Kota;

import java.util.List;

public interface KotaService {

    List<Kota> listKota();
    //khusus create
    Kota saveOrUpdate(Kota kota);
    //khusus update
    Kota getIdKota(String id);
    //khusus delete, lalu implements ke mahasiswa DAO
    void hapus(String id);
}


