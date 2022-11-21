package com.segundo.pruebados.model;

public class PagoDeuda {
    private String titulo;
    private float total;
    private int id;
    private float monto;
    public PagoDeuda(String titulo, float total, int id, float monto) {
        this.titulo = titulo;
        this.total = total;
        this.id = id;
        this.monto = monto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }
    
}
