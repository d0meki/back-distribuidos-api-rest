package com.segundo.pruebados.model;

public class Detalle {
  
    private int id;
    private int deuda_id;
    private float monto;
    private String descripcion;

    
    public Detalle(int id, int deuda_id, float monto, String descripcion) {
        this.id = id;
        this.deuda_id = deuda_id;
        this.monto = monto;
        this.descripcion = descripcion;
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Detalle() {

    }
}
