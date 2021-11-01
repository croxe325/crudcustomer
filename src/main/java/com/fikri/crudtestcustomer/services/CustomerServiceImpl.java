package com.fikri.crudtestcustomer.services;

import com.fikri.crudtestcustomer.model.CustEmpDto;
import com.fikri.crudtestcustomer.model.Customer;

import com.fikri.crudtestcustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CustEmpDto> getCustJoin() {
        List<CustEmpDto> list = customerRepository.fetchCustDataJoin();
        return list;
    }
    @Override
    public List<Customer> listCustomer() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }
    //implements method saveOrUpdate
    @Override
    public Customer saveOrUpdate(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        // method merge fungsinya untuk check di database, apabila belum ada maka akan create otomatis, apabila ada maka akan otomatis akan update
        Customer saved = em.merge(customer);
        em.getTransaction() .commit();
        return saved;
    }
    //implements method update
    @Override
    public Customer getIdCustomer(String id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public void hapus(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction() .commit();
    }

}


