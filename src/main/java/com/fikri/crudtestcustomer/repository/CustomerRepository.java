package com.fikri.crudtestcustomer.repository;

import com.fikri.crudtestcustomer.model.CustEmpDto;
import com.fikri.crudtestcustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
//    @Query("SELECT customer.id , customer.nama , customer.alamat , kota.nama as "Nama_kota" , customer.pendapatan from kota INNER JOIN customer ON kota.id_kota=customer.id;")
//    public String getJoinInformation();

    @Query("SELECT new com.fikri.crudtestcustomer.model.CustEmpDto(c.id, c.nama, c.alamat, c.pendapatan, k.nama, c.version) "
            + "FROM Customer c JOIN c.kota k")
    List<CustEmpDto> fetchCustDataJoin();


}
