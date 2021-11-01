package com.fikri.crudtestcustomer.model;

import com.fikri.crudtestcustomer.generators.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
            name = "book_seq",
            strategy = "com.fikri.crudtestcustomer.generators.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter (name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "5"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

    private String id;

    @NotNull (message = "Nama can not be null!!")
    @NotEmpty (message = "Nama can not be empty!!")
    private String nama;

    @Column(nullable = false)
    @NotNull (message = "Alamat can not be null!!")
    @NotEmpty (message = "Alamat can not be empty!!")
    private String alamat;
    @NotEmpty (message = "Pendapatan can not be empty")
    @NotNull (message = "Pendapatan hanya dapat diisi dengan angka")
    private String pendapatan;
    @Version
    @Column(name ="optVersion", columnDefinition = "string DEFAULT 0")
    private Integer version;
    private String id_kota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kota", insertable = false, updatable = false)
    @Fetch ( FetchMode.JOIN)
    private Kota kota;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String  getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getId_kota() {
        return id_kota;
    }

    public void setId_kota(String id_kota) {
        this.id_kota = id_kota;
    }

    public String toString() {
        return "Customer(Name: " + this.nama + ", Alamat: " + this.alamat +", Pendapatan: " + this.pendapatan +")";
    }



}
