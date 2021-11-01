package com.fikri.crudtestcustomer.dao;


import com.fikri.crudtestcustomer.model.Kota;
import com.fikri.crudtestcustomer.services.KotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class KotaDao implements KotaService {
    private EntityManagerFactory emf;
    //method setter
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Kota> listKota() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Kota", Kota.class).getResultList();
    }
    //implements method saveOrUpdate
    @Override
    public Kota saveOrUpdate(Kota kota) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        // method merge fungsinya untuk check di database, apabila belum ada maka akan create otomatis, apabila ada maka akan otomatis akan update
        Kota saved = em.merge(kota);
        em.getTransaction() .commit();
        return saved;
    }
    //implements method update
    @Override
    public Kota getIdKota(String id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Kota.class, id);
    }

    @Override
    public void hapus(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        em.remove(em.find(Kota.class, id));
        em.getTransaction() .commit();
    }
}

