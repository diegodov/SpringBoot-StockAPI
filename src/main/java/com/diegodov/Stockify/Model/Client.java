package com.diegodov.Stockify.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "telephone", length = 45)
    private String telephone;

    @Column(name = "ruc", length = 8)
    private int ruc;

    @Column(name = "razon_social", length = 45)
    private String razonSocial;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Client() {
        super();
    }

    public Client(Long id, String name, String lastName, String telephone, int ruc, String razonSocial) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public Client(String name, String lastName, String telephone, int ruc, String razonSocial) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    
}
