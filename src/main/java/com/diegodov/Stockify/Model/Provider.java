package com.diegodov.Stockify.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "provider")
public class Provider {
    
    //Attributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "telephone")
    private String telephone;

    @Column (name = "date_initialize")
    private Date dateInitialize;

    @Column (name = "date_retired")
    private Date dateRetired;

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateInitialize() {
        return dateInitialize;
    }

    public void setDateInitialize(Date dateInitialize) {
        this.dateInitialize = dateInitialize;
    }

    public Date getDateRetired() {
        return dateRetired;
    }

    public void setDateRetired(Date dateRetired) {
        this.dateRetired = dateRetired;
    }

    //Constructor
    public Provider(String name, String telephone, Date dateInitialize, Date dateRetired) {
        this.name = name;
        this.telephone = telephone;
        this.dateInitialize = dateInitialize;
        this.dateRetired = dateRetired;
    }


}
