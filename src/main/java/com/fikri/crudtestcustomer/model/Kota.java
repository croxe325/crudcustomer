package com.fikri.crudtestcustomer.model;

import com.fikri.crudtestcustomer.generators.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Kota  {
    @Id
    private String id_kota;
    @Column(nullable = false)
    private String nama;
    @Version
    @Column(name ="optVersion", columnDefinition = "integer DEFAULT 0")
    private Integer version;

    @OneToMany(targetEntity = Customer.class, mappedBy = "id_kota", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Customer> customers;

    public String getId_kota() {
        return id_kota;
    }

    public void setId_kota(String id_kota) {
        this.id_kota = id_kota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
