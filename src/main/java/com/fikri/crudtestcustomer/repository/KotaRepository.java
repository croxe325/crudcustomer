package com.fikri.crudtestcustomer.repository;

import com.fikri.crudtestcustomer.model.Kota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KotaRepository extends JpaRepository<Kota,String> {
    List<Kota> findAll();

    /*@Query ("SELECT new com.fikri.crudtestcustomer.model.KotaEmpDto(k.id, k.name, c.email, e.address) "
            + "FROM Kota k LEFT JOIN k.id_kota c")
    List<KotaEmpDto> fetchEmpDeptDataLeftJoin();

    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d RIGHT JOIN d.employees e")
    List<KotaEmpDto> fetchEmpDeptDataRightJoin();*/

}
