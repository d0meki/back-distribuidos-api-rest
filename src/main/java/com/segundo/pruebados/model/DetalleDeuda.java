package com.segundo.pruebados.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_deudas")
public class DetalleDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int deuda_id;
    private String detalle_deuda;
    private float monto;

    public DetalleDeuda() {

    }

    public DetalleDeuda(int id, int deuda_id, String detalle_deuda, float monto) {
        this.id = id;
        this.deuda_id = deuda_id;
        this.detalle_deuda = detalle_deuda;
        this.monto = monto;
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

    public String getDetalle_deuda() {
        return detalle_deuda;
    }

    public void setDetalle_deuda(String detalle_deuda) {
        this.detalle_deuda = detalle_deuda;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

}
