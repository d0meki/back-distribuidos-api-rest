package com.segundo.pruebados.model;

import java.sql.Date;

public class PagoDeuda {
    private int id;
    private int deuda_id;
    private Date fecha_pago;
    private float monto;
    private String name;
    public PagoDeuda(int id, int deuda_id, Date fecha_pago, float monto, String name) {
        this.id = id;
        this.deuda_id = deuda_id;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDeuda_id() {
        return deuda_id;
    }
    public void setDeuda_id(int deuda_id) {
        this.deuda_id = deuda_id;
    }
    public Date getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

    // private String titulo;
    // private float total;
    // private int id;
    // private float monto;
    // public PagoDeuda(String titulo, float total, int id, float monto) {
    //     this.titulo = titulo;
    //     this.total = total;
    //     this.id = id;
    //     this.monto = monto;
    // }
    // public String getTitulo() {
    //     return titulo;
    // }
    // public void setTitulo(String titulo) {
    //     this.titulo = titulo;
    // }
    // public float getTotal() {
    //     return total;
    // }
    // public void setTotal(float total) {
    //     this.total = total;
    // }
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public float getMonto() {
    //     return monto;
    // }
    // public void setMonto(float monto) {
    //     this.monto = monto;
    // }
    
}
