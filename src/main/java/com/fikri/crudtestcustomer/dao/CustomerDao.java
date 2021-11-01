package com.fikri.crudtestcustomer.dao;

import com.fikri.crudtestcustomer.model.Customer;
import com.fikri.crudtestcustomer.services.CustomerService;
import com.fikri.crudtestcustomer.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CustomerDao  {
/*
    private EntityManagerFactory emf;
    //method setter
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Customer> listCustomerJoin() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select c from Customer c JOIN Kota k where c.id_kota = k.id_kota", Customer.class).getResultList();
    }
*/



}



