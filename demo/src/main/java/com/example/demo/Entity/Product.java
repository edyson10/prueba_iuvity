package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="categoria", nullable = false)
    private int categoria;

    @Column(name ="nombre", nullable = false)
    private String nombre;

    @Column(name ="cantidad", nullable = false)
    private int cantidad;

    @Column(name ="stock", nullable = false)
    private int stock;

    @Column(name ="precio_costo", nullable = false)
    private double precio_costo;

    @Column(name ="precio_venta", nullable = false)
    private double precio_venta;

    public Product(){

    }

    public Product(int categoria, String nombre, int cantidad, int stock, double precio_costo, double precio_venta) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
}
