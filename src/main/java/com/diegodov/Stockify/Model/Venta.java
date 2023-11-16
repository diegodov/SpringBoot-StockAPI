package com.diegodov.Stockify.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "venta")
public class Venta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "cantidad")
    private int cantidad;
    
    @Column (name = "precio")
    private double precio;
    
    @Column (name = "total")
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product producto;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = producto.getCost();
    }

    public Venta() {
        super();
    }

    public Venta(Product product, int cantidad, double precio, double total, Client client) {
        super();
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.producto = product;
        this.client = client;
    }
}
