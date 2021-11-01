package com.fikri.crudtestcustomer.services;

import com.fikri.crudtestcustomer.model.Customer;
import com.fikri.crudtestcustomer.model.Kota;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> listCustomer();
    //khusus create
    Customer saveOrUpdate(Customer customer);
    //khusus update
    Customer getIdCustomer(String id);
    //khusus delete, lalu implements ke mahasiswa DAO
    void hapus(String id);
  
}
