package com.diegodov.Stockify.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "venta")
public class Venta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "cantidad")
    private int cantidad;

    @Column (name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product producto;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Client cliente;
    

    public Venta() {
        super();
    }

    public Venta(int cantidad, double precio, double total, Product producto, Client cliente) {
        super();
        this.cantidad = cantidad;
        this.total = total;
        this.producto = producto;
        this.cliente = cliente;
    }
}
