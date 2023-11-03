package com.diegodov.Stockify.Model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "product")
public class Product {

    //Attributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "cost")
    private double cost;

    @Column (name = "stock")
    private int stock;

    @Column (name = "date_getted")
    private LocalDate dateGetted;

    @Column (name = "date_expired")
    private Date dateExpired;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getDateGetted() {
        return dateGetted;
    }

    public void setDateGetted(LocalDate dateGetted) {
        this.dateGetted = dateGetted;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Product(String name, double cost, int stock, LocalDate dateGetted, Date dateExpired, Category category,
            Provider provider) {
        this.name = name;
        this.cost = cost;
        this.stock = stock;
        this.dateGetted = dateGetted;
        this.dateExpired = dateExpired;
        this.category = category;
        this.provider = provider;
    }

    public Product() {
        super();
    }
}
